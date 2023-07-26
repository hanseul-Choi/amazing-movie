package kr.chs.core.network

import kotlinx.coroutines.flow.Flow
import kr.chs.core.network.model.BasePagingNetworkModel
import kr.chs.core.network.model.NetworkMovie

interface AmazingMovieNetworkDataSource {
    suspend fun getMovies(keyword: String): Flow<List<BasePagingNetworkModel<NetworkMovie>>>
}