package com.example.autocompletecomposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteExample() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("AutoCompleteExample") }) },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            val names = listOf("Tony Stark", "Steve Rogers", "Bruce Banner", "Natasha Romanoff")
            var name by remember { mutableStateOf("") }

            AutoComplete(
                label = { Text("Name") },
                options = names,
                value = name,
                onValueChange = { name = it },
            )
        }
    }
}
