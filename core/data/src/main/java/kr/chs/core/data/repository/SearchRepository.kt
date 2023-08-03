package kr.chs.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel

interface SearchRepository {
    val movieData: Flow<Movie>

    fun getMovies(keyword: String): Flow<List<BasePagingModel<Movie>>>
}