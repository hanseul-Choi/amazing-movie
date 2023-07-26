package kr.chs.core.network.retrofit

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.core.network.BuildConfig
import kr.chs.core.network.model.BasePagingNetworkModel
import kr.chs.core.network.model.NetworkMovie
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitAmazingMovieApi {
    @GET("3/search/movie")
    suspend fun getMovies(
        @Query("keyword") keyword: String
    ) : List<BasePagingNetworkModel<NetworkMovie>>
}

private const val amazingMovieBaseUrl = BuildConfig.MOVIE_BASE_URL

@Singleton
class RetrofitAmazingMovieNetwork @Inject constructor(
    okHttpCallFactory: Call.Factory,
    private val refreshIntervalMs: Long = 5000,
): AmazingMovieNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(amazingMovieBaseUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitAmazingMovieApi::class.java)

    override suspend fun getMovies(keyword: String): Flow<List<BasePagingNetworkModel<NetworkMovie>>> =
        flow {
            while(true) {
                val movieData = networkApi.getMovies(keyword)
                emit(movieData)
                delay(refreshIntervalMs)
            }
        }
}