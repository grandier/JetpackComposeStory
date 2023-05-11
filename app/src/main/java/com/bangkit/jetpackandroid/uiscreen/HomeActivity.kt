package com.bangkit.jetpackandroid.uiscreen

import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.bangkit.jetpackandroid.Artist
import com.squareup.picasso.Picasso
import com.bangkit.jetpackandroid.R

@Composable
fun HomeActivity(listArtist: List<Artist>, onArtistSelected: (Artist) -> Unit, navigateToAbout: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Kpop Artists")
                },
                actions = {
                    IconButton(onClick = navigateToAbout) {
                        Icon(Icons.Default.Person, contentDescription = "About Me")
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            items(listArtist) { artist ->
                ArtistListItem(artist = artist, onArtistSelected = onArtistSelected)
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArtistListItem(artist: Artist, onArtistSelected: (Artist) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.surface,
        onClick = { onArtistSelected(artist) } // Call the callback when the card is clicked
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val painter = rememberImagePainter(
                data = artist.photo,
                builder = {
                    placeholder(R.drawable.profile_pic)
                }
            )
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = artist.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = artist.listener, style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KpopArtistPreview() {
    val kpopArtists = listOf(
        Artist(
            1,
            "BTS",
            "306 million listeners",
            "https://upload.wikimedia.org/wikipedia/commons/f/ff/BTS_logo_%282017%29.png",
            "",
            ""
        ),
        Artist(
            2,
            "BLACKPINK",
            "113 million listeners",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Blackpink_-_EP.jpg/640px-Blackpink_-_EP.jpg",
            "",
            ""
        ),
    )

    HomeActivity(listArtist = kpopArtists, onArtistSelected = { artist ->
        // do something with the selected artist
    }) {
        // implement the navigateToAbout callback
    }

}



