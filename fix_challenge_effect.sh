sed -i -e '68a\
    LaunchedEffect(viewModel.activeAreaFilter) {\
        viewModel.activeAreaFilter?.let { filter ->\
            selectedAreaFilter = filter\
            viewModel.activeAreaFilter = null\
        }\
    }' /app/applet/app/src/main/java/com/example/ui/screens/ChallengesScreen.kt
