package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.HelpCard
import com.example.data.model.QuestboxData
import com.example.data.model.UniversalCard
import com.example.ui.MainViewModel
import com.example.ui.components.UniversalCardDialog
import com.example.ui.components.UniversalCardView

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileAndGuideScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    var selectedHelpCard by remember { mutableStateOf<HelpCard?>(null) }
    var dialogInitialTab by remember { mutableIntStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    val isGridLayout by viewModel.isGridLayout.collectAsState()

    val filteredCards = remember(searchQuery) {
        QuestboxData.HELP_CARDS.filter {
            searchQuery.isBlank() ||
            it.title.contains(searchQuery, ignoreCase = true) ||
            it.code.contains(searchQuery, ignoreCase = true) ||
            it.question.contains(searchQuery, ignoreCase = true) ||
            it.summary.contains(searchQuery, ignoreCase = true) ||
            it.content.contains(searchQuery, ignoreCase = true) ||
            it.sockets.any { s -> s.contains(searchQuery, ignoreCase = true) }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("profile_and_guide_screen")
    ) {
        // Controls Row: Search & Layout Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar nos cards de ajuda...") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("search_help_cards"),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = { viewModel.toggleLayout() },
                modifier = Modifier
                    .testTag("toggle_layout_button")
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = if (isGridLayout) Icons.Default.ViewList else Icons.Default.GridView,
                    contentDescription = if (isGridLayout) "Visualizar em Lista (1 por vez)" else "Visualizar em Grade (2 a 2)"
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Grid / List of Help Cards
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (isGridLayout) 2 else 1),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredCards) { helpCard ->
                HelpCardView(
                    card = helpCard,
                    onClick = { tabIdx ->
                        selectedHelpCard = helpCard
                        dialogInitialTab = tabIdx
                    },
                    onSocketClick = { socketCode ->
                        val targetHelp = QuestboxData.HELP_CARDS.find { it.code == socketCode }
                        if (targetHelp != null) {
                            selectedHelpCard = targetHelp
                            dialogInitialTab = 0
                        } else {
                            selectedHelpCard = helpCard
                            dialogInitialTab = 0
                        }
                    }
                )
            }
        }
    }

    // Modal Card Viewer for HelpCard
    selectedHelpCard?.let { card ->
        HelpCardDialog(
            card = card,
            initialTab = dialogInitialTab,
            onDismiss = { selectedHelpCard = null },
            onNavigateToCard = { targetCode ->
                val targetHelp = QuestboxData.HELP_CARDS.find { it.code == targetCode }
                if (targetHelp != null) {
                    selectedHelpCard = targetHelp
                    dialogInitialTab = 0
                }
            }
        )
    }
}

@Composable
fun HelpCardView(
    card: HelpCard,
    onClick: (tabIndex: Int) -> Unit,
    onSocketClick: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    UniversalCardView(
        universalCard = UniversalCard.Help(card),
        onClick = onClick,
        onSocketClick = onSocketClick,
        modifier = modifier
    )
}

@Composable
fun HelpCardDialog(
    card: HelpCard,
    initialTab: Int = 0,
    onDismiss: () -> Unit,
    onNavigateToCard: (String) -> Unit
) {
    UniversalCardDialog(
        initialCard = UniversalCard.Help(card),
        initialTab = initialTab,
        onDismiss = onDismiss
    )
}
