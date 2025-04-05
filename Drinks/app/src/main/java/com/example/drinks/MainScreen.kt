package com.example.drinks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: CocktailViewModel) {
    val cocktails by viewModel.cocktails.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Cocktail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.searchCocktails(searchQuery) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            cocktails != null -> {
                if (cocktails!!.isEmpty()) {
                    Text(
                        "No cocktails found.",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                } else {
                    LazyColumn {
                        items(cocktails!!) { cocktail ->
                            CocktailItem(cocktail)
                        }
                    }
                }
            }
            else -> {
                Text(
                    "Please search for a cocktail.",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
