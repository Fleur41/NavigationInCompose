package com.sam.navigationincompose.navigation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
//    navController: NavController,
    onDetailClick: (String) -> Unit
) {
    var text by remember { mutableStateOf("")}

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "HomeScreen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home screen")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = text,
                onValueChange = {text = it}
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onDetailClick(text) }) {
                Text(text = "Go to Detail screen")
            }
//            Button(onClick = {
//                navController.navigate(NavDestination.Detail.name)
//            }) {
//                Text(text = "Go to detail screen")
//            }
        }
    }
}

@Preview
@Composable
private fun HomeScreen() {
    HomeScreen(onDetailClick = {})
}
