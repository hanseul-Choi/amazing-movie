package kr.chs.core.network

import kotlinx.coroutines.flow.Flow
import kr.chs.core.network.model.BasePagingNetworkModel
import kr.chs.core.network.model.NetworkMovie

interface AmazingMovieNetworkDataSource {
    fun getMovies(query: String): Flow<BasePagingNetworkModel<NetworkMovie>>
}