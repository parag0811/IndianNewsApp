package parag.ui.newsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class NewsViewModel : ViewModel() {

    data class NewsState(
        val loading: Boolean = true,
        val error: String? = null,
        val listOfArticles: List<Article> = emptyList()
    )

    private val apiKey = "Enter you api key"

    private val _newsState = mutableStateOf(NewsState())
    val newsState: State<NewsState> = _newsState



    init {
        fetchNews("general")
    }

    fun fetchNews(category : String) {
        viewModelScope.launch {
            try {
                val response = newservice.getNewsHeadlines("in", category, apiKey)
                _newsState.value = NewsState(
                    loading = false,
                    error = null,
                    listOfArticles = response.articles
                )

            } catch (e: Exception) {
                _newsState.value = NewsState(
                    loading = false,
                    error = "Error Fetched ${e.message}"
                )
            }
        }
    }
}