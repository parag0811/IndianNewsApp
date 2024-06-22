package parag.ui.newsapp

sealed class Screens (val route : String) {
    object NewsScreen:Screens("homescreen")
    object ArticleDetailScreen:Screens("detailscreen")
}