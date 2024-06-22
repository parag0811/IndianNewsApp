package parag.ui.newsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Source(
    val id: String? = null,
    val name: String? = null,
) : Parcelable

@Parcelize
data class Article(
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val urlToImage: String? = null,
    val content: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null //As list of article has another list named source to we need to have a parameter inside it
) : Parcelable

data class articleRespone(val articles: List<Article>)
