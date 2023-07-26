package kr.chs.core.data.repository

import kotlinx.coroutines.flow.Flow
import kr.chs.cpre.model.data.Movie
import kr.chs.cpre.model.data.base.BasePagingModel

interface SearchRepository {
    suspend fun geMovies(keyword: String): Flow<List<BasePagingModel<Movie>>>
}