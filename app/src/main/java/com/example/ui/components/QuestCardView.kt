package com.example.ui.components

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
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Phase
import com.example.data.model.QuestboxData
import com.example.data.model.ToolCard
import com.example.data.model.UniversalCard

@Composable
fun QuestCardView(
    card: ToolCard,
    isCompleted: Boolean = false,
    onClick: () -> Unit,
    onSocketClick: ((ToolCard) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    UniversalCardView(
        universalCard = UniversalCard.Tool(card),
        isCompleted = isCompleted,
        onClick = { _ -> onClick() },
        onSocketClick = { socketCode ->
            val targetTool = QuestboxData.TOOL_CARDS.find { it.code == socketCode }
            if (targetTool != null && onSocketClick != null) {
                onSocketClick(targetTool)
            } else {
                onClick()
            }
        },
        modifier = modifier
    )
}
