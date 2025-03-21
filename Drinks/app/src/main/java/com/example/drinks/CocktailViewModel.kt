package com.example.drinks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CocktailViewModel(private val repository: CocktailRepositori) : ViewModel() {

    private val _cocktails = MutableStateFlow<List<Cocktail>?>(null)
    val cocktails: StateFlow<List<Cocktail>?> = _cocktails

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun searchCocktails(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _cocktails.value = repository.searchCocktails(query)
            _isLoading.value = false
        }
    }
}
