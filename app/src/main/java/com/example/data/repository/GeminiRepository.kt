package com.example.data.repository

import com.example.BuildConfig
import com.example.data.model.QuestboxData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

class GeminiRepository {

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private val JSON = "application/json; charset=utf-8".toMediaType()

    suspend fun generateHighThinkingResponse(
        prompt: String,
        systemInstruction: String = "Você é o Mentor IA do Questbox, especialista em gestão e criação de projetos visual, inovação e estruturação de cards."
    ): Result<String> = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isEmpty() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext Result.failure(
                IllegalStateException("Chave da API Gemini não configurada. Adicione GEMINI_API_KEY no painel Secrets.")
            )
        }

        val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.1-pro-preview:generateContent?key=$apiKey"

        try {
            val root = JSONObject().apply {
                // Contents
                val contentsArray = JSONArray().apply {
                    val contentObj = JSONObject().apply {
                        val partsArray = JSONArray().apply {
                            put(JSONObject().apply { put("text", prompt) })
                        }
                        put("parts", partsArray)
                    }
                    put(contentObj)
                }
                put("contents", contentsArray)

                // High Thinking Config
                val generationConfigObj = JSONObject().apply {
                    val thinkingConfigObj = JSONObject().apply {
                        put("thinkingLevel", "high")
                    }
                    put("thinkingConfig", thinkingConfigObj)
                }
                put("generationConfig", generationConfigObj)

                // System Instruction
                val systemInstructionObj = JSONObject().apply {
                    val sysPartsArray = JSONArray().apply {
                        put(JSONObject().apply { put("text", systemInstruction) })
                    }
                    put("parts", sysPartsArray)
                }
                put("systemInstruction", systemInstructionObj)
            }

            val requestBody = root.toString().toRequestBody(JSON)
            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            client.newCall(request).execute().use { response ->
                val responseStr = response.body?.string() ?: ""
                if (!response.isSuccessful) {
                    val errorMsg = try {
                        val errObj = JSONObject(responseStr)
                        errObj.optJSONObject("error")?.optString("message") ?: responseStr
                    } catch (e: Exception) {
                        responseStr
                    }
                    return@withContext Result.failure(Exception("Erro HTTP ${response.code}: $errorMsg"))
                }

                val jsonResp = JSONObject(responseStr)
                val candidates = jsonResp.optJSONArray("candidates")
                if (candidates == null || candidates.length() == 0) {
                    return@withContext Result.failure(Exception("Nenhuma resposta gerada pelo modelo."))
                }

                val firstCand = candidates.getJSONObject(0)
                val contentObj = firstCand.optJSONObject("content")
                val partsArray = contentObj?.optJSONArray("parts")

                if (partsArray == null || partsArray.length() == 0) {
                    return@withContext Result.failure(Exception("Resposta vazia do modelo."))
                }

                val textBuilder = StringBuilder()
                for (i in 0 until partsArray.length()) {
                    val part = partsArray.getJSONObject(i)
                    if (part.has("text")) {
                        val text = part.getString("text")
                        if (text.isNotBlank()) {
                            textBuilder.append(text).append("\n")
                        }
                    }
                }

                val resultText = textBuilder.toString().trim()
                if (resultText.isEmpty()) {
                    Result.failure(Exception("O modelo não retornou texto válido."))
                } else {
                    Result.success(resultText)
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun generateProjectMapSuggestion(projectDescription: String): Result<ProjectMapSuggestion> {
        val allCardsInfo = QuestboxData.TOOL_CARDS.joinToString("\n") {
            "${it.code}: ${it.title} (${it.phase.title}) - ${it.question}"
        }

        val prompt = """
            Análise e Estruturação do Projeto Questbox (Deep Thinking):
            Visão do Usuário: "$projectDescription"
            
            Lista de Ferramentas Questbox Disponíveis:
            $allCardsInfo
            
            Instruções:
            1. Pense profundamente sobre a melhor estratégia para concretizar este projeto usando a metodologia Questbox.
            2. Escolha de 6 a 10 ferramentas (cards F1 a F54) ideais em sequência lógica.
            3. Para cada card escolhido, forneça uma sugestão inicial curta e prática preenchendo o principal campo do card.
            4. Responda ESTRITAMENTE em formato JSON com a seguinte estrutura:
            {
              "recommendedChallengeCode": "D13",
              "recommendedAreaCode": "AR5",
              "strategicSummary": "Explicação resumida do mapa proposto.",
              "suggestedCardCodes": ["F1", "F3", "F13", "F19", "F20", "F25", "F43"],
              "cardDrafts": [
                {"cardCode": "F1", "draftText": "Objetivo: Criar uma plataforma digital para artesanato local."},
                {"cardCode": "F3", "draftText": "Demandas: Artesãos precisam de visibilidade e frete fácil."},
                {"cardCode": "F13", "draftText": "Público: Amantes de decoração e presentes feitos à mão."},
                {"cardCode": "F19", "draftText": "Ideia: Marketplace com frete calculado e selo de origem."},
                {"cardCode": "F20", "draftText": "Proposta: Conectar artesãos diretamente a compradores em todo o Brasil."},
                {"cardCode": "F25", "draftText": "Custos: Hospedagem de servidores e taxa de meio de pagamento."},
                {"cardCode": "F43", "draftText": "Tarefas: 1. Cadastrar 10 artesãos piloto. 2. Lançar página web."}
              ]
            }
        """.trimIndent()

        val sysInst = "Você é o Arquiteto de Projetos Questbox alimentado pelo modelo Gemini 3.1 Pro com High Thinking. Responda exclusivamente em JSON limpo sem blocos markdown extras."

        val res = generateHighThinkingResponse(prompt, sysInst)
        return res.mapCatching { jsonText ->
            val cleanJson = jsonText.replace("```json", "").replace("```", "").trim()
            val obj = JSONObject(cleanJson)

            val recChallenge = obj.optString("recommendedChallengeCode", "D13")
            val recArea = obj.optString("recommendedAreaCode", "AR5")
            val summary = obj.optString("strategicSummary", "Mapa personalizado sugerido pela IA.")

            val cardCodes = mutableListOf<String>()
            val cardCodesArray = obj.optJSONArray("suggestedCardCodes")
            if (cardCodesArray != null) {
                for (i in 0 until cardCodesArray.length()) {
                    cardCodes.add(cardCodesArray.getString(i))
                }
            }

            val draftsMap = mutableMapOf<String, String>()
            val draftsArray = obj.optJSONArray("cardDrafts")
            if (draftsArray != null) {
                for (i in 0 until draftsArray.length()) {
                    val dObj = draftsArray.getJSONObject(i)
                    val code = dObj.optString("cardCode")
                    val draft = dObj.optString("draftText")
                    if (code.isNotBlank() && draft.isNotBlank()) {
                        draftsMap[code] = draft
                    }
                }
            }

            ProjectMapSuggestion(recChallenge, recArea, summary, cardCodes, draftsMap)
        }
    }
}

data class ProjectMapSuggestion(
    val recommendedChallengeCode: String,
    val recommendedAreaCode: String,
    val strategicSummary: String,
    val suggestedCardCodes: List<String>,
    val cardDrafts: Map<String, String>
)
