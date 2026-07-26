package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
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
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.QuestboxData
import com.example.data.model.UniversalCard

fun extractMentionedCardCodes(text: String): List<String> {
    if (text.isBlank()) return emptyList()
    val regex = Regex("""\b(AR[1-6]|P[1-6]|A[1-9]|A1[0-8]|F[1-9]|F[1-4][0-9]|F50|[BMP]|PA|FP|PC|DB|C[1-9]|C10)\b""", RegexOption.IGNORE_CASE)
    return regex.findAll(text)
        .map { it.value.uppercase() }
        .distinct()
        .filter { QuestboxData.findUniversalCard(it) != null }
        .toList()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UniversalCardDialog(
    initialCard: UniversalCard,
    initialTab: Int = 0,
    initialData: Map<String, String> = emptyMap(),
    initialIsCompleted: Boolean = false,
    onSave: ((fieldData: Map<String, String>, isCompleted: Boolean) -> Unit)? = null,
    onStartChallenge: ((challenge: com.example.data.model.Challenge) -> Unit)? = null,
    onDismiss: () -> Unit
) {
    var currentCard by remember(initialCard) { mutableStateOf(initialCard) }
    var activeTab by remember(currentCard) { mutableIntStateOf(0) } // 0 = Frente, 1 = Verso, always defaults to 0 when card changes

    val fieldValues = remember(currentCard) {
        mutableStateMapOf<String, String>().apply {
            currentCard.formFields.forEach { field ->
                put(field, initialData[field] ?: "")
            }
        }
    }
    var isCompleted by remember { mutableStateOf(initialIsCompleted) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .padding(16.dp)
                .testTag("universal_card_dialog_${currentCard.code}"),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                // Top Header Bar: Type on left, Close button on right
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(currentCard.headerColor)
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = currentCard.typeLabel,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            letterSpacing = 0.5.sp
                        )

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier.testTag("close_universal_card_dialog")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Fechar",
                                tint = Color.Black
                            )
                        }
                    }
                }

                // Tabs below Title Box, Aligned to Left as real tabs
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f))
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Tab Frente
                    Column(
                        modifier = Modifier
                            .clickable { activeTab = 0 }
                            .padding(top = 10.dp, bottom = 6.dp, start = 4.dp, end = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Frente",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Normal,
                            color = if (activeTab == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .height(3.dp)
                                .width(40.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(if (activeTab == 0) MaterialTheme.colorScheme.primary else Color.Transparent)
                        )
                    }

                    // Tab Verso
                    Column(
                        modifier = Modifier
                            .clickable { activeTab = 1 }
                            .padding(top = 10.dp, bottom = 6.dp, start = 16.dp, end = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Verso",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Normal,
                            color = if (activeTab == 1) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .height(3.dp)
                                .width(40.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(if (activeTab == 1) MaterialTheme.colorScheme.primary else Color.Transparent)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    // Title row with code on left and UPPERCASE YELLOW title text
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.2f))
                        ) {
                            Text(
                                text = currentCard.code,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Black,
                                color = Color.Black,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = currentCard.title.uppercase(),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFFFC107)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    if (activeTab == 0) {
                        // FRENTE TAB CONTENT
                        Text(
                            text = currentCard.questionOrSubtitle,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Info Row: Duration and XP
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, contentDescription = "XP", tint = Color(0xFFFFB300), modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("${currentCard.xpPoints} XP", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)

                                Spacer(modifier = Modifier.width(16.dp))

                                Icon(Icons.Default.Schedule, contentDescription = "Tempo", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("${currentCard.durationMinutes} min", style = MaterialTheme.typography.labelMedium)
                            }
                        }

                        // Sockets (Encaixes) - ALL CLICKABLE
                        if (currentCard.sockets.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "ENCAIXES",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 10.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                currentCard.sockets.forEach { socketCode ->
                                    val targetCard = QuestboxData.findUniversalCard(socketCode)
                                    val socketColor = targetCard?.headerColor ?: Color.Gray

                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = socketColor.copy(alpha = 0.15f),
                                        modifier = Modifier.clickable {
                                            if (targetCard != null) {
                                                currentCard = targetCard
                                                activeTab = 0
                                            }
                                        }
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = socketCode,
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = socketColor
                                            )
                                            if (targetCard != null) {
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = targetCard.title,
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Form Fields if editable
                        if (currentCard.formFields.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Divider()
                            Spacer(modifier = Modifier.height(16.dp))

                            currentCard.formFields.forEach { fieldLabel ->
                                OutlinedTextField(
                                    value = fieldValues[fieldLabel] ?: "",
                                    onValueChange = { newValue ->
                                        fieldValues[fieldLabel] = newValue
                                    },
                                    label = { Text(fieldLabel) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    singleLine = false,
                                    maxLines = 3
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            // Completion Checkbox
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { isCompleted = !isCompleted }
                                    .padding(vertical = 4.dp)
                            ) {
                                Checkbox(
                                    checked = isCompleted,
                                    onCheckedChange = { isCompleted = it }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Marcar card como Concluído (+${currentCard.xpPoints} XP)",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCompleted) Color(0xFF2E7D32) else MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    } else {
                        // VERSO TAB CONTENT
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp)),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = currentCard.backContent,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        if (currentCard.backTip.isNotBlank()) {
                            Spacer(modifier = Modifier.height(12.dp))
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = "💡 DICA:",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = currentCard.backTip,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }
                            }
                        }

                        // Related / Mentioned / Socket Cards - ALL CLICKABLE
                        val relatedCodes = remember(currentCard) {
                            (currentCard.sockets + extractMentionedCardCodes("${currentCard.backContent} ${currentCard.backTip}"))
                                .distinct()
                                .filter { it != currentCard.code }
                        }

                        if (relatedCodes.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "CARDS RELACIONADOS",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 10.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                relatedCodes.forEach { cardCode ->
                                    val targetCard = QuestboxData.findUniversalCard(cardCode)
                                    val cardColor = targetCard?.headerColor ?: Color.Gray

                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = cardColor.copy(alpha = 0.15f),
                                        modifier = Modifier.clickable {
                                            if (targetCard != null) {
                                                currentCard = targetCard
                                                activeTab = 0
                                            }
                                        }
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = cardCode,
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = cardColor
                                            )
                                            if (targetCard != null) {
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Text(
                                                    text = targetCard.title.uppercase(),
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Action Buttons - Centered in footer
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(onClick = onDismiss) {
                            Text("Fechar")
                        }

                        if (currentCard is UniversalCard.ChallengeCard && onStartChallenge != null) {
                            Spacer(modifier = Modifier.width(12.dp))

                            Button(
                                onClick = {
                                    onStartChallenge((currentCard as UniversalCard.ChallengeCard).challenge)
                                    onDismiss()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = currentCard.headerColor
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Iniciar",
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Iniciar Desafio")
                            }
                        }

                        if (onSave != null && currentCard.formFields.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(12.dp))

                            Button(
                                onClick = {
                                    onSave(fieldValues.toMap(), isCompleted)
                                    onDismiss()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = currentCard.headerColor
                                )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Salvar",
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Salvar Card")
                            }
                        }
                    }
                }
            }
        }
    }
}
