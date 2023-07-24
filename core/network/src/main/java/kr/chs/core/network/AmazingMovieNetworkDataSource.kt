package kr.chs.core.network

import kr.chs.core.network.model.BasePagingNetworkModel
import kr.chs.core.network.model.NetworkMovie

interface AmazingMovieNetworkDataSource {
    suspend fun getMovies(keyword: String): List<BasePagingNetworkModel<NetworkMovie>>
}