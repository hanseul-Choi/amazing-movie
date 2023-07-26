package kr.chs.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.chs.core.data.model.asMovie
import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.cpre.model.data.Movie
import kr.chs.cpre.model.data.base.BasePagingModel
import javax.inject.Inject

class NetworkSearchRepository @Inject constructor(
    private val networkDataSource: AmazingMovieNetworkDataSource
) : SearchRepository {

    override suspend fun geMovies(keyword: String): Flow<List<BasePagingModel<Movie>>> =
        networkDataSource.getMovies(keyword).map { flowData ->
            flowData.map { basePagingData ->
                BasePagingModel(
                    page = basePagingData.page,
                    results = basePagingData.results.map { it.asMovie() },
                    totalPages = basePagingData.totalPages,
                    totalResults = basePagingData.totalResults
                )
            }
        }
}