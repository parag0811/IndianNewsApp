package parag.ui.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface{
    @GET("top-headlines")
    suspend fun getNewsHeadlines(
        @Query("country") country: String ,
        @Query("category") category: String ,
        @Query("apiKey") apiKey: String
    ): articleRespone
}

private val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    var newservice = retrofit.create(APIinterface::class.java)
