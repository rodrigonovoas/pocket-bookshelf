package com.rodrigonovoa.pocketbookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rodrigonovoa.ui.main.MainScreen
import com.rodrigonovoa.ui.theme.PocketBookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketBookshelfTheme {
                MainScreen()
            }
        }
    }
}