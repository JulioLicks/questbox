package com.example.data.model

import androidx.compose.ui.graphics.Color

object QuestboxData {
    val TOOL_CARDS: List<ToolCard> = listOf(
        ToolCard(
            code = "F1",
            title = "Objetivos",
            question = "Quais são os seus objetivos?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F20", "F43"),
            formFields = listOf("Objetivos / Desafios"),
            tip = "Você pode anotar o seu objetivo geral ou os específicos neste card. Você pode anotar também o seu desafio quando quiser criar um desafio novo.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F2",
            title = "Problemas",
            question = "Quais são os problemas?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F29", "F54"),
            formFields = listOf("Problema", "Causa"),
            tip = "Um problema pode ser um acontecimento inesperado que danifica, atrasa ou se opõe à realização do desafio. A 'Causa' é a origem do problema.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F3",
            title = "Demandas",
            question = "Quais são as demandas ou necessidades?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F20", "F37"),
            formFields = listOf("Público", "Demanda / Necessidade", "Qtde."),
            tip = "Uma demanda pode ser os pedidos de um público por um produto, recursos ou suprimentos. Pode ser também uma necessidade não material.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F4",
            title = "Motivações",
            question = "Quais são as motivações?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F30", "F48"),
            formFields = listOf("Motivação / Satisfação", "Nível"),
            tip = "Motivações são as razões que movem as pessoas a fazerem algo, a realizarem seus projetos e desafios. O que pode ou não ser satisfatório.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F5",
            title = "Histórico",
            question = "Quais são os eventos mais importantes?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F24", "F47"),
            formFields = listOf("Acontecimento / Evento", "Data"),
            tip = "Anote os eventos ou acontecimentos mais importantes sobre alguém ou alguma coisa. Pode ser um currículo pessoal ou uma linha do tempo dos fatos.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F6",
            title = "Requisitos",
            question = "Quais são os requisitos?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F36", "F45"),
            formFields = listOf("Requisitos"),
            tip = "Requisitos são as características que alguém deve ter para um papel. Podem ser as de um produto ou projeto que precisam ser preenchidas.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F7",
            title = "Habilidades",
            question = "Quais são as habilidades?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F36", "F46"),
            formFields = listOf("Habilidade", "Nível"),
            tip = "Liste as habilidades por ordem da mais importante, então anote o nível de habilidade desenvolvida até o momento preenchendo as bolinhas.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F8",
            title = "Recompensas",
            question = "Quais são as recompensas oferecidas?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F26", "F48"),
            formFields = listOf("Meta/Tarefa", "Recompensa", "Data"),
            tip = "Podem ser oferecidas recompensas ou comissões para a conclusão de metas ou tarefas. Elas também podem ser ofertadas em produtos e serviços aos públicos.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F9",
            title = "Papéis",
            question = "Quais são os papéis e permissões?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F35", "F45"),
            formFields = listOf("Nome", "Área", "Papel", "Funções"),
            tip = "Um papel pode ser um cargo, profissão ou função dada a um membro da equipe em certa área. Você pode querer definir requisitos para uma função.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F10",
            title = "Relações",
            question = "Quais são as relações entre os papéis?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F35", "F44"),
            formFields = listOf("Relações"),
            tip = "Os círculos no diagrama acima representam: 1. Você; 2. Sua equipe; 3. Seus parceiros e fornecedores; 4. Seu público.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F11",
            title = "Equipe",
            question = "Quem são os membros da equipe?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F35", "F40"),
            formFields = listOf("Membro", "Papel"),
            tip = "Uma pessoa pode ter mais de um papel na equipe. Nesse caso, enumere cada um deles, começando pelo papel principal da pessoa.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F12",
            title = "Parceiros",
            question = "Quem são os parceiros?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F35", "F53"),
            formFields = listOf("Parceiro", "Função", "Contato"),
            tip = "Um parceiro é alguém fora da equipe, mas que tem um papel no desafio. Pode ser um fornecedor, um locador ou um prestador de serviço.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F13",
            title = "Público",
            question = "Quem é o público-alvo?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F20", "F37"),
            formFields = listOf("Público", "Demandas", "Histórico", "Ambiente"),
            tip = "O público é aquele para o qual um produto, serviço ou projeto é feito para servir, contemplar ou atender. É preciso conhecê-lo para mantê-lo.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F14",
            title = "Fornecedores",
            question = "Quem são os fornecedores?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F23", "F52"),
            formFields = listOf("Fornecedor", "Contato", "Item fornecido", "Qtde.", "Descrição", "Comprador resp.", "Data"),
            tip = "O fornecedor mantém um item suprido, seja um produto, uma peça para reposição, material de escritório ou cozinha, uniformes ou material de apoio.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F15",
            title = "Produtos",
            question = "Quais são os produtos oferecidos?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F26", "F51"),
            formFields = listOf("Produto", "Características"),
            tip = "Um produto é algo físico a ser produzido. Em 'características' você pode preencher os ingredientes ou a composição do produto a ser criado.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F16",
            title = "Serviços",
            question = "Quais são os serviços oferecidos?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F36", "F53"),
            formFields = listOf("Serviço", "Descrição"),
            tip = "Um serviço é um trabalho que uma pessoa faz para outra pessoa. Não há entrega de algo físico como um produto, mas somente uma ação.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F17",
            title = "Áreas",
            question = "Quais são as áreas?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F22", "F53"),
            formFields = listOf("Área"),
            tip = "Uma área pode ser uma região, setor ou departamento de um ambiente. Uma disciplina ou campo de atuação em que as pessoas estudam ou trabalham.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F18",
            title = "Ambiente",
            question = "Qual é o local?",
            phase = Phase.DIAGNOSTICO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F29", "F54"),
            formFields = listOf("Ambiente", "Áreas"),
            tip = "O Ambiente é o local do desafio. Dentro desse ambiente pode haver áreas ou locais menores. Nesse caso, enumere o ambiente e suas áreas.",
            helpCode = "A10",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F19",
            title = "Ideias",
            question = "Quais são as ideias?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F2", "F41"),
            formFields = listOf("Ideia"),
            tip = "Ideias são pequenas visões do que pode ser feito ou proposto. Anote as ideias sem julgamento ou apego. Alguma delas poderá vir a ser uma proposta.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F20",
            title = "Propostas",
            question = "Quais são as soluções propostas?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F1", "F43"),
            formFields = listOf("Objetivo / Problema / Demanda", "Solução"),
            tip = "Uma proposta é uma declaração de como pode ser solucionado um desafio, objetivo, problema, ou oferecido um produto, serviço ou estratégia.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F21",
            title = "Conteúdos",
            question = "Quais são os conteúdos?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F13", "F53"),
            formFields = listOf("Proposta", "Descrição dos conteúdos"),
            tip = "Este card descreve como os conteúdos de uma proposta são listados, ordenados e apresentados nos canais através de um sumário ou script.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F22",
            title = "Canais",
            question = "Quais são seus canais?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F13", "F41"),
            formFields = listOf("Canal", "Tipo de conteúdo"),
            tip = "Um canal é um meio utilizado para as realizar as entregas de conteúdos, produtos ou serviços, seja por slides, mídias sociais, panfletos ou um navio.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F23",
            title = "Recursos",
            question = "Quais são os recursos necessários?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F14", "F51"),
            formFields = listOf("Recurso necessário", "Qtde."),
            tip = "Recursos são materiais ou matérias-primas. Também podem ser utensílios e ferramentas utilizadas para criar um produto ou oferecer um serviço.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F24",
            title = "Cronograma",
            question = "Quanto tempo é necessário?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F5", "F39"),
            formFields = listOf("Objetivo / Evento", "Data"),
            tip = "Você pode utilizar um cronograma para colocar prazos em suas metas. Também pode gerenciar sua agenda, a produção de conteúdo e suas tarefas.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F25",
            title = "Custos",
            question = "Quanto custa?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F14", "F49"),
            formFields = listOf("Item", "Custo"),
            tip = "Você pode querer orçar ou precificar produtos, serviços, projetos, treinamentos, mão de obra, tempo gasto, recursos materiais ou energia.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F26",
            title = "Receitas",
            question = "Quais são os seus preços?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F49"),
            formFields = listOf("Produto / Serviço / Projeto / Receitas", "Preço"),
            tip = "Você pode utilizar este card para precificar serviços, produtos e projetos. Mas também pode utilizá-lo para descrever suas fontes de lucro ou receitas.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F27",
            title = "Metas",
            question = "Quais são as metas?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F1", "F43"),
            formFields = listOf("Meta", "Qtde.", "Prazo", "Preço", "Pontos"),
            tip = "Metas são objetivos secundários dentro de um desafio ou objetivo. Metas servem para estimular a ação e ajudar a mensurar resultados.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F28",
            title = "Estratégias",
            question = "Quais são os cenários possíveis?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F17", "F44"),
            formFields = listOf("Cenário A", "Cenário B", "Cenário C"),
            tip = "Estratégias são propostas de ações a serem tomadas sobre um possível cenário. Cada cenário pode ser detalhado para facilitar as tomadas de decisão.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F29",
            title = "Riscos",
            question = "Quais são os riscos ou objeções?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F2", "F54"),
            formFields = listOf("Riscos/Objeções", "Procedimentos"),
            tip = "É importante analisar os riscos para evitá-los, para saber o que fazer se eles acontecerem. Riscos podem ser as objeções do seu cliente ou público-alvo.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F30",
            title = "Oportunidades",
            question = "Quais são as oportunidades?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F8", "F42"),
            formFields = listOf("Oportunidades", "Procedimentos"),
            tip = "Considere analisar as oportunidades para aproveitá-las caso elas aconteçam. Utilize-as a seu favor para cumprir seu objetivo.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F31",
            title = "Metodologia",
            question = "Qual é a metodologia aplicada?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F1", "F41"),
            formFields = listOf("Nome da metodologia", "Objetivo", "Problema", "Proposta", "Etapas", "Duração"),
            tip = "Uma metodologia descreve como as tarefas do seu projeto devem ser realizadas. Ela contém os problemas, as propostas e as etapas para solucioná-los.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F32",
            title = "Pesquisas",
            question = "O que precisa ser pesquisado?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F1", "F43"),
            formFields = listOf("Nome da pesquisa", "Palavras-chave", "Fontes", "Etapas", "Resultados", "Duração"),
            tip = "Você pode querer fazer uma pesquisa de campo ou online para colher informações. Anote as fontes ou referências para mantê-las organizadas.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F33",
            title = "Referências",
            question = "Quais são as referências e suas fontes?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F5", "F38"),
            formFields = listOf("Nome da referência", "Autor", "Fonte", "Data da pesquisa", "Área", "Palavras-chave"),
            tip = "Anote o nome da referência, livro, website, música ou vídeo pesquisado. Depois o autor, a fonte, a data da pesquisa, a área e as palavras-chaves.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F34",
            title = "Indicadores",
            question = "Quais são os números mais importantes?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F4", "F48"),
            formFields = listOf("Nome do Indicador", "Área", "Período", "Histórico", "Resultado atual", "Tendência"),
            tip = "Anote o nome do indicador, descrevendo junto a sua utilidade. Depois a área, o período, o histórico de resultados, o resultado atual e a tendência.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F35",
            title = "Acordos",
            question = "O que precisa ser acordado?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F8", "F42"),
            formFields = listOf("Proposta", "O que foi acordado"),
            tip = "Liste as propostas de cada um. Então utilize o card 'Painel de Alinhamento' para negociar e chegar ao acordo. Enfim, anote o que foi acordado entre as partes.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F36",
            title = "Instruções",
            question = "Quais são as regras ou instruções?",
            phase = Phase.PLANEJAMENTO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F6", "F45"),
            formFields = listOf("Objetivo", "Instrução"),
            tip = "Instruções são ações que devem ser feitas para se chegar a um fim. Pode ser uma receita ou a descrição de como utilizar, fazer ou montar algo.",
            helpCode = "A11",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F37",
            title = "Ficha de Atendimento",
            question = "Quem precisa ser atendido?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F13", "F20"),
            formFields = listOf("Nome", "Email", "Telefone", "Demanda", "Objetivo pessoal", "Atendente", "Data"),
            tip = "A 'Ficha de Atendimento' serve para colher informações sobre o público. durante um atendimento. Podem ser adicionados campos para cada contexto.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F38",
            title = "Contatos",
            question = "Quais são os seus contatos?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F13", "F22"),
            formFields = listOf("Nome", "Contato"),
            tip = "Você pode criar uma lista de contatos para agendar reuniões, fazer atendimentos, prospectar clientes ou aumentar seu networking.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F39",
            title = "Agenda",
            question = "O que precisa ser agendado?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F5", "F24"),
            formFields = listOf("Objetivo", "Com quem", "Data", "Horário"),
            tip = "Você pode querer agendar uma tarefa, uma reunião, um evento, uma avaliação física, uma entrega, um evento, um lançamento de produto.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F40",
            title = "Reuniões",
            question = "Quais reuniões precisam ser marcados?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F11", "F35"),
            formFields = listOf("Assunto", "Participantes", "Local", "Data"),
            tip = "Você pode querer marcar uma reunião para ter ideias, planejar o que deve ser feito, fazer acordos, distribuir tarefas ou treinar em grupo.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F41",
            title = "Feedbacks e Resultados",
            question = "Quais são os feedbacks e resultados obtidos?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F4", "F19"),
            formFields = listOf("Assunto", "De Quem", "Feedbacks / Resultados"),
            tip = "Você pode anotar os feedbacks do seu público ou da sua equipe ou descrever os resultados obtidos por uma pesquisa ou treinamento.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F42",
            title = "Contrato",
            question = "O que foi negociado, comprado ou vendido?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F35"),
            formFields = listOf("Contrato de", "Contratante", "Contratado", "Produto / Serviço adquirido", "Termos e condições", "Assinaturas", "Data"),
            tip = "O contrato é essencial para o fechamento de uma negociação. Podem ser adicionadas mais informações, de acordo com cada contexto.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F43",
            title = "Tarefas",
            question = "Quais são as tarefas?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F1", "F27"),
            formFields = listOf("Tarefas", "Fazendo", "Feita", "Pontos", "Progresso"),
            tip = "Organize as tarefas a fazer por ordem de prioridade. Anote no campo 'Progresso' a quantidade de tarefas feitas em relação ao total.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F44",
            title = "Interdependências",
            question = "Quais tarefas dependem de outras?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F10", "F35"),
            formFields = listOf("Tarefas/Rotina", "N. Interdep."),
            tip = "Interdependências são tarefas que dependem de outras serem feitas antes. Liste as tarefas com seus números, depois a tarefa a qual ela depende.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F45",
            title = "Rotinas",
            question = "Quais são as rotinas?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F9", "F36"),
            formFields = listOf("Tarefa de Rotina", "Quando"),
            tip = "Uma rotina é algo que precisa ser feito periodicamente ou repetidamente. Pode ser uma rotina administrativa ou da equipe que precisa ser feita todo dia.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F46",
            title = "Treinamentos",
            question = "O que precisa ser treinado?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F7", "F31"),
            formFields = listOf("Tarefa / Habilidade", "Rotina"),
            tip = "Durante um treinamento, primeiro observe como se faz, depois peça a alguém que o acompanhe enquanto você faz, então faça sozinho sem precisar de ajuda.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F47",
            title = "Lista de Presenças",
            question = "Quem está presente?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F13", "F22"),
            formFields = listOf("Nome", "Data", "Horário"),
            tip = "Anote o nome da pessoa que precisa ter sua frequência registrada. Depois anote data e horário. Crie quantos campos de data e horário precisar.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F48",
            title = "Avaliação",
            question = "Qual é o seu desempenho?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F7", "F31"),
            formFields = listOf("Tarefa / Rotina", "Erros", "Acertos", "Pontos"),
            tip = "A avaliação serve para acompanhar o seu desempenho na realização de tarefas, rotinas e treinos. Você pode anotar seus pontos e trocar por recompensas.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F49",
            title = "Caixa",
            question = "Quanto dinheiro há em caixa?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F26"),
            formFields = listOf("Entradas/Créditos", "Data", "Débitos/Saídas", "Total"),
            tip = "Procure anotar tudo o que você gasta e tudo o que você lucra. Cada entrada e saída de dinheiro pode significar um montante considerável no final do período.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F50",
            title = "Inventário",
            question = "O que você possui?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F15", "F23"),
            formFields = listOf("Recurso", "Qtde."),
            tip = "Procure alinhar suas demandas com seu inventário. Verifique se os suprimentos ou recursos estão disponíveis antes de depender deles.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F51",
            title = "Estoque",
            question = "O que precisa ser suprido?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F23"),
            formFields = listOf("Recurso", "Resp.", "Data", "Qtde.", "Entrada", "Saída"),
            tip = "Procure anotar tudo o que entra e sai do seu inventário ou estoque. Anote quem, quando e a quantidade dos recursos. Isso pode evitar extravios.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F52",
            title = "Logística",
            question = "O que precisa ser entregue?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F14", "F23"),
            formFields = listOf("Entrega", "Resp.", "Data", "Origem", "Destino"),
            tip = "Você pode querer entregar um produto ou receber um recurso ou suprimento. Anotando o que deve ser entregue, o entregador e os locais de origem e destino.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F53",
            title = "Suporte",
            question = "Quem chamar em caso de emergência?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F22"),
            formFields = listOf("Demanda", "Público", "Contato"),
            tip = "Você pode querer oferecer suporte para ouvir as demandas do seu público. Também para dar e receber feedbacks, pedir suprimentos ou dar manutenção.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
        ToolCard(
            code = "F54",
            title = "Manutenção",
            question = "O que precisa de manutenção?",
            phase = Phase.REALIZACAO,
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("F3", "F25"),
            formFields = listOf("Item", "Problema", "DataHorário", "Resp."),
            tip = "Você pode precisar colocar algo em manutenção, reparo ou conserto. Nesse caso, preencha o nome do item, o problema, data, horário e responsável.",
            helpCode = "A12",
            defaultMap = listOf()
        ),
    )

    val CHALLENGES: List<Challenge> = listOf(
        Challenge(
            code = "D1",
            title = "Análise de Perfil",
            areaCode = "AR1",
            subtitle = "Vamos analisar o seu perfil?",
            durationMinutes = 70,
            xpPoints = 70,
            requiredCardCodes = listOf("F1", "F4", "F5", "F6", "F7", "F9", "F22", "F25", "F26", "F27", "F49", "F50"),
            description = "O importante da análise de perfil é o auto-conhecimento e a gestão pessoal.",
            helpCardCode = "A8",
            sockets = listOf("P1", "AR1")
        ),
        Challenge(
            code = "D2",
            title = "Análise de Ambiente",
            areaCode = "AR1",
            subtitle = "Vamos analisar o ambiente?",
            durationMinutes = 60,
            xpPoints = 60,
            requiredCardCodes = listOf("F2", "F5", "F17", "F18", "F22", "F29", "F30", "F34", "F52", "F53", "F54"),
            description = "O importante da análise de ambiente é conhecer o lugar onde você está trabalhando.",
            helpCardCode = "A8",
            sockets = listOf("P1", "AR1")
        ),
        Challenge(
            code = "D3",
            title = "Análise de Público",
            areaCode = "AR1",
            subtitle = "Vamos analisar o público-alvo?",
            durationMinutes = 75,
            xpPoints = 75,
            requiredCardCodes = listOf("F2", "F4", "F5", "F13", "F18", "F22", "F29", "F30", "F34", "F37", "F38", "F53"),
            description = "O importante da análise de público é conhecer as pessoas que o seu produto, serviço ou projeto atendem.",
            helpCardCode = "A8",
            sockets = listOf("P1", "AR1")
        ),
        Challenge(
            code = "D4",
            title = "Plano de Vendas",
            areaCode = "AR2",
            subtitle = "Vamos vender mais?",
            durationMinutes = 90,
            xpPoints = 90,
            requiredCardCodes = listOf("F3", "F7", "F14", "F15", "F16", "F20", "F25", "F27", "F28", "F29", "F30", "F37", "F38", "F42", "F45", "F49", "F51"),
            description = "O importante em vendas é a satisfação das demandas do público do seu negócio ou projeto.",
            helpCardCode = "A8",
            sockets = listOf("P2", "AR2")
        ),
        Challenge(
            code = "D5",
            title = "Atendimento",
            areaCode = "AR2",
            subtitle = "Vamos melhorar o atendimento?",
            durationMinutes = 75,
            xpPoints = 75,
            requiredCardCodes = listOf("F3", "F13", "F22", "F28", "F29", "F30", "F36", "F37", "F38", "F39", "F41", "F45", "F53"),
            description = "O importante do atendimento é estar disposto a ajudar o seu público.",
            helpCardCode = "A8",
            sockets = listOf("P2", "AR2")
        ),
        Challenge(
            code = "D6",
            title = "Negociação",
            areaCode = "AR2",
            subtitle = "Vamos negociar?",
            durationMinutes = 80,
            xpPoints = 80,
            requiredCardCodes = listOf("F1", "F3", "F4", "F6", "F13", "F19", "F20", "F28", "F29", "F30", "F35", "F40", "F41", "F42"),
            description = "O importante da negociação é que todos fiquem satisfeitos.",
            helpCardCode = "A8",
            sockets = listOf("P2", "AR2")
        ),
        Challenge(
            code = "D7",
            title = "Networking",
            areaCode = "AR3",
            subtitle = "Vamos fazer contatos?",
            durationMinutes = 75,
            xpPoints = 75,
            requiredCardCodes = listOf("F1", "F4", "F9", "F10", "F11", "F12", "F13", "F14", "F22", "F30", "F38", "F39", "F40"),
            description = "O importante do networking são as relações interpessoais.",
            helpCardCode = "A8",
            sockets = listOf("P3", "AR3")
        ),
        Challenge(
            code = "D8",
            title = "Plano de Carreira",
            areaCode = "AR3",
            subtitle = "Vamos planejar sua carreira?",
            durationMinutes = 100,
            xpPoints = 100,
            requiredCardCodes = listOf("F1", "F4", "F5", "F8", "F9", "F17", "F20", "F23", "F24", "F25", "F26", "F27", "F28", "F29", "F30", "F43", "F49", "F50"),
            description = "O importante do plano de carreira é planejar seu futuro de vida, profissional ou acadêmico.",
            helpCardCode = "A8",
            sockets = listOf("P3", "AR3")
        ),
        Challenge(
            code = "D9",
            title = "Trabalho em Equipe",
            areaCode = "AR3",
            subtitle = "Vamos trabalhar juntos?",
            durationMinutes = 105,
            xpPoints = 105,
            requiredCardCodes = listOf("F1", "F6", "F7", "F9", "F11", "F17", "F19", "F20", "F24", "F27", "F35", "F36", "F40", "F41", "F43", "F44", "F45"),
            description = "O importante do trabalho em equipe é o espírito de equipe.",
            helpCardCode = "A8",
            sockets = listOf("P3", "AR3")
        ),
        Challenge(
            code = "D10",
            title = "Engajamento",
            areaCode = "AR4",
            subtitle = "Vamos aumentar o engajamento?",
            durationMinutes = 105,
            xpPoints = 105,
            requiredCardCodes = listOf("F2", "F3", "F4", "F8", "F11", "F13", "F20", "F21", "F22", "F24", "F25", "F27", "F28", "F30", "F40", "F41", "F45", "F48"),
            description = "O importante do engajamento é manter as pessoas motivadas.",
            helpCardCode = "A8",
            sockets = listOf("P4", "AR4")
        ),
        Challenge(
            code = "D11",
            title = "Treinamento",
            areaCode = "AR4",
            subtitle = "Vamos treinar?",
            durationMinutes = 85,
            xpPoints = 85,
            requiredCardCodes = listOf("F2", "F3", "F4", "F11", "F12", "F13", "F20", "F27", "F31", "F36", "F41", "F45", "F46", "F48"),
            description = "O importante do treinamento é estar preparado para realizar as suas tarefas.",
            helpCardCode = "A8",
            sockets = listOf("P4", "AR4")
        ),
        Challenge(
            code = "D12",
            title = "Plano de Aula",
            areaCode = "AR4",
            subtitle = "Vamos preparar as aulas?",
            durationMinutes = 100,
            xpPoints = 100,
            requiredCardCodes = listOf("F1", "F4", "F5", "F7", "F13", "F17", "F18", "F19", "F20", "F21", "F24", "F31", "F32", "F33", "F41", "F43", "F47", "F48"),
            description = "O importante do plano de aula é focar naquilo que se deseja ensinar e aprender.",
            helpCardCode = "A8",
            sockets = listOf("P4", "AR4")
        ),
        Challenge(
            code = "D13",
            title = "Criação de Projetos",
            areaCode = "AR5",
            subtitle = "Vamos criar um projeto?",
            durationMinutes = 95,
            xpPoints = 95,
            requiredCardCodes = listOf("F1", "F2", "F3", "F4", "F13", "F18", "F19", "F20", "F21", "F24", "F31", "F32", "F33", "F34", "F41", "F48"),
            description = "O importante da criação de projetos é ter a visão completa do escopo.",
            helpCardCode = "A8",
            sockets = listOf("P5", "AR5")
        ),
        Challenge(
            code = "D14",
            title = "Modelo de Negócios",
            areaCode = "AR5",
            subtitle = "Vamos criar um modelo de negócios?",
            durationMinutes = 95,
            xpPoints = 95,
            requiredCardCodes = listOf("F1", "F13", "F15", "F16", "F17", "F18", "F20", "F22", "F23", "F25", "F26", "F28", "F29", "F30", "F45", "F49", "F50", "F53"),
            description = "O importante dos modelos de negócios é o empreendimento.",
            helpCardCode = "A8",
            sockets = listOf("P5", "AR5")
        ),
        Challenge(
            code = "D15",
            title = "Criação de Produto",
            areaCode = "AR5",
            subtitle = "Vamos criar um produto?",
            durationMinutes = 95,
            xpPoints = 95,
            requiredCardCodes = listOf("F3", "F13", "F14", "F15", "F16", "F19", "F20", "F21", "F22", "F23", "F25", "F26", "F28", "F29", "F30", "F51", "F52", "F54"),
            description = "O importante da criação de produtos é a entrega do produto que o seu público demanda.",
            helpCardCode = "A8",
            sockets = listOf("P5", "AR5")
        ),
        Challenge(
            code = "D16",
            title = "Gestão Financeira",
            areaCode = "AR6",
            subtitle = "Vamos gerenciar as finanças?",
            durationMinutes = 75,
            xpPoints = 75,
            requiredCardCodes = listOf("F3", "F8", "F11", "F13", "F14", "F25", "F26", "F27", "F28", "F29", "F30", "F34", "F42", "F49"),
            description = "O importante da gestão financeira é valorizar o seu dinheiro.",
            helpCardCode = "A8",
            sockets = listOf("P6", "AR6")
        ),
        Challenge(
            code = "D17",
            title = "Gestão de Recursos",
            areaCode = "AR6",
            subtitle = "Vamos gerenciar os recursos?",
            durationMinutes = 65,
            xpPoints = 65,
            requiredCardCodes = listOf("F3", "F13", "F14", "F15", "F18", "F22", "F23", "F29", "F50", "F51", "F52", "F54"),
            description = "O importante da gestão de recursos é estar preparado para os momentos de escassez e de abundância.",
            helpCardCode = "A8",
            sockets = listOf("P6", "AR6")
        ),
        Challenge(
            code = "D18",
            title = "Gestão de Tempo",
            areaCode = "AR6",
            subtitle = "Vamos gerenciar o tempo?",
            durationMinutes = 45,
            xpPoints = 45,
            requiredCardCodes = listOf("F1", "F4", "F5", "F24", "F27", "F39", "F45", "F48"),
            description = "O importante da gestão de tempo é você não desperdiçar tempo.",
            helpCardCode = "A8",
            sockets = listOf("P6", "AR6")
        ),
    )

    val ROLES: List<Role> = listOf(
        Role(
            code = "P1",
            title = "Mentor",
            motto = "Eu ajudo as pessoas a se melhorarem.",
            principle = "Onde há empoderamento há liberdade.",
            actions = "Observar-se, conhecer-se, afirmar-se.",
            areaCode = "AR1",
            primarySkill = "Olhar apreciativo.",
            color = Color(0xFFE53935)
        ),
        Role(
            code = "P2",
            title = "Mediador",
            motto = "Eu ajudo as pessoas a se alinharem.",
            principle = "Onde há alinhamento há sinergia.",
            actions = "Ouvir, dialogar, alinhar.",
            areaCode = "AR2",
            primarySkill = "Comunicação empática.",
            color = Color(0xFFFB8C00)
        ),
        Role(
            code = "P3",
            title = "Facilitador",
            motto = "Eu ajudo as pessoas a trabalharem juntas.",
            principle = "Onde há cocriação há colaboração.",
            actions = "Focalizar, organizar, mobilizar.",
            areaCode = "AR3",
            primarySkill = "Tomada de decisões.",
            color = Color(0xFFFFC107)
        ),
        Role(
            code = "P4",
            title = "Instrutor",
            motto = "Eu ajudo as pessoas a aprenderem.",
            principle = "Onde há desafio há motivação.",
            actions = "Aprender, simular, praticar.",
            areaCode = "AR4",
            primarySkill = "Resolução de problemas.",
            color = Color(0xFF43A047)
        ),
        Role(
            code = "P5",
            title = "Projetista",
            motto = "Eu ajudo as pessoas a criarem.",
            principle = "Onde há criatividade há inovação.",
            actions = "Visualizar, projetar, realizar.",
            areaCode = "AR5",
            primarySkill = "Visualização criativa.",
            color = Color(0xFF1565C0)
        ),
        Role(
            code = "P6",
            title = "Gestor",
            motto = "Eu ajudo as pessoas a gerenciarem.",
            principle = "Onde há abundância há sustentabilidade.",
            actions = "Empreender, gerenciar, administrar.",
            areaCode = "AR6",
            primarySkill = "Adaptação às mudanças.",
            color = Color(0xFF8E24AA)
        ),
    )

        val HELP_CARDS: List<HelpCard> = listOf(
        HelpCard(
            code = "A1",
            title = "COMO JOGAR",
            question = "Começando.",
            summary = "Seja bem vindo ao Questbox, o jogo de criação de projetos.",
            content = """Olá! Seja bem vindo ao Questbox, o jogo de criação de projetos. Se você começou agora e não faz ideia do que fazer, então comece por aqui. Volte a este card sempre que se sentir perdido ou quiser recomeçar. Você pode criar um projeto sozinho ou em equipe. Podem jogar quantas pessoas quiser, desde que se respeitem e trabalhem juntos para cumprirem o desafio ou objetivo do projeto. Estão prontos? Então vamos começar.

Há duas formas de você começar o seu projeto. A primeira é pegando um dos cards verdes de Desafio D1 a D18 e seguir o Mapa de ferramentas descrito no verso. A segunda é começando com um desafio pessoal, que não está no jogo. Nesse caso, anote seu desafio no card vermelho Objetivos F1. Siga os passos a seguir:
1. Escolha um desafio, entre um dos 18 do jogo ou outro que você quiser.
2. Pegue os cards indicados no mapa atrás do card de Desafio escolhido.
3. Monte sua área de trabalho, para visualizar todos os cards selecionados.
4. Preencha as informações pedidas atrás dos cards, e parta para as tarefas.

Além deste, há 5 cards de Ajuda laranjados que você precisa pegar para aprender a jogar: O card A2 com os tipos de cards. O card A3 que mostra os encaixes entre os cards. O card A4, que ensina como criar mapas para solucionar desafios. O card A5 para aprender a montar a sua área de trabalho. E o card A6, que ensina a calcular a duração e o nível de dificuldade dos seus projetos.""",
            tip = "Antes de começar, é important você conhecer todos os cards. Pegue o card de Ajuda laranja A2 para ver a lista. Volte a este card quando quiser começar.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A2",
            title = "OS TIPOS DE CARDS",
            question = "Apresentando as ferramentas.",
            summary = "Conheça os 6 tipos de cards e suas utilidades.",
            content = """Antes de começar, você precisa conhecer os tipos de cards e suas utilidades. Existem 6 tipos de cards. Cada um corresponde a um tipo de ferramenta, com uma cor, um nome e um código único que o identifica, para ajudar você a memorizar, identificar e organizá-lo na sua área de trabalho de acordo com a sua necessidade. Os cards de Gerenciamento são os mais importantes. Estude-os bem. Você vai utilizá-los na maioria dos projetos.

• Cards de Ajuda: Use esses cards sempre que se sentir perdido e não souber o que fazer. Para saber mais sobre os cards de Ajuda, pegue o card de Ajuda A7.
• Cards de Gerenciamento: Use esses cards para gerenciar seus projetos. Eles incluem os cards de papeis e áreas. Para saber mais sobre os cards de Gerenciamento, pegue o card de Ajuda A9.
• Cards de Desafio: Use esses cards para encontrar mapas com receitas de desafios de diversas áreas. Para saber mais sobre os cards de Desafio, pegue o card de Ajuda A8.
• Cards de Diagnóstico: Use esses cards para analisar o seu projeto e aprender sobre ele antes de começar. Para saber mais sobre os cards de Diagnóstico, pegue o card de Ajuda A10.
• Cards de Planejamento: Use esses cards para planejar o que fazer antes de agir. Para saber mais sobre os cards de Planejamento, pegue o card de Ajuda A11.
• Cards de Realização: Use esses cards para organizar suas tarefas e sua rotina de trabalho. Para saber mais sobre os cards de Realização, pegue o card de Ajuda A12.""",
            tip = "Estude bem os cards de Gerenciamento, pois você vai utilizá-los na maioria dos seus projetos.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A3",
            title = "ENCAIXES ENTRE CARDS",
            question = "Combinando ferramentas.",
            summary = "Cada card possui uma utilidade única e se combina com outros.",
            content = """Cada card possui uma utilidade única dentro do jogo. Cada um foi pensado para ser usado em combinação com outros cards. Se quiser, você pode utilizar somente um card ou todos os cards no seu projeto. Na frente dos cards existem códigos que os identificam, e abaixo deles códigos para você utilizar quando quiser combinar, relacionar aquele card com outros nos seus mapas. Todos os cards possuem pelo menos um encaixe para você estudar e explorar.

Na frente de todos os cards há encaixes ou referências para outros cards. Quando você escolher um desafio e pegar os cards indicados no mapa, procure ler os encaixes de cada card para obter ajuda e expandir o desafio. Observe os ícones coloridos na frente dos cards. Esses são os encaixes. Os cards se relacionam e se referenciam através desses ícones. Procure na frente de cada card pelos ícones que fazem referência a outros cards. Os ícones laranjados de cards de Ajuda também são encaixes. Cada card possui um card de Ajuda ligado a ele. Consulte-o sempre que estiver em dúvida ou precisar refletir sobre suas características.""",
            tip = "Quando estiver trabalhando no mapa do seu projeto, você pode querer ou precisar expandi-lo, fazendo uso dos encaixes citados nos cards desse mapa.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A4",
            title = "CRIAÇÃO DE MAPAS",
            question = "Criando mapas com ferramentas.",
            summary = "Como selecionar e organizar os cards para o seu projeto.",
            content = """Depois que você escolheu o desafio, é hora de criar o mapa das ferramentas que serão utilizadas no projeto. Um mapa pode conter um ou todos os cards do jogo. O tamanho de um mapa depende de quantos cards você escolher para compor o projeto. Anotar os cards que você deseja utilizar é importante para visualizar e organizar, para manter o foco nas ferramentas escolhidas e controlar quais ferramentas precisam ser adicionadas ou removidas.

Há duas formas de utilizar o mapa de projetos. A primeira é pegando um card verde de Desafio e encontrando o mapa dele na parte de trás dele. A segunda, é pegar o card lilás de Gerenciamento Mapa M e anotar os códigos dos cards que você escolher para realizar o seu projeto ou desafio. Repare que no verso do card Mapa M há campos para você marcar ou anotar os códigos dos cards que deseja utilizar no seu projeto. Mas você pode anotar os códigos do seu mapa numa folha de papel, escrevendo o nome do seu desafio seguido dos códigos dos cards escolhidos. Observe atrás dos cards verdes de Desafio. Repare que há um diagrama contendo círculos coloridos com os códigos dos cards de Gerenciamento, Diagnóstico, Planejamento e Realização. Essas são as ferramentas escolhidas para compor o mapa daquele desafio.""",
            tip = "Você pode adicionar mais cards ao mapa dependendo das necessidades do projeto. Você pode anotar esses cards no card de Gerenciamento Mapa M.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A5",
            title = "A ÁREA DE TRABALHO",
            question = "Organizando a área de trabalho.",
            summary = "O espaço reservado para interação e preenchimento dos cards.",
            content = """A área de trabalho é o espaço reservado para a visualização, disposição, manuseio, interação e preenchimento das informações contidas nos cards. Pode ser uma mesa ou uma superfície que possa acomodar os cards necessários sem prejudicar seu estudo ou trabalho. A equipe pode compartilhar a mesma área de trabalho, mas é importante que cada um faça seu próprio registro e compartilhe as informações levantadas.

Você pode montar sua área de trabalho como quiser, dispondo os cards na posição que melhor se ajustar aos seus objetivos. Porém, é recomendado dispor os cards seguindo a ordem dos códigos e cores de cada fase. Você não precisa anotar as informações do projeto nos cards. Você pode utilizar papel, lápis e borracha, ou usar um caderno, agenda, notas autoadesivas ou um painel para trabalhar com a equipe. O importante é manter as informações objetivas, organizadas e à vista de todos.""",
            tip = "Você pode adicionar ou remover cards da sua área de trabalho quando quiser. Mas lembre-se de anotar e manter o seu mapa do projeto atualizado.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A6",
            title = "DIFICULDADE E DURAÇÃO",
            question = "Calculando a dificuldade e duração do projeto.",
            summary = "Aprenda a somar a duração e calcular o nível de dificuldade.",
            content = """O nível de dificuldade que você vai ter para entender o jogo e aplicá-lo ao seu desafios, objetivos ou projetos depende de quanta atenção e tempo você dedicar ao estudo de cada card. Comece pegando e lendo cada um para ter uma visão geral dele. Depois observe os encaixes, percebendo as possibilidades de interação entre eles. Por fim, foque nas informações que você precisa levantar para realizar o projeto. Assim você vai diminuindo as dificuldades.

Observe na frente dos cards um ícone de ampulheta escrito “Duração”. Embaixo dele tem uma duração estipulada em minutos. Isso significa que você pode calcular a duração dos seus projetos somando o tempo de cada card. Cada desafio tem uma duração para ser realizado. O cálculo é feito da seguinte forma: no jogo cada ferramenta leva em média 5 minutos para ser lida, entendida e respondida. Assim, a duração de um desafio é a soma da duração de todas as ferramentas aplicadas no desafio. Por exemplo, se você utilizar 10 cards para criar o mapa do seu desafio, então multiplique 10 cards vezes 5 minutos, que é igual a 50 minutos de duração para preencher todos os cards do mapa.

Por padrão, cada desafio do jogo tem um nível de dificuldade calculated com base na quantidade de cards utilizados no seu mapa. Um desafio fácil utiliza até 10 cards de Ferramentas. Um desafio médio utiliza de 15 a 20. E um desafio difícil utiliza mais de 20 ferramentas no mesmo mapa e área de trabalho.""",
            tip = "O tempo de cada reunião, treinamento, realização de avaliações e mesmo o preenchimento de cards deve ser combinado entre os membros da equipe.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A7",
            title = "CARDS DE AJUDA",
            question = "Precisa de ajuda?",
            summary = "Instruções e visão geral de todo o jogo.",
            content = """Durante a criação de um projeto ou realização de um desafio, é normal você ter dúvidas sobre os cards e as relações entre eles. Saiba que nem todas as suas dúvidas ou questionamentos podem ser respondidas nesses cards. Porém eles foram criados, ordenados e tiveram seus conteúdos produzidos de modo a responder às suas perguntas e reflexões iniciais sobre o jogo. Se você quer saber como começar a jogar, pegue o card de Ajuda A1.

Há 18 cards de Ajuda. São os cards laranjados, com os códigos A1 a A18. Recorra a eles sempre que você tiver dúvidas sobre qualquer card. Pegue-os, leia-os na ordem, reflita sobre eles. Depois junte-os e correlacione os. Eles possuem a visão geral de todo o jogo.""",
            tip = "Procure o ícone laranjado na frente de cada card para encontrar a ajuda relacionada a ele. Pegue o card de Ajuda A8 para conhecer os cards de Desafio.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A8",
            title = "CARDS DE DESAFIO",
            question = "Qual é o seu desafio?",
            summary = "Objetivos e receitas de mapas para projetos.",
            content = """Os desafios são os objetivos, aquilo que você tem de importante para fazer. Você pode escolher um dos desafios prontos do jogo ou trazer um desafio pessoal ou da sua equipe para começar, criando seu próprio mapa do zero. De qualquer forma, você decide por onde começar, seja por um desafio pronto ou um personalizado. Se o desafio que você escolheu não estiver na lista, pegue o card de Diagnóstico vermelho Objetivos F1, e anote o seu desafio nele.

Há 18 cards de Desafio. São os cards verdes, com os códigos D1 a D18. Escolha um deles para começar a jogar. Pegue-os, leia-os, observe-os e reflita sobre o mapa de ferramentas no verso deles. Junte esses cards para começar a trabalhar no seu desafio.""",
            tip = "Pegue o card lilás de Gerenciamento Mapa M para anotar a sua receita de cards. Pegue o card de Ajuda A9 para ver os cards de Gerenciamento.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A9",
            title = "CARDS DE GERENCIAMENTO",
            question = "Como fazer gerenciamento.",
            summary = "Acompanhamento contínuo do projeto.",
            content = """O gerenciamento é uma ação contínua de monitorar e acompanhar aquilo que você está fazendo, seja um desafio, uma tarefa ou rotina do projeto. Os cards de Gerenciamento são ferramentas que devem ser usadas durante todas as fases do projeto, seja para anotar suas informações pessoais, manter a equipe atualizada, alinhar visões, tomar decisões, criar mapas, definir papéis ou conhecer melhor a área que você está trabalhando.

Há 18 cards para Gerenciamento. São os cards lilases, com os códigos B, PA, FP, PC, M e DB. Também incluem os cards de Papéis P1 a P6, e os cards de Áreas AR1 a AR6. Essas são as ferramentas mais importantes para fazer o acompanhamento do desafio.""",
            tip = "Os cards de Papéis de Áreas também são cards de Gerenciamento, e podem orientá-lo. Pegue o card A10 para conhecer os cards de Diagnóstico.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A10",
            title = "CARDS DE DIAGNÓSTICO",
            question = "Como fazer diagnósticos.",
            summary = "Levante informações iniciais, motivações e problemas.",
            content = """Quando você começa um desafio ou projeto, é importante saber aquilo que deve ser feito, os problemas, demandas, motivações, o histórico e os requisitos para fazer algo. Use os cards de Diagnóstico para levantar as informações iniciais, formar uma equipe, distribuir papéis ou mesmo destacar uma habilidade que você quer treinar ou desenvolver. Utilize quanto cards precisar. O importante é fazer um bom diagnóstico.

Há 18 cards para Diagnóstico. Elas estão relacionados à Fase de Diagnóstico. São os cards vermelhos, com os códigos F1 a F18. Comece diagnosticando o seu desafio ou objetivo. Depois pegue os cards que possam ajudar você a realizá-lo.""",
            tip = "Observe os cards F1 a F6. Possivelmente os seus projetos começam por um deles. Pegue o card de Ajuda A11 para conhecer os cards de Planejamento.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A11",
            title = "CARDS DE PLANEJAMENTO",
            question = "Como planejar o que foi diagnosticado.",
            summary = "Escreva propostas de valor, defina metas e estratégias.",
            content = """Primeiro, você precisa fazer um bom diagnóstico antes de planejar como realizar seu desafio ou projeto. Pois é durante o planejamento que você escreve a proposta de valor mais adequada ao desafio escolhido, que você define metas de ação claras, que projeta estratégias para os cenários possíveis, que levanta os custos e recursos necessários para o projeto e que produz conteúdos relevantes para oferecer nos seus canais.

Há 18 cards para Planejamento. Elas estão relacionados à Fase de Planejamento. São os cards amarelos, com os códigos F19 a F36. É importante que você tenha objetivos claros, para fazer propostas, definir metas e buscar as melhores oportunidades.""",
            tip = "Se você quer saber como fazer um diagnóstico, pegue o card de Ajuda A10. Para seguir com a realização do seu projeto, pegue o card de Ajuda A12.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A12",
            title = "CARDS DE REALIZAÇÃO",
            question = "Como realizar o que foi planejado.",
            summary = "Execute tarefas, rotinas, reuniões e avaliações.",
            content = """Antes de partir para a realização das suas tarefas e rotinas, você precisa fazer um planejamento. Tendo elaborado um plano de ação, você já está pronto para atender, ligar para contatos, fazer reuniões, dar feedbacks sobre resultados, treinar sua equipe e avaliar seu desempenho, gerenciar seu caixa e inventário, dar suporte ao seu público e o que mais precisa ser feito para materializar o que você planejou.

Há 18 cards para Realização. Elas estão relacionados à Fase de Realização. São os cards azuis, com os códigos F37 a F54. É importante que você tenha uma boa proposta e um bom planejamento antes de partir para a realização das tarefas e rotinas.""",
            tip = "Para fazer um planejamento, pegue o card de Ajuda A11. Para saber mais sobre a dificuldade e duração do jogo, pegue o card de Ajuda A6.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A13",
            title = "A BÚSSOLA",
            question = "Calibrando a sua Bússola.",
            summary = "A ferramenta de Gerenciamento mais importante do jogo.",
            content = """A Bússola B é a ferramenta de Gerenciamento mais importante do jogo. Ela contém todos os princípios, áreas, fases, papéis, atributos pessoais e desafios do jogo num único diagrama integrado. Dessa forma, você pode entender as relações entre cada elemento diagnosticado no contexto do seu projeto. Recorra à Bússola para descobrir o que fazer, onde atuar, para conhecer a si mesmo, à sua equipe, seu público e o ambiente onde está trabalhando.""",
            tip = "Pegue os cards de Ajuda A14, A15, A16 e A17 para saber mais sobre cada elemento da Bússola, o que eles significam e como eles podem ser aplicados.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A14",
            title = "AS FASES DO JOGO",
            question = "O começo, o meio e o fim do jogo.",
            summary = "Diagnóstico, Planejamento e Realização.",
            content = """O jogo possui 3 fases: 1. Diagnóstico (que é olhar para dentro e sentir); 2. Planejamento (que é olhar para os outros e pensar) e; 3. Realização (que é olhar para o mundo e agir). Cada uma dessas Fases tem suas ferramentas próprias, mas todas as ferramentas complementam umas às outras. É importante você e sua equipe adotarem a postura correta durante cada Fase, aplicando os atributos necessários para trabalhar cada Desafio.

1. FASE DE DIAGNÓSTICO: É a primeira fase, correspondendo à cor vermelha na Bússola. Durante esta fase, você vai precisar dos cards de diagnóstico. Os atributos pessoais mais fortes nesta fase são o sentir e a visão interna.

2. FASE DE PLANEJAMENTO: É a segunda fase, correspondendo à cor amarela na Bússola. Durante esta fase, você vai precisar dos cards de planejamento. Os atributos pessoais mais fortes nesta fase são o pensar e a visão externa.

3. FASE DE REALIZAÇÃO: É a terceira fase, correspondendo à cor azul na Bússola. Durante esta fase, você vai precisar dos cards de realização. Os atributos pessoais mais fortes nesta fase são o agir e a visão integral.

Na Fase de Diagnóstico você define objetivos, descreve os problemas, demandas e motivações de alguém por algo. Na Fase de Planejamento você descreve as ideias, propostas, recursos, metas e estratégias. E na Fase de Realização você realiza as tarefas, rotinas e avalia seu processo.""",
            tip = "Observe que as fases se alinham com as áreas, papéis e atributos pessoais. Pegue o card de Ajuda Atributos Pessoais A16 para saber sobre eles.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A15",
            title = "AS ÁREAS",
            question = "Onde você pode atuar.",
            summary = "As 6 áreas de atuação da vida e dos projetos.",
            content = """Observe as agulhas coloridas no centro da Bússola. Elas representam as 6 áreas de atuação da vida humana que o jogo aborda. Cada área possui seus próprios desafios e problemas, mas também as ferramentas necessárias para ajudar você a solucioná-los. Cada área está ligada a um papel dentro do jogo. Os papéis dão vida e sentido às áreas. Quando você quiser saber como agir ou precisar identificar-se mais com uma área, pegue o card de Papel P1 a P6 correspondente a ela.

O jogo abrange 6 áreas. Elas são: Desenvolvimento Humano, Comunicação, Trabalho em Equipe, Educação, Projetos e Gestão. Cada uma delas possui seus próprios desafios, problemas e propostas. Porém elas são complementares, interconectadas e integradas.

• DESENVOLVIMENTO HUMANO: O objetivo dessa área é desenvolver o ser humano, o auto-conhecimento das forças, fraquezas e potenciais.
• COMUNICAÇÃO: O objetivo dessa área é melhorar a comunicação e o entendimento entre as pessoas.
• TRABALHO EM EQUIPE: O objetivo dessa área é desenvolver as relações de trabalho entre as pessoas de uma equipe.
• EDUCAÇÃO: O objetivo dessa área é educar, instruir, aprender, conhecer, motivar, treinar e avaliar habilidades.
• PROJETOS: O objetivo dessa área é criar projetos, produtos e modelos de negócios e pô-los em prática.
• GESTÃO: O objetivo dessa área é manter o projeto ou negócio sustentável, administrando-o o melhor possível.""",
            tip = "Pegue os cards de Gerenciamento lilases de Áreas AR1 a AR6 para saber mais sobre seus principais problemas, desafios e algumas soluções propostas.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A16",
            title = "OS PAPÉIS",
            question = "Assumindo seu papel.",
            summary = "Os 6 papéis para atuar no jogo e gerenciar áreas.",
            content = """O jogo possui 6 papéis. Cada papel está relacionado a uma das 6 áreas do jogo. Você pode utilizar os papéis como exemplo ou referência para saber como se comportar, ou criar mais identificação e empatia com uma área. Um papel pode ser um cargo, função ou profissão que você desempenha no projeto. Você pode querer criar o seu próprio papel e os da sua equipe. Para isso, basta anotar o papel no card de Gerenciamento Ficha Pessoal FP, ou no card de Diagnóstico Papéis F9.

Há 6 papéis disponíveis no jogo. Eles são: o Mentor, o Mediador, o Facilitador, o Instrutor, o Projetista e o Gestor. Esses cards servem de exemplo para ajudar você a gerenciar cada área. Isso não impede você de criar seus próprios papéis para trabalhar nas Áreas de atuação dos seus projetos.

• O MENTOR: Ajuda as pessoas a se desenvolverem, a conhecerem a si mesmas em todos os aspectos.
• O MEDIADOR: Ajuda as pessoas a se entenderem, a negociarem, tomarem decisões e a se comunicarem melhor.
• O FACILITADOR: Ajuda as pessoas a fazerem algo juntas, a definirem seus papéis de acordo com as suas habilidades.
• O INSTRUTOR: Ajuda as pessoas a aprenderem e a desenvolverem suas habilidades e capacidades cognitivas.
• O PROJETISTA: Ajuda as pessoas a criarem seus projetos, produtos e negócios e a colocá-los em prática.
• O GESTOR: Ajuda as pessoas gerenciarem seus projetos e negócios, e a administrarem seus recursos.""",
            tip = "Pegue os cards lilases de Gerenciamento de Papéis P1 a P6 para saber mais sobre cada papel, os seus princípios, atributos e habilidades predominantes.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A17",
            title = "OS ATRIBUTOS PESSOAIS",
            question = "Identificando-se com o jogo.",
            summary = "Capacidades de ver, sentir, pensar e agir.",
            content = """Observe o card da Bússola. Ela possui todas as informações que você precisa para saber como agir em cada desafio ou demanda do projeto. Observe os ícones dos três olhos, do coração, do cérebro e do raio. Cada um deles está posicionado sobre uma das 3 fases do jogo. Isso significa que os seus atributos pessoais estão correlacionados com as fases do seu projeto. Isso é importante para distribuir as tarefas da equipe segundo os pontos fortes e momentos de cada um.

Há 6 atributos pessoais, que são as capacidades que todo ser humano tem de ver, sentir, pensar e agir em relação a si mesmo, aos outros e ao mundo. Olhe para si mesmo, reflita sinceramente sobre seus atributos pessoais. Procure aplicá-los melhor durante os seus projetos, trabalhos e desafios.

• SENTIR: É a capacidade de experienciar emoções, que vêm das relações consigo, com os outros e o mundo.
• PENSAR: É a capacidade de experienciar pensamentos, de visualizar e imaginar aquilo que você sente.
• AGIR: É a capacidade de experienciar ações e atitudes, de fazer aquilo que você sente e pensa.
• VISÃO INTERNA: É a capacidade de ver a si mesmo, seus atos, pensamentos, sentimentos e espiritualidade, e respeitar-se.
• VISÃO EXTERNA: É a capacidade de ver os outros, os atos, pensamentos, sentimentos e espiritualidade deles e respeitá-los.
• VISÃO INTEGRAL: É a capacidade de ver o mundo, o meio ambiente, o espaço à sua volta, e as relações que tudo têm com ele.""",
            tip = "Você pode anotar e mensurar seus atributos pessoais na Ficha Pessoal FP. Pegue o card de ajuda A14 e veja em qual fase cada atributo é mais requisitado.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        ),
        HelpCard(
            code = "A18",
            title = "EVOLUÇÃO E PROGRESSO",
            question = "Dando movimento ao jogo.",
            summary = "Cálculo de progresso, XP, níveis e recompensas.",
            content = """“Subir de nível” significa ficar melhor em alguma coisa. Ser recompensado é sinal de que você fez algo bom ou corretamente. Você pode se aperfeiçoar e subir de nível treinando suas habilidades, realizando tarefas, atingindo metas ou sendo bem avaliado. Repare que alguns cards possuem campos para preencher e mensurar seu progresso com “pontos” e “níveis”. Eles são: a Ficha Pessoal FP, Motivações F4, Habilidades F7, Metas F27, Tarefas F43 e Avaliação F48.

Há 2 formas de calcular o seu progresso e evolução no seu projeto. A primeira é você atribuir uma porcentagem de conclusão para suas metas, tarefas, rotinas ou treinos. A segunda é atribuir pontuações a cada uma delas, e os pontos poderem ser trocados por níveis e recompensas.

• XP - PONTOS DE EXPERIÊNCIA: Você pode atribuir uma certa quantidade de pontos a cada meta, tarefa, exercício ou avaliação que precisa ser feita. Ao realizar essas atividades, você recebe uma quantidade de pontos que podem ser trocados por níveis ou recompensas.
• SUBINDO DE NÍVEL: Você pode atribuir níveis a um cargo ou função, a serem atingidos por você ou pela equipe. Você também pode utilizá-los para medir níveis de motivação e satisfação. Basta atribuir uma quantidade de pontos a cada nível atingido.
• RECOMPENSAS: Você pode atribuir recompensas a cada nível atingido ou objective cumprido. Aplicar um sistema de níveis e recompensas ao seu projeto pode aumentar a motivação e o engajamento da equipe e o interesse do público pelo produto.""",
            tip = "Você pode anotar seus “pontos de experiência” na sua Ficha Pessoal FP. Ao final de um período, você pode somar os seus pontos e subir de nível.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = emptyList()
        )
    )

    val MANAGEMENT_CARDS: List<ManagementCard> = listOf(
        ManagementCard(
            code = "B",
            title = "Bússola",
            subtitle = "Qual é o seu desafio?",
            description = "A Bússola B é a ferramenta de Gerenciamento mais importante do jogo. Ela contém todos os princípios, áreas, fases, papéis, atributos pessoais e desafios do jogo num único diagrama integrado.",
            question = "Qual é o seu desafio?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P1", "F1", "A9"),
            formFields = listOf("Desafio / Objetivo", "Área de Atuação", "Fase de Foco"),
            tip = "Recorra à Bússola para descobrir o que fazer, onde atuar, para conhecer a si mesmo, à sua equipe e ambiente.",
            backContent = "A Bússola B é a ferramenta de Gerenciamento mais importante do jogo. Ela contém todos os princípios, áreas, fases, papéis, atributos pessoais e desafios do jogo num único diagrama integrado. Recorra à Bússola para descobrir o que fazer, onde atuar, para conhecer a si mesmo, à sua equipe, seu público e o ambiente onde está trabalhando.",
            backTip = "Pegue os cards de Ajuda A14, A15, A16 e A17 para saber mais sobre cada elemento da Bússola."
        ),
        ManagementCard(
            code = "PA",
            title = "Painel de Alinhamento",
            subtitle = "O que precisa ser alinhado?",
            description = "O Painel de Alinhamento PA permite reunir e conciliar propostas, expectativas e responsabilidades de todas as partes envolvidas no projeto.",
            question = "O que precisa ser alinhado?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P2", "F20", "A9"),
            formFields = listOf("Focalizar", "Acolher", "Validar"),
            tip = "Utilize o Painel de Alinhamento para negociar e alinhar acordos com a equipe e clientes.",
            backContent = "O Painel de Alinhamento PA permite reunir e conciliar propostas, expectativas e responsabilidades de todas as partes envolvidas no projeto. Ajuda a focalizar, acolher e validar os pontos vitais antes da tomada de decisão.",
            backTip = "Pegue o Painel de Alinhamento para ajudá-lo na negociação."
        ),
        ManagementCard(
            code = "FP",
            title = "Ficha Pessoal",
            subtitle = "Quem é você?",
            description = "A Ficha Pessoal FP registra o seu perfil no jogo, papel desempenhado, áreas de afinidade, atributos pessoais e pontuação de XP acumulada.",
            question = "Quem é você?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P3", "F11", "A9"),
            formFields = listOf("Nome", "Área", "Equipe", "Papel", "Nível", "Pontos"),
            tip = "Você pode anotar e mensurar seus atributos pessoais na Ficha Pessoal FP.",
            backContent = "A Ficha Pessoal FP registra o seu perfil no jogo, papel desempenhado, áreas de afinidade, atributos pessoais e pontuação de XP acumulada.",
            backTip = "Atualize seus pontos de experiência (XP) e acompanhe sua evolução no projeto."
        ),
        ManagementCard(
            code = "PC",
            title = "Painel de Controle",
            subtitle = "O que precisa ser monitorado?",
            description = "O Painel de Controle PC traz os indicadores vitais do projeto: vendas, clientes, progresso em %, caixa, estoques e notas de desempenho.",
            question = "O que precisa ser monitorado?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P4", "F48", "A9"),
            formFields = listOf("Nº Vendas", "Qtde. de Clientes", "Itens Produzidos", "Progresso %", "Caixa", "Prazo ou Duração"),
            tip = "Acompanhe as métricas e a saúde do seu projeto constantemente.",
            backContent = "O Painel de Controle PC traz os indicadores vitais do projeto: vendas, clientes, progresso em %, caixa, estoques e notas de desempenho para acompanhamento constante.",
            backTip = "Utilize os números do Painel de Controle para orientar tomadas de decisão."
        ),
        ManagementCard(
            code = "M",
            title = "Mapa",
            subtitle = "Quais são as ferramentas necessárias?",
            description = "O Mapa M lista a receita de cards necessários para o projeto. No seu verso há o gabarito completo com todos os códigos de cards.",
            question = "Quais são as ferramentas necessárias?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P5", "F28", "A9"),
            formFields = listOf("Projeto / Desafio", "Cards Selecionados"),
            tip = "O Mapa M serve para marcar ou anotar os códigos dos cards que você deseja utilizar no seu projeto.",
            backContent = "O Mapa M lista a receita de cards necessários para o projeto. No seu verso há o gabarito completo com todos os códigos de cards para marcar seu progresso.",
            backTip = "Pegue o card de Ajuda A4 para aprender a compor e utilizar mapas de projetos."
        ),
        ManagementCard(
            code = "DB",
            title = "Diário de Bordo",
            subtitle = "O que precisa ser mantido atualizado?",
            description = "O Diário de Bordo DB registra o histórico do projeto no tempo, atualizações, datas e lições aprendidas.",
            question = "O que precisa ser mantido atualizado?",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P6", "F43", "A9"),
            formFields = listOf("N.", "Atualização", "Data"),
            tip = "Mantenha o Diário de Bordo atualizado a cada avanço relevante no projeto.",
            backContent = "O Diário de Bordo DB registra o histórico do projeto no tempo, atualizações, datas e lições aprendidas.",
            backTip = "Anote as lições aprendidas e conquistas da equipe ao longo do percurso."
        ),
        ManagementCard(
            code = "P1",
            title = "Mentor",
            subtitle = "Eu ajudo as pessoas a se melhorarem.",
            description = "Papel do Mentor. Princípio: Onde há empoderamento há liberdade.",
            question = "Eu ajudo as pessoas a se melhorarem.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("B", "AR1", "A16"),
            formFields = emptyList(),
            tip = "Procure desacelerar, fazer as coisas sem controlar tanto. Esteja onde lhe faz bem.",
            backContent = "PRINCÍPIO: Onde há empoderamento há liberdade.\nAÇÕES: Observar-se, conhecer-se, afirmar-se.\nÁREA: Desenvolvimento humano.\nPROBLEMA: Controle.\nHABILIDADE: Olhar apreciativo.",
            backTip = "Olá. Eu estou aqui para lembrar você que nunca é tarde para melhorar."
        ),
        ManagementCard(
            code = "P2",
            title = "Mediador",
            subtitle = "Eu ajudo as pessoas a se alinharem.",
            description = "Papel do Mediador. Princípio: Onde há alinhamento há sinergia.",
            question = "Eu ajudo as pessoas a se alinharem.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("PA", "AR2", "A16"),
            formFields = emptyList(),
            tip = "A comunicação é a chave para o entendimento mútuo. Procure ser educado ouvindo e dialogando.",
            backContent = "PRINCÍPIO: Onde há alinhamento há sinergia.\nAÇÕES: Ouvir, dialogar, alinhar.\nÁREA: Comunicação.\nPROBLEMA: Conflito.\nHABILIDADE: Comunicação empática.",
            backTip = "Não seja antipático. Compartilhe visões e dê feedbacks construtivos."
        ),
        ManagementCard(
            code = "P3",
            title = "Facilitador",
            subtitle = "Eu ajudo as pessoas a trabalharem juntas.",
            description = "Papel do Facilitador. Princípio: Onde há cocriação há colaboração.",
            question = "Eu ajudo as pessoas a trabalharem juntas.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("FP", "AR3", "A16"),
            formFields = emptyList(),
            tip = "O trabalho em equipe pode levar a grandes conquistas e resultados.",
            backContent = "PRINCÍPIO: Onde há cocriação há colaboração.\nAÇÕES: Focalizar, organizar, mobilizar.\nÁREA: Trabalho em Equipe.\nPROBLEMA: Competição.\nHABILIDADE: Tomada de decisões.",
            backTip = "Não seja egoísta nem fique reclamando. Faça a sua parte e faça bem feito."
        ),
        ManagementCard(
            code = "P4",
            title = "Instrutor",
            subtitle = "Eu ajudo as pessoas a aprenderem.",
            description = "Papel do Instrutor. Princípio: Onde há desafio há motivação.",
            question = "Eu ajudo as pessoas a aprenderem.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("PC", "AR4", "A16"),
            formFields = emptyList(),
            tip = "Nunca é tarde demais para aprender e começar coisas novas. Estude e pratique muito.",
            backContent = "PRINCÍPIO: Onde há desafio há motivação.\nAÇÕES: Aprender, simular, praticar.\nÁREA: Educação.\nPROBLEMA: Desânimo.\nHABILIDADE: Resolução de problemas.",
            backTip = "Trabalhe, estude e divirta-se com as coisas que você gosta sem desistir."
        ),
        ManagementCard(
            code = "P5",
            title = "Projetista",
            subtitle = "Eu ajudo as pessoas a criarem.",
            description = "Papel do Projetista. Princípio: Onde há criatividade há inovação.",
            question = "Eu ajudo as pessoas a criarem.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("M", "AR5", "A16"),
            formFields = emptyList(),
            tip = "A criatividade é uma habilidade natural. Inspire-se em coisas belas e elevadas.",
            backContent = "PRINCÍPIO: Onde há criatividade há inovação.\nAÇÕES: Visualizar, projetar, realizar.\nÁREA: Criação de projetos.\nPROBLEMA: Estagnação.\nHABILIDADE: Visualização criativa.",
            backTip = "Leia mais ou ouça mais coisas que estimulem a sua imaginação."
        ),
        ManagementCard(
            code = "P6",
            title = "Gestor",
            subtitle = "Eu ajudo as pessoas a gerenciarem.",
            description = "Papel do Gestor. Princípio: Onde há abundância há sustentabilidade.",
            question = "Eu ajudo as pessoas a gerenciarem.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("DB", "AR6", "A16"),
            formFields = emptyList(),
            tip = "É importante cuidar das coisas materiais. Gerencie melhor o seu tempo e recursos.",
            backContent = "PRINCÍPIO: Onde há abundância há sustentabilidade.\nAÇÕES: Empreender, gerenciar, administrar.\nÁREA: Gestão.\nPROBLEMA: Escassez.\nHABILIDADE: Adaptação às mudanças.",
            backTip = "Conserve e preserve o que você tem, economize e gaste com sabedoria."
        ),
        ManagementCard(
            code = "AR1",
            title = "Desenvolvimento Humano",
            subtitle = "Desafios para desenvolver as pessoas.",
            description = "Área Desenvolvimento Humano. Cuida do ser humano como um ser integral.",
            question = "Desafios para desenvolver as pessoas.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P1", "D1", "D2", "D3", "A15"),
            formFields = emptyList(),
            tip = "Trata de aperfeiçoamento, melhoria, progresso e evolução dos pontos fortes e fracos.",
            backContent = "Esta Área cuida do ser humano, da pessoa, do indivíduo, com um ser integral, nos seus aspectos emocional, mental, físico e espiritual. Trata de aperfeiçoamento, melhoria, progresso e evolução, de trabalhar seus pontos fortes, fracos e potenciais.",
            backTip = "Principais problemas: excesso de controle, pressão de líderes, falta de liberdade e auto-conhecimento."
        ),
        ManagementCard(
            code = "AR2",
            title = "Comunicação",
            subtitle = "Desafios para melhorar a comunicação.",
            description = "Área Comunicação. Cuida do alinhamento e diálogo entre as pessoas.",
            question = "Desafios para melhorar a comunicação.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P2", "D4", "D5", "D6", "A15"),
            formFields = emptyList(),
            tip = "Trata do modo como as pessoas falam, ouvem, dialogam e se expressam.",
            backContent = "Esta Área cuida da comunicação entre as pessoas, quando precisam se alinhar para trabalharem juntas com sinergia e tomarem decisões. Trata do modo como elas falam, ouvem, dialogam, se expressam e dão feedbacks.",
            backTip = "Principais problemas: conflitos entre pessoas, falta de alinhamento, ruídos e fofocas."
        ),
        ManagementCard(
            code = "AR3",
            title = "Trabalho em Equipe",
            subtitle = "Desafios para facilitar o trabalho em equipe.",
            description = "Área Trabalho em Equipe. Cuida da cooperação e autonomia do time.",
            question = "Desafios para facilitar o trabalho em equipe.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P3", "D7", "D8", "D9", "A15"),
            formFields = emptyList(),
            tip = "Trata de como as equipes focam no que precisa ser feito, se organizam e se mobilizam.",
            backContent = "Esta Área cuida da relação de trabalho entre as pessoas, considerando os líderes e gestores, e o nível de autonomia e auto-gerenciamento da equipe. Trata de como as equipes focam no que precisa ser feito.",
            backTip = "Principais problemas: competitividade e individualismo, falta de engajamento."
        ),
        ManagementCard(
            code = "AR4",
            title = "Educação",
            subtitle = "Desafios para melhorar o aprendizado.",
            description = "Área Educação. Cuida do ensino, aprendizado e desenvolvimento de habilidades.",
            question = "Desafios para melhorar o aprendizado.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P4", "D10", "D11", "D12", "A15"),
            formFields = emptyList(),
            tip = "Trata dos princípios didáticos, métodos e ferramentas aplicadas para alcançar resultados.",
            backContent = "Esta Área cuida do ensino e do aprendizado, considerando o instrutor e o aluno, com suas dificuldades e limitações, seu histórico, espaço e tempo. Trata dos princípios didáticos e métodos.",
            backTip = "Principais problemas: falta de motivação, desânimo e problemas de aprendizado."
        ),
        ManagementCard(
            code = "AR5",
            title = "Projetos",
            subtitle = "Desafios para estimular a criatividade.",
            description = "Área Projetos. Cuida do desenho e materialização de produtos e novos negócios.",
            question = "Desafios para estimular a criatividade.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P5", "D13", "D14", "D15", "A15"),
            formFields = emptyList(),
            tip = "Trata de reunir ferramentas para desenhar um produto ou negócio e pô-lo em prática.",
            backContent = "Esta Área cuida da criação de projetos, considerando quem está criando, o que está sendo criado e como está sendo realizado. Trata de reunir as ferramentas e recursos necessários.",
            backTip = "Principais problemas: estagnação por falta de iniciativa, dinheiro ou ideias."
        ),
        ManagementCard(
            code = "AR6",
            title = "Gestão",
            subtitle = "Desafios de gerenciamento.",
            description = "Área Gestão. Cuida dos recursos, finanças e tempo para garantir sustentabilidade.",
            question = "Desafios de gerenciamento.",
            durationMinutes = 5,
            xpPoints = 5,
            sockets = listOf("P6", "D16", "D17", "D18", "A15"),
            formFields = emptyList(),
            tip = "Trata de gerenciar e investir os recursos de modo a aumentar a produtividade.",
            backContent = "Esta Área cuida da gestão de recursos, dinheiro e tempo, considerando as demandas das equipes e projetos onde esses recursos são necessários. Trata de gerenciar e investir de modo sustentável.",
            backTip = "Principais problemas: escassez de recursos e dinheiro, falta de orçamentos e prazos."
        )
    )

    fun findUniversalCard(code: String): UniversalCard? {
        val upper = code.trim().uppercase()
        val tool = TOOL_CARDS.find { it.code.uppercase() == upper }
        if (tool != null) return UniversalCard.Tool(tool)

        val help = HELP_CARDS.find { it.code.uppercase() == upper }
        if (help != null) return UniversalCard.Help(help)

        val challenge = CHALLENGES.find { it.code.uppercase() == upper }
        if (challenge != null) return UniversalCard.ChallengeCard(challenge)

        val mgmt = MANAGEMENT_CARDS.find { it.code.uppercase() == upper }
        if (mgmt != null) return UniversalCard.Management(mgmt)

        return null
    }
}
