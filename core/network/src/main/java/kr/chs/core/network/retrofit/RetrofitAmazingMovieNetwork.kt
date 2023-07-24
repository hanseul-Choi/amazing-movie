package kr.chs.core.network.retrofit

import kr.chs.core.network.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

private interface RetrofitAmazingMovieApi {
    @GET("3/search/movie")
    suspend fun getMovies(
        @Query("keyword") keyword: String
    )
}

private const val amazingMovieBaseUrl = BuildConfig.MOVIE_BASE_URL

class RetrofitAmazingMovieNetwork {

}