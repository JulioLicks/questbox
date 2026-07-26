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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.data.model.QuestboxData
import com.example.data.model.ToolCard
import com.example.data.model.UniversalCard

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UniversalCardView(
    universalCard: UniversalCard,
    isCompleted: Boolean = false,
    initialTab: Int = 0,
    onClick: (tabIndex: Int) -> Unit = {},
    onSocketClick: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    var activeTab by remember(universalCard) { mutableIntStateOf(0) } // 0 = Frente, 1 = Verso, always defaults to 0 when card changes

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick(activeTab) }
            .testTag("universal_card_${universalCard.code}"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header Bar: Type on left
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(universalCard.headerColor)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = universalCard.typeLabel,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    letterSpacing = 0.5.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Tabs below Title Box, Aligned to Left as real tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f))
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tab Frente
                Column(
                    modifier = Modifier
                        .clickable { activeTab = 0 }
                        .padding(top = 8.dp, bottom = 4.dp, start = 4.dp, end = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Frente",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (activeTab == 0) FontWeight.Bold else FontWeight.Normal,
                        color = if (activeTab == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(3.dp)
                            .width(36.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (activeTab == 0) MaterialTheme.colorScheme.primary else Color.Transparent)
                    )
                }

                // Tab Verso
                Column(
                    modifier = Modifier
                        .clickable { activeTab = 1 }
                        .padding(top = 8.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Verso",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (activeTab == 1) FontWeight.Bold else FontWeight.Normal,
                        color = if (activeTab == 1) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(3.dp)
                            .width(36.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (activeTab == 1) MaterialTheme.colorScheme.primary else Color.Transparent)
                    )
                }
            }

            // Body Content based on Tab
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                if (activeTab == 0) {
                    // FRENTE
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.2f))
                        ) {
                            Text(
                                text = universalCard.code,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Black,
                                color = Color.Black,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = universalCard.title.uppercase(),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFFC107),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )

                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Concluído",
                                tint = Color(0xFF2E7D32),
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = universalCard.questionOrSubtitle,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Badges: Time, XP
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = "Duração",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${universalCard.durationMinutes} min",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "XP",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${universalCard.xpPoints} XP",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    // Encaixes (Sockets) - Disposed below XP with "ENCAIXES" header
                    if (universalCard.sockets.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "ENCAIXES",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 9.sp,
                            letterSpacing = 0.5.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            universalCard.sockets.forEach { socketCode ->
                                val targetCard = QuestboxData.findUniversalCard(socketCode)
                                val socketColor = targetCard?.headerColor ?: Color.Gray

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(socketColor.copy(alpha = 0.15f))
                                        .border(1.dp, socketColor, RoundedCornerShape(6.dp))
                                        .clickable {
                                            if (onSocketClick != null) {
                                                onSocketClick(socketCode)
                                            } else {
                                                onClick(activeTab)
                                            }
                                        }
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = socketCode,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = socketColor,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                } else {
                    // VERSO
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = universalCard.backContent,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )

                        if (universalCard.backTip.isNotBlank()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "💡 DICA: ${universalCard.backTip}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }

                        // Related / Mentioned / Socket Cards - ALL CLICKABLE
                        val relatedCodes = remember(universalCard) {
                            (universalCard.sockets + extractMentionedCardCodes("${universalCard.backContent} ${universalCard.backTip}"))
                                .distinct()
                                .filter { it != universalCard.code }
                        }

                        if (relatedCodes.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "CARDS RELACIONADOS",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                fontSize = 9.sp,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                relatedCodes.forEach { cardCode ->
                                    val targetCard = QuestboxData.findUniversalCard(cardCode)
                                    val cardColor = targetCard?.headerColor ?: Color.Gray

                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(cardColor.copy(alpha = 0.15f))
                                            .border(1.dp, cardColor, RoundedCornerShape(6.dp))
                                            .clickable {
                                                if (onSocketClick != null) {
                                                    onSocketClick(cardCode)
                                                } else {
                                                    onClick(activeTab)
                                                }
                                            }
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = cardCode,
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = cardColor,
                                            fontSize = 10.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
