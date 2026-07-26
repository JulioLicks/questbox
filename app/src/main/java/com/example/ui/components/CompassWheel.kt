package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import com.example.data.model.Area
import com.example.data.model.CompassItem
import com.example.data.model.Phase
import com.example.data.model.QuestboxData
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CompassWheel(
    selectedItem: CompassItem?,
    onItemSelected: (CompassItem) -> Unit,
    onCardClick: (CompassItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var activeItem by remember(selectedItem) { mutableStateOf(selectedItem ?: CompassItem.AreaItem(Area.AR1)) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("compass_wheel_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header Title Bar for Bússola Card (Purple background, Code "BS")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF9C27B0))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "FERRAMENTA • BÚSSOLA",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        letterSpacing = 0.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Surface(
                        shape = CircleShape,
                        color = Color.White
                    ) {
                        Text(
                            text = "BS",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Black,
                            color = Color.Black,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BÚSSOLA DE NAVEGAÇÃO",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Toque nos elementos para explorá-los",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(16.dp))

            val heartPainter = rememberVectorPainter(Icons.Default.Favorite)
            val brainPainter = rememberVectorPainter(Icons.Default.Psychology)
            val boltPainter = rememberVectorPainter(Icons.Default.Bolt)
            val eyePainter = rememberVectorPainter(Icons.Default.Visibility)

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(280.dp)
                    .padding(8.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .size(260.dp)
                        .pointerInput(Unit) {
                            detectTapGestures { tapOffset ->
                                val center = Offset(size.width / 2f, size.height / 2f)
                                val x = tapOffset.x - center.x
                                val y = tapOffset.y - center.y
                                val dist = Math.sqrt((x * x + y * y).toDouble()).toFloat()
                                var touchAngle = Math.toDegrees(atan2(y.toDouble(), x.toDouble())).toFloat()
                                if (touchAngle < 0) touchAngle += 360f
                                
                                val radius = size.width / 2f
                                val whiteCircleRadius = radius * 0.45f
                                
                                val iconDist = radius * 0.65f
                                val eyeDist = (radius + whiteCircleRadius) / 2f
                                
                                var clickedPhaseIcon: Phase? = null
                                val phaseAngles = listOf(
                                    Phase.DIAGNOSTICO to -30f,
                                    Phase.PLANEJAMENTO to 90f,
                                    Phase.REALIZACAO to 210f
                                )
                                for ((p, a) in phaseAngles) {
                                    val icX = iconDist * cos(Math.toRadians(a.toDouble())).toFloat()
                                    val icY = iconDist * sin(Math.toRadians(a.toDouble())).toFloat()
                                    if (Math.sqrt(((x - icX)*(x - icX) + (y - icY)*(y - icY)).toDouble()) < (radius * 0.3f)) {
                                        clickedPhaseIcon = p
                                        break
                                    }
                                }
                                
                                var clickedEyeIcon: Phase? = null
                                val eyeAngles = listOf(
                                    Phase.DIAGNOSTICO to -90f,
                                    Phase.PLANEJAMENTO to 30f,
                                    Phase.REALIZACAO to 150f
                                )
                                for ((p, a) in eyeAngles) {
                                    val icX = eyeDist * cos(Math.toRadians(a.toDouble())).toFloat()
                                    val icY = eyeDist * sin(Math.toRadians(a.toDouble())).toFloat()
                                    if (Math.sqrt(((x - icX)*(x - icX) + (y - icY)*(y - icY)).toDouble()) < (radius * 0.3f)) {
                                        clickedEyeIcon = p
                                        break
                                    }
                                }

                                if (clickedEyeIcon != null) {
                                    activeItem = CompassItem.AttributeItem(clickedEyeIcon)
                                } else if (clickedPhaseIcon != null) {
                                    activeItem = CompassItem.PhaseItem(clickedPhaseIcon)
                                } else if (dist <= whiteCircleRadius) {
                                    val adjustedAngle = (touchAngle + 120f) % 360f
                                    val idx = (adjustedAngle / 60f).toInt()
                                    val areas = Area.values()
                                    if (idx in areas.indices) {
                                        activeItem = CompassItem.AreaItem(areas[idx])
                                    }
                                } else {
                                    val phase = when {
                                        touchAngle >= 30f && touchAngle < 150f -> Phase.PLANEJAMENTO
                                        touchAngle >= 150f && touchAngle < 270f -> Phase.REALIZACAO
                                        else -> Phase.DIAGNOSTICO
                                    }
                                    activeItem = CompassItem.PhaseItem(phase)
                                }
                                onItemSelected(activeItem)
                            }
                        }
                ) {
                    val center = Offset(size.width / 2, size.height / 2)
                    val radius = size.width / 2
                    val whiteCircleRadius = radius * 0.45f
                    val petalRadius = whiteCircleRadius * 0.75f

                    // 1. Draw 3 Phase Pie Slices
                    drawArc(
                        color = Phase.DIAGNOSTICO.color,
                        startAngle = -90f,
                        sweepAngle = 120f,
                        useCenter = true,
                        topLeft = Offset(0f, 0f),
                        size = Size(size.width, size.height)
                    )
                    drawArc(
                        color = Phase.PLANEJAMENTO.color,
                        startAngle = 30f,
                        sweepAngle = 120f,
                        useCenter = true,
                        topLeft = Offset(0f, 0f),
                        size = Size(size.width, size.height)
                    )
                    drawArc(
                        color = Phase.REALIZACAO.color,
                        startAngle = 150f,
                        sweepAngle = 120f,
                        useCenter = true,
                        topLeft = Offset(0f, 0f),
                        size = Size(size.width, size.height)
                    )

                    fun drawIconAt(painter: androidx.compose.ui.graphics.vector.VectorPainter, angleDeg: Float, dist: Float, iconSize: Float = 32f, filterColor: Color = Color.White) {
                        val angleRad = Math.toRadians(angleDeg.toDouble())
                        val x = center.x + (dist * cos(angleRad)).toFloat()
                        val y = center.y + (dist * sin(angleRad)).toFloat()
                        translate(left = x - iconSize/2, top = y - iconSize/2) {
                            with(painter) {
                                draw(Size(iconSize, iconSize), alpha = 1f, colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(filterColor))
                            }
                        }
                    }

                    // Phase Icons - Doubled in size (was 48f, now 80f)
                    val iconDist = radius * 0.65f
                    drawIconAt(heartPainter, -30f, iconDist, 80f)
                    drawIconAt(brainPainter, 90f, iconDist, 80f)
                    drawIconAt(boltPainter, 210f, iconDist, 80f)

                    // Eye icons on the borders
                    val eyeDist = (radius + whiteCircleRadius) / 2f
                    fun drawEyeBackground(angleDeg: Float) {
                        val angleRad = Math.toRadians(angleDeg.toDouble())
                        val x = center.x + (eyeDist * cos(angleRad)).toFloat()
                        val y = center.y + (eyeDist * sin(angleRad)).toFloat()
                        drawCircle(color = Color(0xFFFFD54F), radius = 32f, center = Offset(x, y))
                    }
                    drawEyeBackground(-90f)
                    drawEyeBackground(30f)
                    drawEyeBackground(150f)

                    drawIconAt(eyePainter, -90f, eyeDist, 48f, Color.Black)
                    drawIconAt(eyePainter, 30f, eyeDist, 48f, Color.Black)
                    drawIconAt(eyePainter, 150f, eyeDist, 48f, Color.Black)

                    // 2. Draw Center White Circle
                    drawCircle(
                        color = Color.White,
                        radius = whiteCircleRadius,
                        center = center
                    )

                    // 3. Draw 6 Petals
                    val areas = Area.values()
                    areas.forEachIndexed { idx, area ->
                        val angle = -90f + (idx * 60f) // North is Red (idx 0)
                        val isSelected = (activeItem is CompassItem.AreaItem && (activeItem as CompassItem.AreaItem).area == area)
                        
                        val color = area.color
                        val scale = if (isSelected) 1.15f else 1.0f

                        val path = Path()
                        val pRadius = petalRadius * scale
                        
                        translate(center.x, center.y) {
                            rotate(angle + 90f, pivot = Offset.Zero) { 
                                path.moveTo(0f, 0f)
                                path.quadraticTo(pRadius * 0.35f, -pRadius * 0.5f, 0f, -pRadius)
                                path.quadraticTo(-pRadius * 0.35f, -pRadius * 0.5f, 0f, 0f)
                                drawPath(path, color)
                            }
                        }
                    }
                    
                    // 4. Draw Center dots ("tarracha" preta e branca)
                    val activeAngle = when (activeItem) {
                        is CompassItem.AreaItem -> -90f + ((activeItem as CompassItem.AreaItem).area.ordinal * 60f)
                        is CompassItem.PhaseItem -> when ((activeItem as CompassItem.PhaseItem).phase) {
                            Phase.DIAGNOSTICO -> -30f
                            Phase.PLANEJAMENTO -> 90f
                            Phase.REALIZACAO -> 210f
                            else -> -90f
                        }
                        is CompassItem.AttributeItem -> when ((activeItem as CompassItem.AttributeItem).phase) {
                            Phase.DIAGNOSTICO -> -30f
                            Phase.PLANEJAMENTO -> 90f
                            Phase.REALIZACAO -> 210f
                            else -> -90f
                        }
                    }
                    
                    val tarrachaRadius = whiteCircleRadius * 0.15f
                    
                    // White Half (pointing towards active area)
                    drawArc(
                        color = Color.White,
                        startAngle = activeAngle - 90f,
                        sweepAngle = 180f,
                        useCenter = true,
                        topLeft = Offset(center.x - tarrachaRadius, center.y - tarrachaRadius),
                        size = Size(tarrachaRadius * 2, tarrachaRadius * 2)
                    )
                    // Black Half
                    drawArc(
                        color = Color.Black,
                        startAngle = activeAngle + 90f,
                        sweepAngle = 180f,
                        useCenter = true,
                        topLeft = Offset(center.x - tarrachaRadius, center.y - tarrachaRadius),
                        size = Size(tarrachaRadius * 2, tarrachaRadius * 2)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            val cardColor = when (activeItem) {
                is CompassItem.AreaItem -> (activeItem as CompassItem.AreaItem).area.color
                is CompassItem.PhaseItem -> (activeItem as CompassItem.PhaseItem).phase.color
                is CompassItem.AttributeItem -> (activeItem as CompassItem.AttributeItem).phase.color
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onCardClick(activeItem) },
                color = cardColor.copy(alpha = 0.15f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(cardColor)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        when (val item = activeItem) {
                            is CompassItem.AreaItem -> {
                                Text(
                                    text = "${item.area.code} • ${item.area.title}",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = cardColor
                                )
                                val role = QuestboxData.ROLES.find { it.areaCode == item.area.code }
                                if (role != null) {
                                    Text(
                                        text = "Papel: ${role.title} (${role.motto})",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                            is CompassItem.PhaseItem -> {
                                Text(
                                    text = "Fase: ${item.phase.title}",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = cardColor
                                )
                                Text(
                                    text = item.phase.subtitle,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            is CompassItem.AttributeItem -> {
                                Text(
                                    text = "Atributos Pessoais & Visão",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = cardColor
                                )
                                Text(
                                    text = item.phase.attributesText,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Abrir",
                        tint = cardColor
                    )
                }
            }
        }
    }
}
}
