package com.example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.ui.screens.ChallengesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ProfileAndGuideScreen
import com.example.ui.screens.ProjectDetailScreen
import com.example.ui.screens.ProjectsScreen
import com.example.ui.screens.ToolCardsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestboxAppScaffold(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val currentScreen by viewModel.currentScreen.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = currentScreen.title,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .testTag("questbox_bottom_navigation"),
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = currentScreen == Screen.Board,
                    onClick = { viewModel.navigateTo(Screen.Board) },
                    icon = { Icon(Icons.Default.Dashboard, contentDescription = "Área de Trabalho") },
                    label = {
                        Text(
                            text = "Área de Trabalho",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp, fontWeight = FontWeight.Medium),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    },
                    alwaysShowLabel = true,
                    modifier = Modifier.testTag("nav_board"),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary
                    )
                )

                NavigationBarItem(
                    selected = currentScreen == Screen.Challenges,
                    onClick = { viewModel.navigateTo(Screen.Challenges) },
                    icon = { Icon(Icons.Default.Flag, contentDescription = "Desafios") },
                    label = {
                        Text(
                            text = "Desafios",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp, fontWeight = FontWeight.Medium),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    },
                    alwaysShowLabel = true,
                    modifier = Modifier.testTag("nav_challenges"),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary
                    )
                )

                NavigationBarItem(
                    selected = currentScreen == Screen.ToolCards,
                    onClick = { viewModel.navigateTo(Screen.ToolCards) },
                    icon = { Icon(Icons.Default.GridOn, contentDescription = "Ferramentas") },
                    label = {
                        Text(
                            text = "Ferramentas",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp, fontWeight = FontWeight.Medium),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    },
                    alwaysShowLabel = true,
                    modifier = Modifier.testTag("nav_tool_cards"),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary
                    )
                )

                NavigationBarItem(
                    selected = currentScreen == Screen.Projects || currentScreen == Screen.ProjectDetail,
                    onClick = { viewModel.navigateTo(Screen.Projects) },
                    icon = { Icon(Icons.Default.Folder, contentDescription = "Projetos") },
                    label = {
                        Text(
                            text = "Projetos",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp, fontWeight = FontWeight.Medium),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    },
                    alwaysShowLabel = true,
                    modifier = Modifier.testTag("nav_projects"),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary
                    )
                )

                NavigationBarItem(
                    selected = currentScreen == Screen.ProfileAndGuide,
                    onClick = { viewModel.navigateTo(Screen.ProfileAndGuide) },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Ajuda") },
                    label = {
                        Text(
                            text = "Ajuda",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp, fontWeight = FontWeight.Medium),
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    },
                    alwaysShowLabel = true,
                    modifier = Modifier.testTag("nav_profile"),
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                is Screen.Board -> HomeScreen(viewModel = viewModel)
                is Screen.Challenges -> ChallengesScreen(viewModel = viewModel)
                is Screen.ToolCards -> ToolCardsScreen(viewModel = viewModel)
                is Screen.Projects -> ProjectsScreen(viewModel = viewModel)
                is Screen.ProjectDetail -> ProjectDetailScreen(viewModel = viewModel)
                is Screen.ProfileAndGuide -> ProfileAndGuideScreen(viewModel = viewModel)
            }
        }
    }
}
