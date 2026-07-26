package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.background
import androidx.compose.ui.window.Dialog
import com.example.data.model.QuestboxData
import com.example.ui.MainViewModel

@Composable
fun ProfileSection(viewModel: MainViewModel) {
    val userProfile by viewModel.userProfile.collectAsState()
    var showEditProfileDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header Title Bar for Ficha Pessoal Card (Purple background, Code "FP")
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
                        text = "PERFIL • FICHA PESSOAL",
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
                            text = "FP",
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
                    text = "FICHA PESSOAL",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primary
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil",
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = userProfile?.name ?: "Explorador Questbox",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        val role = QuestboxData.ROLES.find { it.code == (userProfile?.roleCode ?: "P5") }
                        Text(
                            text = "Papel: ${role?.title ?: "Projetista"} (${userProfile?.roleCode ?: "P5"})",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Button(
                    onClick = { showEditProfileDialog = true },
                    modifier = Modifier.testTag("btn_edit_profile")
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar", modifier = Modifier.size(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // XP Level Bar
            val currentXp = userProfile?.totalXp ?: 0
            val currentLevel = userProfile?.level ?: 1
            val xpInCurrentLevel = currentXp % 100
            val levelProgress = xpInCurrentLevel / 100f

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "NÍVEL DE EXPERIÊNCIA $currentLevel",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "XP", tint = Color(0xFFFFB300), modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$currentXp XP Total",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { levelProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(CircleShape),
                color = Color(0xFFFFB300),
                trackColor = Color(0xFFFFB300).copy(alpha = 0.2f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "$xpInCurrentLevel / 100 XP para Nível ${currentLevel + 1}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 6 Personal Attributes Section
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "ATRIBUTOS PESSOAIS",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            val attrs = listOf(
                "Sentir" to (userProfile?.attrSentir ?: 3),
                "Pensar" to (userProfile?.attrPensar ?: 3),
                "Agir" to (userProfile?.attrAgir ?: 2),
                "Visão Interna" to (userProfile?.attrVisaoInterna ?: 3),
                "Visão Externa" to (userProfile?.attrVisaoExterna ?: 2),
                "Visão Integral" to (userProfile?.attrVisaoIntegral ?: 2)
            )

            attrs.forEach { (attrName, rating) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = attrName,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            repeat(5) { starIdx ->
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Star",
                                    tint = if (starIdx < rating) Color(0xFFFFB300) else Color.Gray.copy(alpha = 0.3f),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    // Edit Profile Dialog
    if (showEditProfileDialog) {
        var nameInput by remember { mutableStateOf(userProfile?.name ?: "") }
        var sentirVal by remember { mutableStateOf(userProfile?.attrSentir ?: 3) }
        var pensarVal by remember { mutableStateOf(userProfile?.attrPensar ?: 3) }
        var agirVal by remember { mutableStateOf(userProfile?.attrAgir ?: 2) }

        Dialog(onDismissRequest = { showEditProfileDialog = false }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Text(
                        text = "EDITAR FICHA PESSOAL (FP)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = nameInput,
                        onValueChange = { nameInput = it },
                        label = { Text("Seu Nome") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Nível de Atributo: Sentir ($sentirVal)",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Slider(
                        value = sentirVal.toFloat(),
                        onValueChange = { sentirVal = it.toInt() },
                        valueRange = 0f..4f,
                        steps = 3
                    )

                    Text(
                        text = "Nível de Atributo: Pensar ($pensarVal)",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Slider(
                        value = pensarVal.toFloat(),
                        onValueChange = { pensarVal = it.toInt() },
                        valueRange = 0f..4f,
                        steps = 3
                    )

                    Text(
                        text = "Nível de Atributo: Agir ($agirVal)",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Slider(
                        value = agirVal.toFloat(),
                        onValueChange = { agirVal = it.toInt() },
                        valueRange = 0f..4f,
                        steps = 3
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        OutlinedButton(onClick = { showEditProfileDialog = false }) {
                            Text("Cancelar")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                viewModel.updateUserProfileData(
                                    name = nameInput,
                                    roleCode = userProfile?.roleCode ?: "P5",
                                    areaCode = userProfile?.areaCode ?: "AR5",
                                    sentir = sentirVal,
                                    pensar = pensarVal,
                                    agir = agirVal,
                                    vInterna = userProfile?.attrVisaoInterna ?: 3,
                                    vExterna = userProfile?.attrVisaoExterna ?: 2,
                                    vIntegral = userProfile?.attrVisaoIntegral ?: 2
                                )
                                showEditProfileDialog = false
                            }
                        ) {
                            Text("Salvar")
                        }
                    }
                }
            }
        }
    }
}
}
