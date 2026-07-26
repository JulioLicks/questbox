package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items as gridItems
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items as lazyItems
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.model.Area
import com.example.data.model.QuestboxData
import com.example.data.model.ToolCard
import com.example.ui.MainViewModel
import com.example.ui.Screen
import com.example.ui.components.CardFormDialog
import com.example.ui.components.QuestCardView

@Composable
fun ProjectDetailScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val project by viewModel.selectedProject.collectAsState()
    val entries by viewModel.activeProjectEntries.collectAsState()
    val aiState by viewModel.aiState.collectAsState()

    val logs by viewModel.activeProjectLogs.collectAsState()
    
    var selectedCardForEditing by remember { mutableStateOf<ToolCard?>(null) }
    var showAddCardDialog by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(0) } // 0 = Mapa, 1 = Diário de Bordo

    if (project == null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Nenhum projeto selecionado.")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { viewModel.navigateTo(Screen.Projects) }) {
                Text("Voltar para Meus Projetos")
            }
        }
        return
    }

    val proj = project!!
    val area = Area.values().find { it.code == proj.areaCode } ?: Area.AR5

    val completedCount = entries.count { it.isCompleted }
    val totalCount = entries.size
    val progressPercent = if (totalCount > 0) completedCount.toFloat() / totalCount else 0f

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("project_detail_screen")
    ) {
        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { viewModel.navigateTo(Screen.Projects) },
                modifier = Modifier.testTag("btn_back_to_projects")
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar"
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = area.color.copy(alpha = 0.2f)
                ) {
                    Text(
                        text = "DESAFIO ${proj.challengeCode} • ${area.code}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = area.color,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                Text(
                    text = proj.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }

                IconButton(
                    onClick = { showAddCardDialog = true },
                    modifier = Modifier.testTag("btn_add_card_to_map")
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Adicionar Card",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            } // Close Row

        Spacer(modifier = Modifier.height(12.dp))

        TabRow(selectedTabIndex = selectedTab) {
            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                Text("Mapa M", modifier = Modifier.padding(16.dp), fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal)
            }
            Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
                Text("Diário de Bordo", modifier = Modifier.padding(16.dp), fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal)
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))

        if (selectedTab == 0) {
            // Progress Card (Painel do Mapa M)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "MAPA DE FERRAMENTAS",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "XP",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${proj.totalXp} XP",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                LinearProgressIndicator(
                    progress = { progressPercent },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(CircleShape),
                    color = area.color,
                    trackColor = area.color.copy(alpha = 0.2f)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$completedCount de $totalCount cards concluídos",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Text(
                        text = "${(progressPercent * 100).toInt()}%",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = area.color
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

            // Grid of Active Cards in the Project Map
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                gridItems(entries) { entry ->
                    val card = QuestboxData.TOOL_CARDS.find { it.code == entry.cardCode }
                    if (card != null) {
                        QuestCardView(
                            card = card,
                            isCompleted = entry.isCompleted,
                            onClick = { selectedCardForEditing = card },
                            onSocketClick = { socketCard -> selectedCardForEditing = socketCard }
                        )
                    }
                }
            }
        } else {
            // Diário de Bordo View
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                lazyItems(logs) { log ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                            val dateStr = sdf.format(Date(log.timestamp))
                            
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(
                                    text = log.eventType,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.labelMedium
                                )
                                Text(
                                    text = dateStr,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = log.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    } // Closes main Column

    // Modal Card Editing Dialog
    selectedCardForEditing?.let { card ->
        val existingEntry = entries.find { it.cardCode == card.code }
        val currentFieldData = existingEntry?.let { viewModel.parseFieldJson(it.fieldDataJson) } ?: emptyMap()
        val isCompleted = existingEntry?.isCompleted ?: false

        CardFormDialog(
            card = card,
            initialData = currentFieldData,
            initialIsCompleted = isCompleted,
            aiState = aiState,
            onSave = { fieldData, completed ->
                viewModel.saveCardEntryData(
                    projectId = proj.id,
                    cardCode = card.code,
                    isCompleted = completed,
                    fieldData = fieldData
                )
            },
            onAskAiSuggestions = { c, currentData ->
                viewModel.generateCardSuggestionsWithAi(c, currentData)
            },
            onDismiss = { selectedCardForEditing = null }
        )
    }

    // Dialog to Select and Add a Card to Project Map
    if (showAddCardDialog) {
        Dialog(onDismissRequest = { showAddCardDialog = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "ADICIONAR CARD AO MAPA",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 130.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                    ) {
                        gridItems(QuestboxData.TOOL_CARDS) { card ->
                            val alreadyInMap = entries.any { it.cardCode == card.code }

                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(enabled = !alreadyInMap) {
                                        viewModel.addCardToActiveProject(card.code)
                                        showAddCardDialog = false
                                    },
                                shape = RoundedCornerShape(12.dp),
                                color = if (alreadyInMap) Color.Gray.copy(alpha = 0.2f) else card.phase.color.copy(alpha = 0.15f)
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        text = card.code,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = if (alreadyInMap) Color.Gray else card.phase.color
                                    )
                                    Text(
                                        text = card.title,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        maxLines = 1
                                    )
                                    if (alreadyInMap) {
                                        Text(
                                            text = "Já no mapa",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontSize = 9.sp,
                                            color = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedButton(
                        onClick = { showAddCardDialog = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Fechar")
                    }
                }
            }
        }
    }
}
