package kr.chs.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.chs.core.data.model.asMovie
import kr.chs.core.network.AmazingMovieNetworkDataSource
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val networkDataSource: AmazingMovieNetworkDataSource,
    override val movieData: Flow<Movie>
) : SearchRepository {

    // Repository에서는 data들이 한번에 모일 때, 알맞는 model로 변환해주는 역할 수행
    // UI data는 model 모듈에서 책임, 혹시나 model의 data의 변환이 필요할 때, domain layer에서 변환
    override fun getMovies(keyword: String): Flow<List<BasePagingModel<Movie>>> =
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