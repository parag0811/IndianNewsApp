package parag.ui.newsapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsApp(
    navController: NavHostController
) {
    val newsViewModel: NewsViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screens.NewsScreen.route) {
        composable(route = Screens.NewsScreen.route) {
            //What should be displayed
            NewsScreen(viewModel = newsViewModel) {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    "cat",
                    it
                ) //Storing the Article
                navController.navigate(Screens.ArticleDetailScreen.route) //We need that in here
            }
        }
        composable(route = Screens.ArticleDetailScreen.route){
            //Get the previousBackStack which is from the NewsScreen to get the data
            val article = navController.previousBackStackEntry?.savedStateHandle?.
            get<Article>("cat") ?: Article("","","","","", "", Source("",""))
            ArticleDetailScreen(newsArticle = article)
        }
    }
}