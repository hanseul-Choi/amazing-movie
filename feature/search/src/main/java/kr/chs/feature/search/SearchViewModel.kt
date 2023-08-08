package kr.chs.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
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

    /**
     *  SharedFlow vs StateFlow
     *
     *  StateFlow : 항상 현재 값을 가짐, 반드시 초기 값을 가져야 한다. 이전 값이 동일하다면 동작하지 않는다.
     *  SharedFlow : replay 기능 탑재, 초기 값을 설정할 필요가 없다. 여러 값을 재시작할 수 있다.
     *
     *  SharedFlow buffer 개념 숙지
     */
    // 검색했을 때, 값이 변화해도 다시 호출 시키기 위해 SharedFlow로 먼저 생성 -> 이후, Screen에서 감지하기 위해 StateFlow로 변경함
    private val searchQuery = MutableSharedFlow<String>(replay = 1)
    init {
        searchQuery.tryEmit(DEFAULT_SEARCH_KEYWORD)
    }

    val searchQueryState: StateFlow<String> =
        searchQuery
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = DEFAULT_SEARCH_KEYWORD
            )

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchUiState: StateFlow<SearchUiState> = searchQuery.flatMapLatest { query ->
        searchRepository.getMovies(query)
            .asResult()
            .map { result ->
                when (result) {
                    is Result.Success -> {
                        if (result.data.results.isEmpty()) {
                            SearchUiState.Empty
                        } else {
                            SearchUiState.Success(result.data)
                        }
                    }
                    is Result.Error -> {
                        SearchUiState.Error
                    }
                    Result.Loading -> {
                        SearchUiState.Loading
                    }
                }
            }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SearchUiState.Empty
    )

    fun onSearchQueryChanged(query: String) {
        viewModelScope.launch {
            searchQuery.emit(query)
        }
    }
}

private const val DEFAULT_SEARCH_KEYWORD = ""

sealed interface SearchUiState {
    data class Success(val movie: BasePagingModel<Movie>): SearchUiState
    object Error: SearchUiState
    object Loading: SearchUiState
    object Empty: SearchUiState
}