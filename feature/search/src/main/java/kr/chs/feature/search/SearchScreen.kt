package kr.chs.feature.search

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.chs.core.model.data.Movie

@Composable
internal fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel()
) {

    val searchUiState by viewModel.searchUiState.collectAsStateWithLifecycle()
    val searchQueryState by viewModel.searchQueryState.collectAsStateWithLifecycle()

    SearchScreen(
        onSearchClick = viewModel::onSearchQueryChanged,
        searchUiState = searchUiState,
        searchKeyword = searchQueryState,
    )
}

@Composable
internal fun SearchScreen(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit = {},
    searchUiState: SearchUiState,
    searchKeyword: String = "",
) {
    val state = rememberLazyListState()

    Column(modifier = modifier) {
        // Todo : SearchBar 구현
        Button(
            onClick = {onSearchClick("test")},
        ) {
            Text(text = "search button")
        }

        // Todo : 이 부분은 SearchResultBody로 표현 -> EmptySearchResultBody, SearchResultBody, SearchNotReadyBody
        LazyColumn(
            state = state,
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {// question: 이걸 넣는 이유?
                Spacer(
                    modifier = Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing)
                )
            }

            when(searchUiState) {
                SearchUiState.Empty -> {
                    Log.d("searchState", "searchState is Empty")
                }

                SearchUiState.Loading -> {
                    Log.d("searchState", "searchState is Loading")
                }

                is SearchUiState.Success -> { // question : 왜 is를 붙여야하지?
                    TestBody(
                        items = searchUiState.movie.results
                    )
                }

                SearchUiState.Error -> {
                    Log.d("searchState", "searchState is Error")
                }
            }

            item {
                Spacer(
                    modifier = Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing)
                )
            }
        }
    }
}

fun LazyListScope.TestBody(
    items: List<Movie>,
) = items(
    items = items,
    key = { it.id },
    itemContent = {movie ->
        Text(text = movie.title)
    },
)
