package kr.chs.feature.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.chs.core.data.repository.SearchRepository
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    searchRepository: SearchRepository
) : ViewModel() {

}

sealed interface SearchUIiState {
    data class Success(val movie: List<BasePagingModel<Movie>>): SearchUIiState
    object Error: SearchUIiState
    object Loading: SearchUIiState
}