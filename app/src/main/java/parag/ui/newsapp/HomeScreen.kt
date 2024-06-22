package parag.ui.newsapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import parag.ui.newsapp.ui.theme.GrayBG
import parag.ui.newsapp.ui.theme.dmsansFontFamily
import parag.ui.newsapp.ui.theme.kanitFontFamily
import parag.ui.newsapp.ui.theme.opensansFontFamily
import parag.ui.newsapp.ui.theme.poppinsFontFamily
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = viewModel(),
    navigateToDetail: (Article) -> Unit
) {

    val newsState by viewModel.newsState // Observe newsState from viewModel

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            newsState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            newsState.error != null -> {
                Text(
                    text = newsState.error!!,
                    color = Color.Red,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                //Display News Articles
                HomeScreen(navigateToDetail)
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navigateToDetail: (Article) -> Unit
) {
    var current = LocalDate.now()
    var currentDay = current.dayOfWeek.name.lowercase().capitalize()

    val viewModel: NewsViewModel = viewModel()

    val textItems = listOf(
        "General",
        "Business",
        "Sports",
        "Technology",
        "Science",
        "Entertainment"
    )

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.doticon),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = "Trend Watch",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(top = 3.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.news_earth),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
        Text(
            text = "$currentDay $current",
            fontSize = 10.sp,
            fontFamily = kanitFontFamily,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Exclusive Scoop,",
            fontSize = 24.sp,
            fontFamily = opensansFontFamily,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Wow",
            fontSize = 24.sp,
            fontFamily = opensansFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(8.dp))
        LazyRow(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(GrayBG)
        ) {
            items(textItems) { text ->
                Text(text = text,
                    fontFamily = kanitFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable {
                            viewModel.fetchNews(text.lowercase())
                        })
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Just for you",
            fontSize = 18.sp,
            fontFamily = opensansFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        LazyColumn {
            items(viewModel.newsState.value.listOfArticles) { article ->
                EachItemOfArticle(newsarticle = article, navigateToDetail)
                Divider(modifier = Modifier.padding(12.dp))
            }
        }
    }
}

@Composable
fun EachItemOfArticle(
    newsarticle: Article,
    navigateToDetail: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigateToDetail(newsarticle) }
    ) {
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = newsarticle.title.toString(),
                    fontFamily = opensansFontFamily,
                    fontSize = 16.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row {
                    Text(
                        text = newsarticle.source?.name.toString(),
                        fontFamily = dmsansFontFamily,
                        color = Color.DarkGray,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = newsarticle.publishedAt.toString(),
                        fontFamily = dmsansFontFamily,
                        color = Color.DarkGray,
                        fontSize = 8.sp
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Card(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
            )
            {
                if (newsarticle.urlToImage == null) {
                    Image(
                        painter = painterResource(id = R.drawable.news_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = rememberAsyncImagePainter(newsarticle.urlToImage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }
}


