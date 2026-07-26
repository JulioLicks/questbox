package com.example.ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.model.Area
import com.example.data.model.Challenge
import com.example.data.model.QuestboxData
import com.example.data.model.UniversalCard
import com.example.ui.MainViewModel
import com.example.ui.components.UniversalCardDialog
import com.example.ui.components.UniversalCardView

import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.IconButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChallengesScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    var selectedAreaFilter by remember { mutableStateOf<Area?>(viewModel.activeAreaFilter) }
    var selectedUniversalCard by remember { mutableStateOf<UniversalCard?>(null) }
    var dialogInitialTab by remember { androidx.compose.runtime.mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    val isGridLayout by viewModel.isGridLayout.collectAsState()

    LaunchedEffect(viewModel.activeAreaFilter) {
        viewModel.activeAreaFilter?.let { filter ->
            selectedAreaFilter = filter
            viewModel.activeAreaFilter = null
        }
    }

    val filteredChallenges = remember(selectedAreaFilter, searchQuery) {
        QuestboxData.CHALLENGES.filter { challenge ->
            val matchesArea = selectedAreaFilter == null || challenge.areaCode == selectedAreaFilter?.code
            val matchesSearch = searchQuery.isBlank() ||
                    challenge.title.contains(searchQuery, ignoreCase = true) ||
                    challenge.code.contains(searchQuery, ignoreCase = true) ||
                    challenge.description.contains(searchQuery, ignoreCase = true)
            matchesArea && matchesSearch
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("challenges_screen")
    ) {

        // Controls Row: Search & Layout Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar desafios...") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("search_challenges"),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = { viewModel.toggleLayout() },
                modifier = Modifier
                    .testTag("toggle_layout_button_challenges")
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = if (isGridLayout) Icons.Default.ViewList else Icons.Default.GridView,
                    contentDescription = if (isGridLayout) "Visualizar em Lista (1 por vez)" else "Visualizar em Grade (2 a 2)"
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Area Tabs
        val areas = Area.values()
        val allTabs = listOf(null) + areas.toList()
        val selectedIndex = allTabs.indexOf(selectedAreaFilter).takeIf { it != -1 } ?: 0

        androidx.compose.material3.ScrollableTabRow(
            selectedTabIndex = selectedIndex,
            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = Color.White,
            divider = { 
                androidx.compose.material3.Divider(color = Color.White.copy(alpha = 0.2f), thickness = 1.dp)
            },
            indicator = { tabPositions ->
                val color = if (selectedIndex == 0) Color.White else (selectedAreaFilter?.color ?: Color.White)
                androidx.compose.material3.TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                    color = color,
                    height = 3.dp
                )
            }
        ) {
            val unselectedColor = Color.Gray

            allTabs.forEachIndexed { index, area ->
                val isSelected = index == selectedIndex
                val tabColor = if (index == 0) Color.White else (area?.color ?: Color.White)
                
                androidx.compose.material3.Tab(
                    selected = isSelected,
                    onClick = { selectedAreaFilter = area },
                    text = { 
                        Text(
                            text = if (area == null) "Todas as Áreas" else "${area.code} ${area.title}", 
                            color = if (isSelected) tabColor else unselectedColor,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        ) 
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Challenge Cards List
        val isGridLayout by viewModel.isGridLayout.collectAsState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (isGridLayout) 2 else 1),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(filteredChallenges) { challenge ->
                val uCard = UniversalCard.ChallengeCard(challenge)
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

    // Universal Card Dialog for Challenges and related socket cards
    selectedUniversalCard?.let { uCard ->
        UniversalCardDialog(
            initialCard = uCard,
            initialTab = dialogInitialTab,
            onStartChallenge = { challenge -> viewModel.startChallengeProject(challenge) },
            onDismiss = { selectedUniversalCard = null }
        )
    }
}
