package com.example.autocompletecomposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun AutoComplete(
    value: String,
    onValueChange: (String) -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
) {

    var filteredOpts by remember { mutableStateOf(options) }

    Column(
        modifier = modifier
            .width(IntrinsicSize.Min)
    ){
        TextField(
            value = value,
            label = label,
            onValueChange = {
                onValueChange(it)

                filteredOpts = options.filter { option ->
                    option.contains(it)
                }
            },
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(242, 237, 247))
        ) {
            filteredOpts.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onValueChange(option)

                        filteredOpts = emptyList()
                    }
                )
            }
        }
    }
}
