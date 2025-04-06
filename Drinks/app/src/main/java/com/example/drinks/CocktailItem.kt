package com.example.drinks

import Cocktail
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CocktailItem(cocktail: Cocktail){


    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Nome del cocktail
            Text(
                text = cocktail.strDrink ?: "Unknown Cocktail",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Immagine del cocktail
            cocktail.strDrinkThumb?.let { thumbUrl ->
                Image(
                    painter = rememberImagePainter(thumbUrl),
                    contentDescription = "Cocktail Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }


            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = cocktail.strInstructions ?: "No instructions")
            }
        }
    }
}
