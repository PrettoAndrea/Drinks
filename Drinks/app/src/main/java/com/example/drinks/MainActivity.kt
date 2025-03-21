package com.example.drinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cocktailapp.ui.theme.CocktailAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza la repository con l'API di Retrofit
        val repository = CocktailRepositori(RetrofitInstance.api)

        setContent {
            CocktailAppTheme {
                // Ottieni il ViewModel tramite il factory (gestito da Compose)
                val cocktailViewModel: CocktailViewModel = viewModel(
                    factory = CocktailViewModelFactory(repository)
                )
                MainScreen(cocktailViewModel)
            }
        }
    }
}
