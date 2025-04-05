package com.example.drinks

import CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {
    @GET("search.php")
    suspend fun getCocktails(@Query("s") query: String): CocktailResponse?
}
