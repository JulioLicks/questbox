package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.ui.MainViewModel
import com.example.ui.QuestboxAppScaffold
import com.example.ui.theme.QuestboxTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestboxTheme {
                QuestboxAppScaffold(
                    viewModel = mainViewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
