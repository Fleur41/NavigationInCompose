package com.sam.navigationincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sam.navigationincompose.navigation.AppNavigation
import com.sam.navigationincompose.ui.theme.NavigationInComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NavigationInComposeTheme {
                AppNavigation()
            }
        }
    }
}

