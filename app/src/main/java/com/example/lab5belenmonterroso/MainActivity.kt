package com.example.lab5belenmonterroso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.lab5belenmonterroso.ui.theme.Lab5BelenMonterrosoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5BelenMonterrosoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UpcomingConcertsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class Concert(
    val imageUrl: String,
    val title: String,
    val supportingText: String
)

@Composable
fun UpcomingConcertsScreen(modifier: Modifier = Modifier) {
    val concerts = listOf(
        Concert(
            imageUrl = "https://imagenes.extra.ec/files/image_full/uploads/2023/09/19/650a6b212c7ab.jpeg",
            title = "Concert Wos",
            supportingText = "Majadas Guatemala"
        ),
        Concert(
            imageUrl = "https://www.guatemala.com/fotos/2019/10/Concierto-de-Los-Tigres-del-Norte-en-Xela-885x500.jpg",
            title = "Concert Los Tigres del Norte",
            supportingText = "Guadalajara"
        ),
        Concert(
            imageUrl = "https://www.rockaxis.com/img/newsList/9435451.jpg",
            title = "Concert Arctic Monkeys",
            supportingText = "Inglaterra"
        ),
        Concert(
            imageUrl = "https://laagendacr.com/wp-content/uploads/2022/01/Captura-de-pantalla-2014-08-27-a-las-02.49.08.png",
            title = "Concert Los Ángeles Azules",
            supportingText = "Puerto Rico"
        ),
        Concert(
            imageUrl = "https://i.ytimg.com/vi/RSvj0-kNZ2g/maxresdefault.jpg",
            title = "Concert 21 Pilots",
            supportingText = "Cardales de Cayalá"
        ),
        Concert(
            imageUrl = "https://www.guatemala.com/fotos/2023/12/Tributo-a-Adele-en-la-Ciudad-de-Guatemala-Enero-2024-885x500.jpg",
            title = "Concert Adele",
            supportingText = "Canada"
        ),
        Concert(
            imageUrl = "https://monterreyrock.com/wp-content/uploads/2019/08/noah-pino-palo-2.jpg",
            title = "Concert Noah Pino Palo",
            supportingText = "México DF"
        ),
        Concert(
            imageUrl = "https://www.argentina.gob.ar/sites/default/files/trueno-show.jpeg",
            title = "Concert Trueno",
            supportingText = "Argentina"
        )
    )

    Column(modifier = modifier.fillMaxSize()) {
        // Title at the top of the screen
        Text(
            text = "Todo Eventos",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().padding(16.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(concerts.size) { index ->
                ConcertCard(concert = concerts[index])
            }
        }
    }
}

@Composable
fun ConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(concert.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = concert.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = concert.supportingText,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpcomingConcertsPreview() {
    Lab5BelenMonterrosoTheme {
        UpcomingConcertsScreen()
    }
}
