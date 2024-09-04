package com.example.lab5belenmonterroso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5belenmonterroso.ui.theme.Lab5BelenMonterrosoTheme

class VenuesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5BelenMonterrosoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VenuesListScreen(
                        venues = listOf(
                            Venue("Wos", "Fórum Majadas, Guatemala"),
                            Venue("Adele", "Ottawa, Canada"),
                            Venue("Los Ángeles Azules", "Puerto Rico")
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun VenuesListScreen(venues: List<Venue>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(16.dp)) {
        items(venues.size) { index ->
            VenueItem(venue = venues[index])

            if (index < venues.size - 1) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun VenueItem(venue: Venue) {
    ListItem(
        headlineContent = { Text(venue.title, style = MaterialTheme.typography.titleMedium) },
        supportingContent = { Text(venue.subtitle, style = MaterialTheme.typography.bodyMedium) },
        leadingContent = {
            Icon(Icons.Default.LocationOn, contentDescription = null)
        },
        trailingContent = {
            Icon(Icons.Default.ArrowForward, contentDescription = null)
        },
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun VenuesListPreview() {
    Lab5BelenMonterrosoTheme {
        VenuesListScreen(
            venues = listOf(
                Venue("Wos", "Fórum Majadas, Guatemala"),
                Venue("Adele", "Ottawa, Canada"),
                Venue("Los Ángeles Azules", "Puerto Rico")
            )
        )
    }
}


data class Venue(
    val title: String,
    val subtitle: String
)
