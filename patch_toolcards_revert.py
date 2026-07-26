import re

with open("/app/applet/app/src/main/java/com/example/ui/screens/ToolCardsScreen.kt", "r") as f:
    content = f.read()

# Remove HelpCardView
content = re.sub(r'@Composable\nfun HelpCardView.*?}\n}\n', '', content, flags=re.DOTALL)

# Remove Tab 4
tab_to_replace = """            Tab(
                selected = selectedTabIdx == 4,
                onClick = { selectedTabIdx = 4 },
                text = { Text("Ajuda (18)") }
            )"""
content = content.replace(tab_to_replace, "")

# Remove grid condition
grid_to_replace = """        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            if (selectedTabIdx == 4) {
                items(QuestboxData.HELP_CARDS) { helpCard ->
                    HelpCardView(helpCard = helpCard)
                }
            } else {
                items(filteredCards) { card ->
                    QuestCardView(
                        card = card,
                        onClick = { selectedCardForViewing = card }
                    )
                }
            }
        }"""
        
old_grid = """        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredCards) { card ->
                QuestCardView(
                    card = card,
                    onClick = { selectedCardForViewing = card }
                )
            }
        }"""
content = content.replace(grid_to_replace, old_grid)

with open("/app/applet/app/src/main/java/com/example/ui/screens/ToolCardsScreen.kt", "w") as f:
    f.write(content)
