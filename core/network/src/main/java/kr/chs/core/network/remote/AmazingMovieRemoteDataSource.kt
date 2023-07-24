package kr.chs.core.network.remote

import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.core.network.model.BasePagingNetworkModel
import kr.chs.core.network.model.NetworkMovie
import javax.inject.Inject

class AmazingMovieRemoteDataSource @Inject constructor(

) : AmazingMovieNetworkDataSource {
    override suspend fun getMovies(keyword: String): List<BasePagingNetworkModel<NetworkMovie>> {
        TODO("Not yet implemented")
    }
}