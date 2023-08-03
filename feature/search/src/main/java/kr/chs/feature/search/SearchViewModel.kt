package kr.chs.feature.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kr.chs.core.common.result.Result
import kr.chs.core.common.result.asResult
import kr.chs.core.data.repository.SearchRepository
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel
import javax.inject.Inject

/**
 *  검색어 입력할 때 마다 바로 랜더링으로 표현하는건 어떤가?
 *  일단 검색 버튼으로 진행?
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    // 초기 searchUiState는 empty 상태
    private val _searchUiState = MutableStateFlow<SearchUiState>(SearchUiState.Empty)
    val searchUiState: StateFlow<SearchUiState> = _searchUiState

    private fun searchMovieData(keyword: String) {
        _searchUiState.value = SearchUiState.Loading

        searchRepository.getMovies(keyword)
            .asResult()
            .map { searchResponse ->
                when(searchResponse) {
                    is Result.Success -> {
                        _searchUiState.value = if(searchResponse.data.isNullOrEmpty()) {
                            SearchUiState.Empty
                        } else {
                            SearchUiState.Success(movie = searchResponse.data)
                        }
                    }
                    is Result.Loading -> {
                        _searchUiState.value = SearchUiState.Loading
                    }
                    is Result.Error -> {
                        _searchUiState.value = SearchUiState.Error
                    }
                }
            }
    }
}

sealed interface SearchUiState {
    data class Success(val movie: List<BasePagingModel<Movie>>): SearchUiState
    object Error: SearchUiState
    object Loading: SearchUiState
    object Empty: SearchUiState
}