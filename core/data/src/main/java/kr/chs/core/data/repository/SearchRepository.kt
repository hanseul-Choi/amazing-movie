package kr.chs.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel

interface SearchRepository {
    fun getMovies(query: String): Flow<BasePagingModel<Movie>>
}