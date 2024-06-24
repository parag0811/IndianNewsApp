package parag.ui.newsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import parag.ui.newsapp.ui.theme.dmsansFontFamily
import parag.ui.newsapp.ui.theme.opensansFontFamily

@Composable
fun ArticleDetailScreen(
    newsArticle: Article
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO NAVIGATE*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO navigation*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.notibell),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = newsArticle.title.toString(),
            fontFamily = opensansFontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 4
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Row {
            if (newsArticle.source?.name == null){
                Text(
                    text = "Trend News",
                    fontFamily = dmsansFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }else {
                Text(
                    text = newsArticle.source?.name.toString(),
                    fontFamily = dmsansFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            if(newsArticle.publishedAt == null){
                Text(
                    text = "Unknown date",
                    fontFamily = dmsansFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }else {
                Text(
                    text = newsArticle.publishedAt.toString(),
                    fontFamily = dmsansFontFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        if (newsArticle.urlToImage == null){
            Text(
                text = "There is currently no image description available.",
                fontFamily = opensansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = newsArticle.urlToImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(2f)
                )
            }
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.news_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            if (newsArticle.author == null){
                Text(
                    text = "Trend News",
                    fontFamily = dmsansFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }else {
                Text(
                    text = newsArticle.author.toString(),
                    fontFamily = dmsansFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        if (newsArticle.content == null){
            Text(
                text = "We regret to inform you that our system currently does not have any information available about the latest news via our API. This could be due to a temporary issue with our data providers or an update cycle delay.\n" +
                        "\n" +
                        "However, you can always stay updated with the latest news and developments by visiting official news websites and trusted sources. We highly recommend checking out Google News, where you can find comprehensive and up-to-date information from various reliable news outlets. Google News curates news stories from around the world, ensuring you have access to a wide range of perspectives and the most recent updates.\n" +
                        "\n" +
                        "You can visit Google News here: Google News.\n" +
                        "\n" +
                        "We apologize for any inconvenience this may have caused and appreciate your understanding. Thank you for your patience, and please feel free to reach out if you have any further questions or require additional assistance.\n" +
                        "\n",
                fontFamily = dmsansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }else {
            Text(
                text = newsArticle.content.toString(),
                fontFamily = dmsansFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "For full context go to official page of ${newsArticle.source?.name.toString()}",
            fontFamily = dmsansFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
    }
}