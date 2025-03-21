package com.example.drinks

class CocktailRepositori(private val api: CocktailApi) {
    suspend fun searchCocktails(query: String): List<Cocktail>? {
        val response = api.getCocktails(query)
        return response?.drinks
    }
}
