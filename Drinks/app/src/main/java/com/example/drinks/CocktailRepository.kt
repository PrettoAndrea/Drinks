package com.example.drinks

import Cocktail

class CocktailRepository(private val api: CocktailApi) {
    suspend fun searchCocktails(query: String): List<Cocktail>? {
        val response = api.getCocktails(query)
        return response?.drinks
    }
}
