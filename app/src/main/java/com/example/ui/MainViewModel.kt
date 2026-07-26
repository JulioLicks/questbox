package com.example.ui
import com.example.data.model.Phase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.ProjectCardEntryEntity
import com.example.data.local.ProjectEntity
import com.example.data.local.DiarioDeBordoEntity
import com.example.data.local.UserProfileEntity
import com.example.data.model.Area
import com.example.data.model.Challenge
import com.example.data.model.QuestboxData
import com.example.data.model.ToolCard
import com.example.data.repository.GeminiRepository
import com.example.data.repository.ProjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.json.JSONObject

sealed class Screen(val route: String, val title: String) {
    object Board : Screen("board", "Área de Trabalho")
    object Challenges : Screen("challenges", "Desafios")
    object ToolCards : Screen("tool_cards", "Ferramentas")
    object Projects : Screen("projects", "Meus Projetos")
    object ProjectDetail : Screen("project_detail", "Espaço do Projeto")
    object ProfileAndGuide : Screen("profile_and_guide", "Ajuda")
}

data class AiState(
    val isLoading: Boolean = false,
    val thinkingStatusText: String = "",
    val lastResponse: String? = null,
    val errorMessage: String? = null
)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    val projectRepository = ProjectRepository(db.projectDao())
    val geminiRepository = GeminiRepository()

    private val _currentScreen = MutableStateFlow<Screen>(Screen.Board)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _isGridLayout = MutableStateFlow(true)
    val isGridLayout: StateFlow<Boolean> = _isGridLayout.asStateFlow()

    fun toggleLayout() { _isGridLayout.value = !_isGridLayout.value }
    fun toggleGridLayout() {
        _isGridLayout.value = !_isGridLayout.value
    }

    private val _userProfile = MutableStateFlow<UserProfileEntity?>(null)
    var activeAreaFilter: Area? = null
    var activePhaseFilter: Phase? = null
    val userProfile: StateFlow<UserProfileEntity?> = _userProfile.asStateFlow()

    private val _projects = MutableStateFlow<List<ProjectEntity>>(emptyList())
    val projects: StateFlow<List<ProjectEntity>> = _projects.asStateFlow()

    private val _selectedProjectId = MutableStateFlow<Long?>(null)
    val selectedProjectId: StateFlow<Long?> = _selectedProjectId.asStateFlow()

    private val _selectedProject = MutableStateFlow<ProjectEntity?>(null)
    val selectedProject: StateFlow<ProjectEntity?> = _selectedProject.asStateFlow()

    private val _activeProjectEntries = MutableStateFlow<List<ProjectCardEntryEntity>>(emptyList())
    val activeProjectEntries: StateFlow<List<ProjectCardEntryEntity>> = _activeProjectEntries.asStateFlow()

    private val _activeProjectLogs = MutableStateFlow<List<DiarioDeBordoEntity>>(emptyList())
    val activeProjectLogs: StateFlow<List<DiarioDeBordoEntity>> = _activeProjectLogs.asStateFlow()

    private val _selectedCardForEditing = MutableStateFlow<ToolCard?>(null)
    val selectedCardForEditing: StateFlow<ToolCard?> = _selectedCardForEditing.asStateFlow()

    private val _aiState = MutableStateFlow(AiState())
    val aiState: StateFlow<AiState> = _aiState.asStateFlow()

    init {
        viewModelScope.launch {
            projectRepository.ensureProfileExists()
            projectRepository.getUserProfile().collectLatest { profile ->
                _userProfile.value = profile
            }
        }

        viewModelScope.launch {
            projectRepository.getAllProjects().collectLatest { projList ->
                _projects.value = projList
                if (_selectedProjectId.value != null) {
                    _selectedProject.value = projList.find { it.id == _selectedProjectId.value }
                }
            }
        }
    }

    fun navigateTo(screen: Screen) {
        _currentScreen.value = screen
    }

    fun selectProject(projectId: Long) {
        _selectedProjectId.value = projectId
        _selectedProject.value = _projects.value.find { it.id == projectId }

        viewModelScope.launch {
            projectRepository.getCardEntriesForProject(projectId).collectLatest { entries ->
                _activeProjectEntries.value = entries
            }
        }
        viewModelScope.launch {
            projectRepository.getDiarioEntriesForProject(projectId).collectLatest { logs ->
                _activeProjectLogs.value = logs
            }
        }
        navigateTo(Screen.ProjectDetail)
    }

    fun startChallengeProject(challenge: Challenge, customTitle: String? = null) {
        viewModelScope.launch {
            val title = customTitle ?: "Projeto ${challenge.title}"
            val projId = projectRepository.createProject(
                title = title,
                challengeCode = challenge.code,
                description = challenge.description,
                areaCode = challenge.areaCode,
                initialCardCodes = challenge.requiredCardCodes
            )
            selectProject(projId)
        }
    }

    fun createCustomProject(title: String, description: String, areaCode: String, cardCodes: List<String>) {
        viewModelScope.launch {
            val projId = projectRepository.createProject(
                title = title,
                challengeCode = "CUSTOM",
                description = description,
                areaCode = areaCode,
                initialCardCodes = cardCodes
            )
            selectProject(projId)
        }
    }

    fun setSelectedCardForEditing(card: ToolCard?) {
        _selectedCardForEditing.value = card
    }

    fun saveCardEntryData(projectId: Long, cardCode: String, isCompleted: Boolean, fieldData: Map<String, String>) {
        viewModelScope.launch {
            projectRepository.saveCardEntry(projectId, cardCode, isCompleted, fieldData)
        }
    }

    fun addCardToActiveProject(cardCode: String) {
        val projId = _selectedProjectId.value ?: return
        viewModelScope.launch {
            projectRepository.addCardToProject(projId, cardCode)
        }
    }

    fun deleteProject(projectId: Long) {
        viewModelScope.launch {
            projectRepository.deleteProject(projectId)
            if (_selectedProjectId.value == projectId) {
                _selectedProjectId.value = null
                _selectedProject.value = null
                _activeProjectEntries.value = emptyList()
                navigateTo(Screen.Projects)
            }
        }
    }

    // --- Gemini 3.1 Pro High Thinking Actions ---

    fun askAiAdvisor(userPrompt: String) {
        if (userPrompt.isBlank()) return
        _aiState.value = AiState(isLoading = true, thinkingStatusText = "Pensando profundamente com Gemini 3.1 Pro (High Thinking)...")

        viewModelScope.launch {
            val currentProj = _selectedProject.value
            val contextText = if (currentProj != null) {
                "Projeto Ativo Atual: '${currentProj.title}' (Desafio: ${currentProj.challengeCode}, Área: ${currentProj.areaCode})."
            } else ""

            val fullPrompt = "$contextText\nPergunta do Usuário: $userPrompt"

            val result = geminiRepository.generateHighThinkingResponse(fullPrompt)
            result.onSuccess { responseText ->
                _aiState.value = AiState(isLoading = false, lastResponse = responseText)
            }.onFailure { err ->
                _aiState.value = AiState(isLoading = false, errorMessage = err.message ?: "Erro desconhecido na resposta da IA.")
            }
        }
    }

    fun autoGenerateProjectWithAi(projectIdea: String) {
        if (projectIdea.isBlank()) return
        _aiState.value = AiState(isLoading = true, thinkingStatusText = "Analisando escopo e criando mapa Questbox com High Thinking...")

        viewModelScope.launch {
            val res = geminiRepository.generateProjectMapSuggestion(projectIdea)
            res.onSuccess { suggestion ->
                val newProjId = projectRepository.createProject(
                    title = "Projeto: ${projectIdea.take(25)}...",
                    challengeCode = suggestion.recommendedChallengeCode,
                    description = suggestion.strategicSummary,
                    areaCode = suggestion.recommendedAreaCode,
                    initialCardCodes = suggestion.suggestedCardCodes,
                    drafts = suggestion.cardDrafts
                )
                _aiState.value = AiState(
                    isLoading = false,
                    lastResponse = "✨ Projeto gerado com sucesso!\n\n${suggestion.strategicSummary}\n\nCards selecionados: ${suggestion.suggestedCardCodes.joinToString(", ")}"
                )
                selectProject(newProjId)
            }.onFailure { err ->
                _aiState.value = AiState(isLoading = false, errorMessage = err.message ?: "Erro ao gerar projeto com IA.")
            }
        }
    }

    fun generateCardSuggestionsWithAi(card: ToolCard, currentFieldData: Map<String, String>) {
        _aiState.value = AiState(isLoading = true, thinkingStatusText = "Gerando ideias inteligentes para o card ${card.code} (${card.title})...")

        viewModelScope.launch {
            val currentProj = _selectedProject.value
            val projContext = currentProj?.let { "Projeto: ${it.title} (${it.description})" } ?: "Projeto Geral"

            val prompt = """
                Atue como Mentor do Questbox.
                Contexto do $projContext.
                Estamos preenchendo o Card ${card.code} - ${card.title} (${card.question}).
                Campos do Card: ${card.formFields.joinToString(", ")}.
                
                Gere sugestões práticas e claras para preencher estes campos.
                Responda em formato de lista simples correspondente a cada campo.
            """.trimIndent()

            val res = geminiRepository.generateHighThinkingResponse(prompt)
            res.onSuccess { responseText ->
                _aiState.value = AiState(isLoading = false, lastResponse = responseText)
            }.onFailure { err ->
                _aiState.value = AiState(isLoading = false, errorMessage = err.message ?: "Erro ao gerar sugestões do card.")
            }
        }
    }

    fun updateUserProfileData(
        name: String,
        roleCode: String,
        areaCode: String,
        sentir: Int,
        pensar: Int,
        agir: Int,
        vInterna: Int,
        vExterna: Int,
        vIntegral: Int
    ) {
        viewModelScope.launch {
            val current = _userProfile.value ?: UserProfileEntity()
            val updated = current.copy(
                name = name,
                roleCode = roleCode,
                areaCode = areaCode,
                attrSentir = sentir,
                attrPensar = pensar,
                attrAgir = agir,
                attrVisaoInterna = vInterna,
                attrVisaoExterna = vExterna,
                attrVisaoIntegral = vIntegral
            )
            projectRepository.updateUserProfile(updated)
        }
    }

    fun parseFieldJson(jsonStr: String): Map<String, String> {
        return try {
            val map = mutableMapOf<String, String>()
            val obj = JSONObject(jsonStr)
            val keys = obj.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                map[key] = obj.getString(key)
            }
            map
        } catch (e: Exception) {
            emptyMap()
        }
    }
}
