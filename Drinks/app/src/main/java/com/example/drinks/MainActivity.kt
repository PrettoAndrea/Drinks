package com.example.drinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailapp.ui.theme.CocktailAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = CocktailRepository(RetrofitInstance.api)
        val factory = CocktailViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[CocktailViewModel::class.java]

        setContent {
            CocktailAppTheme {
                MainScreen(viewModel)
            }
        }
    }
}
