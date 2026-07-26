package com.example.ui.screens
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import com.example.data.model.HelpCard
import com.example.data.model.Phase
import com.example.data.model.QuestboxData
import com.example.data.model.ToolCard
import com.example.ui.MainViewModel
import com.example.ui.components.CardFormDialog
import com.example.ui.components.QuestCardView

import com.example.data.model.UniversalCard
import com.example.ui.components.UniversalCardDialog
import com.example.ui.components.UniversalCardView

import androidx.compose.foundation.background
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.IconButton

@Composable
fun ToolCardsScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    var selectedTabIdx by remember { mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedUniversalCard by remember { mutableStateOf<UniversalCard?>(null) }
    var dialogInitialTab by remember { mutableIntStateOf(0) }
    val isGridLayout by viewModel.isGridLayout.collectAsState()

    val aiState by viewModel.aiState.collectAsState()

    val phases = listOf(null, Phase.DIAGNOSTICO, Phase.PLANEJAMENTO, Phase.REALIZACAO, null)
    LaunchedEffect(viewModel.activePhaseFilter) {
        viewModel.activePhaseFilter?.let { filter ->
            selectedTabIdx = phases.indexOf(filter).takeIf { it != -1 } ?: 0
            viewModel.activePhaseFilter = null
        }
    }

    val filteredUniversalCards = remember(selectedTabIdx, searchQuery) {
        val allCards = if (selectedTabIdx == 4) {
            QuestboxData.MANAGEMENT_CARDS.map { UniversalCard.Management(it) }
        } else {
            val currentPhase = phases[selectedTabIdx]
            QuestboxData.TOOL_CARDS.filter { card ->
                currentPhase == null || card.phase == currentPhase
            }.map { UniversalCard.Tool(it) }
        }

        allCards.filter { card ->
            searchQuery.isBlank() ||
                    card.code.contains(searchQuery, ignoreCase = true) ||
                    card.title.contains(searchQuery, ignoreCase = true) ||
                    card.questionOrSubtitle.contains(searchQuery, ignoreCase = true) ||
                    card.sockets.any { it.contains(searchQuery, ignoreCase = true) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("tool_cards_screen")
    ) {

        // Controls Row: Search & Layout Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar ferramentas...") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("search_tool_cards"),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = { viewModel.toggleLayout() },
                modifier = Modifier
                    .testTag("toggle_layout_button_tools")
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = if (isGridLayout) Icons.Default.ViewList else Icons.Default.GridView,
                    contentDescription = if (isGridLayout) "Visualizar em Lista (1 por vez)" else "Visualizar em Grade (2 a 2)"
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Phase Tabs
        ScrollableTabRow(
            selectedTabIndex = selectedTabIdx,
            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = Color.White,
            divider = { 
                androidx.compose.material3.Divider(color = Color.White.copy(alpha = 0.2f), thickness = 1.dp)
            },
            indicator = { tabPositions ->
                val color = when (selectedTabIdx) {
                    0 -> Color.White
                    1 -> Phase.DIAGNOSTICO.color
                    2 -> Phase.PLANEJAMENTO.color
                    3 -> Phase.REALIZACAO.color
                    4 -> Color(0xFF9C27B0)
                    else -> Color.White
                }
                androidx.compose.material3.TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIdx]),
                    color = color,
                    height = 3.dp
                )
            }
        ) {
            val unselectedColor = Color.Gray

            Tab(
                selected = selectedTabIdx == 0,
                onClick = { selectedTabIdx = 0 },
                text = { 
                    Text(
                        "Todos (54)", 
                        color = if (selectedTabIdx == 0) Color.White else unselectedColor,
                        fontWeight = if (selectedTabIdx == 0) FontWeight.Bold else FontWeight.Normal
                    ) 
                }
            )
            Tab(
                selected = selectedTabIdx == 1,
                onClick = { selectedTabIdx = 1 },
                text = { 
                    Text(
                        "Diagnóstico (F1-F18)", 
                        color = if (selectedTabIdx == 1) Phase.DIAGNOSTICO.color else unselectedColor,
                        fontWeight = if (selectedTabIdx == 1) FontWeight.Bold else FontWeight.Normal
                    ) 
                }
            )
            Tab(
                selected = selectedTabIdx == 2,
                onClick = { selectedTabIdx = 2 },
                text = { 
                    Text(
                        "Planejamento (F19-F36)", 
                        color = if (selectedTabIdx == 2) Phase.PLANEJAMENTO.color else unselectedColor,
                        fontWeight = if (selectedTabIdx == 2) FontWeight.Bold else FontWeight.Normal
                    ) 
                }
            )
            Tab(
                selected = selectedTabIdx == 3,
                onClick = { selectedTabIdx = 3 },
                text = { 
                    Text(
                        "Realização (F37-F54)", 
                        color = if (selectedTabIdx == 3) Phase.REALIZACAO.color else unselectedColor,
                        fontWeight = if (selectedTabIdx == 3) FontWeight.Bold else FontWeight.Normal
                    ) 
                }
            )
            Tab(
                selected = selectedTabIdx == 4,
                onClick = { selectedTabIdx = 4 },
                text = { 
                    Text(
                        "Gerenciamento (18)", 
                        color = if (selectedTabIdx == 4) Color(0xFF9C27B0) else unselectedColor,
                        fontWeight = if (selectedTabIdx == 4) FontWeight.Bold else FontWeight.Normal
                    ) 
                }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Grid of Cards
        val isGridLayout by viewModel.isGridLayout.collectAsState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (isGridLayout) 2 else 1),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredUniversalCards) { uCard ->
                UniversalCardView(
                    universalCard = uCard,
                    onClick = { tabIdx ->
                        selectedUniversalCard = uCard
                        dialogInitialTab = tabIdx
                    },
                    onSocketClick = { socketCode ->
                        val target = QuestboxData.findUniversalCard(socketCode)
                        selectedUniversalCard = target ?: uCard
                        dialogInitialTab = 0
                    }
                )
            }
        }
    }

    // Modal Card Viewer / Field Inspector Dialog
    selectedUniversalCard?.let { uCard ->
        UniversalCardDialog(
            initialCard = uCard,
            initialTab = dialogInitialTab,
            onDismiss = { selectedUniversalCard = null }
        )
    }
}

