package kr.chs.core.network

import kr.chs.core.network.model.BasePagingModel
import kr.chs.core.network.model.Movie

interface AmazingMovieNetworkDataSource {
    suspend fun getMovies(keyword: String): List<BasePagingModel<Movie>>
}