package kr.chs.core.network.remote

import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.core.network.model.BasePagingModel
import kr.chs.core.network.model.Movie
import javax.inject.Inject

class AmazingMovieRemoteDataSource @Inject constructor(

) : AmazingMovieNetworkDataSource {
    override suspend fun getMovies(keyword: String): List<BasePagingModel<Movie>> {
        TODO("Not yet implemented")
    }
}