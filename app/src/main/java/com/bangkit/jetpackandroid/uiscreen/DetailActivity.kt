package com.bangkit.jetpackandroid.uiscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.remember
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.bangkit.jetpackandroid.Artist
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bangkit.jetpackandroid.ID
import com.bangkit.jetpackandroid.listArtist

@Composable
fun DetailTopBar(artist: Artist?, navigateBack: () -> Unit) {
    TopAppBar(
        title = {
            artist?.name?.let {
                Text(text = it)
            }
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun DetailContent(artist: Artist?, navigateBack: () -> Unit) {
    artist?.let {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Image(
                    painter = rememberImagePainter(data = it.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.height(16.dp))
                it.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h4,
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Listener:",
                            style = MaterialTheme.typography.caption,
                        )
                        it.listener?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.body1,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Overview",
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(8.dp))
                it.overview?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Detail",
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(8.dp))
                it.detail?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Button(
                    onClick = { navigateBack() },
//                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Back")
                }
            }
        }
    }
}


@Composable
fun DetailActivity(id: Int, navigateBack: () -> Unit) {
    val artist = getArtistById(id, listArtist)
    Scaffold(
        topBar = { DetailTopBar(artist, navigateBack) }
    ) {
        DetailContent(artist, navigateBack)
    }
}

fun getArtistById(artistId: Int, artists: List<Artist>): Artist? {
    for (artist in artists) {
        if (artist.id == artistId) {
            return artist
        }
    }
    return null
}

@Preview
@Composable
fun DetailActivityPreview() {
    val artist = Artist(
        2,
        "BLACKPINK",
        "113 million listeners",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Blackpink_-_EP.jpg/640px-Blackpink_-_EP.jpg",
        "YG Entertainment\n" +
                "8 August 2016\n" +
                "K-pop, hip hop, EDM\n" +
                "Korean\n" +
                "Jisoo, Jennie, Rosé, Lisa\n",
        "BLACKPINK is a South Korean girl group that has gained global popularity and success since their debut in 2016. The group is composed of four members: Jisoo, Jennie, Rosé, and Lisa, and is managed by YG Entertainment. BLACKPINK is known for their powerful vocals, fierce performances, and stylish image.\n" +
                "\n" + "Since their debut, BLACKPINK has released multiple hit singles and albums, including \"DDU-DU DDU-DU\", \"Kill This Love\", and \"Lovesick Girls\", and has collaborated with numerous artists and brands. The group has also won several awards and nominations for their music and performances, including a Guinness World Record for the most viewed music video on YouTube within 24 hours with \"How You Like That\".\n" +
                "\n" + "BLACKPINK has a massive following of fans known as the BLINKs, who have helped the group become one of the most popular and influential girl groups in the world. The group has also been recognized for their fashion and beauty, with members serving as brand ambassadors for various companies and launching their own collaborations and products.\n"
    )
}



