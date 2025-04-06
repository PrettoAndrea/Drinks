package com.example.drinks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
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
        // Campo di ricerca
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Cocktail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pulsante per la ricerca
        Button(
            onClick = { viewModel.searchCocktails(searchQuery) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when {
            isLoading -> {
                // Mostra il loader mentre si caricano i dati
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            cocktails.isNullOrEmpty() -> {
                // Mostra un messaggio se non ci sono cocktail o se la lista è vuota
                Text(
                    "No cocktails found.",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            else -> {
                // Mostra la lista di cocktail se ci sono dati
                LazyColumn {
                    // Assicurati che 'cocktails' non sia null
                    val nonNullCocktails = cocktails ?: emptyList() // Usa una lista vuota se cocktails è null
                    items(nonNullCocktails) { cocktail ->
                        CocktailItem(cocktail)
                    }
                }
            }
        }
    }
}
