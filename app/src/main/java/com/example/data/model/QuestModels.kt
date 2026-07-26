package com.example.data.model

import androidx.compose.ui.graphics.Color

enum class Phase(
    val title: String,
    val subtitle: String,
    val color: Color,
    val hexColor: String,
    val attributesText: String,
    val iconName: String
) {
    DIAGNOSTICO(
        title = "Diagnóstico",
        subtitle = "Olhar para dentro e sentir",
        color = Color(0xFFE53935),
        hexColor = "#E53935",
        attributesText = "Sentir & Visão Interna",
        iconName = "favorite"
    ),
    PLANEJAMENTO(
        title = "Planejamento",
        subtitle = "Olhar para os outros e pensar",
        color = Color(0xFFFFC107),
        hexColor = "#FFC107",
        attributesText = "Pensar & Visão Externa",
        iconName = "psychology"
    ),
    REALIZACAO(
        title = "Realização",
        subtitle = "Olhar para o mundo e agir",
        color = Color(0xFF1565C0),
        hexColor = "#1565C0",
        attributesText = "Agir & Visão Integral",
        iconName = "bolt"
    ),
    GERENCIAMENTO(
        title = "Gerenciamento",
        subtitle = "Acompanhamento e suporte",
        color = Color(0xFF8E24AA),
        hexColor = "#8E24AA",
        attributesText = "Bússola, Mapa & Controle",
        iconName = "dashboard"
    ),
    DESAFIO(
        title = "Desafios",
        subtitle = "Objetivos e receitas de mapas",
        color = Color(0xFF43A047),
        hexColor = "#43A047",
        attributesText = "Receitas de Projetos",
        iconName = "flag"
    ),
    AJUDA(
        title = "Ajuda",
        subtitle = "Instruções e regras",
        color = Color(0xFFFB8C00),
        hexColor = "#FB8C00",
        attributesText = "Visão geral",
        iconName = "help"
    )
}

enum class Area(
    val code: String,
    val title: String,
    val description: String,
    val problemsSummary: String,
    val defaultRoleCode: String,
    val color: Color
) {
    AR1(
        code = "AR1",
        title = "Desenvolvimento Humano",
        description = "Cuida do ser humano, da pessoa, do indivíduo, com um ser integral nos seus aspectos emocional, mental, físico e espiritual.",
        problemsSummary = "Excesso de controle, pressão, falta de liberdade, baixa auto-estima e desinformação.",
        defaultRoleCode = "P1",
        color = Color(0xFFE53935)
    ),
    AR2(
        code = "AR2",
        title = "Comunicação",
        description = "Cuida da comunicação entre as pessoas, quando precisam se alinhar para trabalharem juntas e tomarem decisões.",
        problemsSummary = "Conflitos, falta de alinhamento, ruídos na comunicação e fofocas.",
        defaultRoleCode = "P2",
        color = Color(0xFFFB8C00)
    ),
    AR3(
        code = "AR3",
        title = "Trabalho em Equipe",
        description = "Cuida da relação de trabalho entre as pessoas, considerando os líderes e gestores, e o nível de autonomia.",
        problemsSummary = "Competitividade, individualismo, falta de engajamento e regras confusas.",
        defaultRoleCode = "P3",
        color = Color(0xFFFFC107)
    ),
    AR4(
        code = "AR4",
        title = "Educação",
        description = "Cuida do ensino e do aprendizado, considerando instrutor e aluno, seus métodos e ferramentas.",
        problemsSummary = "Falta de motivação, desânimo diante de dificuldades e despreparo.",
        defaultRoleCode = "P4",
        color = Color(0xFF43A047)
    ),
    AR5(
        code = "AR5",
        title = "Projetos",
        description = "Cuida da criação de projetos, reunindo as ferramentas para desenhar e materializar um produto ou negócio.",
        problemsSummary = "Estagnação, falta de ideias, metas confusas e atrasos.",
        defaultRoleCode = "P5",
        color = Color(0xFF1565C0)
    ),
    AR6(
        code = "AR6",
        title = "Gestão",
        description = "Cuida da gestão de recursos, dinheiro e tempo, garantindo a sustentabilidade do projeto.",
        problemsSummary = "Escassez de dinheiro e recursos, prazos apertados e mau gerenciamento.",
        defaultRoleCode = "P6",
        color = Color(0xFF8E24AA)
    )
}

data class Role(
    val code: String,
    val title: String,
    val motto: String,
    val principle: String,
    val actions: String,
    val areaCode: String,
    val primarySkill: String,
    val color: Color
)

data class ToolCard(
    val code: String,
    val title: String,
    val question: String,
    val phase: Phase,
    val durationMinutes: Int = 5,
    val xpPoints: Int = 5,
    val sockets: List<String>,
    val formFields: List<String>,
    val tip: String = "",
    val helpCode: String = "",
    val defaultMap: List<String> = emptyList(),
    val backContent: String = "",
    val backTip: String = ""
)

data class Challenge(
    val code: String,
    val title: String,
    val areaCode: String,
    val subtitle: String,
    val durationMinutes: Int,
    val xpPoints: Int,
    val requiredCardCodes: List<String>,
    val description: String,
    val helpCardCode: String = "A8",
    val sockets: List<String> = emptyList(),
    val backContent: String = "",
    val backTip: String = ""
)

data class ManagementCard(
    val code: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val question: String = "",
    val durationMinutes: Int = 5,
    val xpPoints: Int = 5,
    val sockets: List<String> = emptyList(),
    val formFields: List<String> = emptyList(),
    val tip: String = "",
    val backContent: String = "",
    val backTip: String = ""
)

data class HelpCard(
    val code: String,
    val title: String,
    val question: String = "",
    val summary: String,
    val content: String,
    val tip: String = "",
    val durationMinutes: Int = 5,
    val xpPoints: Int = 5,
    val sockets: List<String> = emptyList(),
    val backContent: String = "",
    val backTip: String = ""
)

sealed class UniversalCard {
    data class Tool(val toolCard: ToolCard) : UniversalCard()
    data class Help(val helpCard: HelpCard) : UniversalCard()
    data class ChallengeCard(val challenge: Challenge) : UniversalCard()
    data class Management(val managementCard: ManagementCard) : UniversalCard()

    val code: String get() = when(this) {
        is Tool -> toolCard.code
        is Help -> helpCard.code
        is ChallengeCard -> challenge.code
        is Management -> managementCard.code
    }

    val title: String get() = when(this) {
        is Tool -> toolCard.title
        is Help -> helpCard.title
        is ChallengeCard -> challenge.title
        is Management -> managementCard.title
    }

    val questionOrSubtitle: String get() = when(this) {
        is Tool -> toolCard.question
        is Help -> if (helpCard.question.isNotBlank()) helpCard.question else helpCard.summary
        is ChallengeCard -> challenge.subtitle
        is Management -> if (managementCard.question.isNotBlank()) managementCard.question else managementCard.subtitle
    }

    val typeLabel: String get() = when(this) {
        is Tool -> toolCard.phase.title.uppercase()
        is Help -> "AJUDA"
        is ChallengeCard -> "DESAFIO"
        is Management -> "GERENCIAMENTO"
    }

    val headerColor: Color get() = when(this) {
        is Tool -> toolCard.phase.color
        is Help -> Color(0xFFFB8C00)
        is ChallengeCard -> Color(0xFF43A047)
        is Management -> Color(0xFF8E24AA)
    }

    val sockets: List<String> get() = when(this) {
        is Tool -> toolCard.sockets
        is Help -> helpCard.sockets
        is ChallengeCard -> (challenge.sockets + challenge.requiredCardCodes).distinct()
        is Management -> managementCard.sockets
    }

    val durationMinutes: Int get() = when(this) {
        is Tool -> toolCard.durationMinutes
        is Help -> helpCard.durationMinutes
        is ChallengeCard -> challenge.durationMinutes
        is Management -> managementCard.durationMinutes
    }

    val xpPoints: Int get() = when(this) {
        is Tool -> toolCard.xpPoints
        is Help -> helpCard.xpPoints
        is ChallengeCard -> challenge.xpPoints
        is Management -> managementCard.xpPoints
    }

    val formFields: List<String> get() = when(this) {
        is Tool -> toolCard.formFields
        is Help -> emptyList()
        is ChallengeCard -> emptyList()
        is Management -> managementCard.formFields
    }

    val tip: String get() = when(this) {
        is Tool -> toolCard.tip
        is Help -> helpCard.tip
        is ChallengeCard -> "Siga o mapa e complete os cards sugeridos para este desafio."
        is Management -> managementCard.tip
    }

    val backContent: String get() = when(this) {
        is Tool -> if (toolCard.backContent.isNotBlank()) toolCard.backContent else "Orientações e modo de aplicação do card ${toolCard.code}:\n\n1. Leia a pergunta principal com atenção.\n2. Reúna a equipe ou faça uma reflexão individual.\n3. Preencha os campos solicitados no mapa do projeto.\n4. Conecte este card com os cards de encaixe correspondentes."
        is Help -> if (helpCard.backContent.isNotBlank()) helpCard.backContent else helpCard.content
        is ChallengeCard -> if (challenge.backContent.isNotBlank()) challenge.backContent else "MAPA DO DESAFIO ${challenge.code}:\n\n${challenge.description}\n\nCARDS SUGERIDOS NO MAPA:\n" + challenge.requiredCardCodes.joinToString(" -> ")
        is Management -> if (managementCard.backContent.isNotBlank()) managementCard.backContent else managementCard.description
    }

    val backTip: String get() = when(this) {
        is Tool -> if (toolCard.backTip.isNotBlank()) toolCard.backTip else toolCard.tip
        is Help -> if (helpCard.backTip.isNotBlank()) helpCard.backTip else helpCard.tip
        is ChallengeCard -> if (challenge.backTip.isNotBlank()) challenge.backTip else "Utilize o card de Ajuda ${challenge.helpCardCode} para suporte."
        is Management -> if (managementCard.backTip.isNotBlank()) managementCard.backTip else managementCard.tip
    }
}

sealed class CompassItem {
    data class AreaItem(val area: Area) : CompassItem()
    data class PhaseItem(val phase: Phase) : CompassItem()
    data class AttributeItem(val phase: Phase) : CompassItem()
}
