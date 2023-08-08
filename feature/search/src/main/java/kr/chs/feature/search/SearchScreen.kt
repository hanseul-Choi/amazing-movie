package kr.chs.feature.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.chs.core.designsystem.icon.AppIcons
import kr.chs.core.designsystem.theme.*
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
        searchQueryState = searchQueryState,
    )
}

@Composable
internal fun SearchScreen(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit = {},
    searchUiState: SearchUiState,
    searchQueryState: String = "",
) {
    val state = rememberLazyListState()

    Column(modifier = modifier) {
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Todo : SearchTopBar 구현 - toss 검색 부분 참고
        SearchTopBar(
            onSearchClick = onSearchClick,
        )

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

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun SearchTopBar(
    onSearchClick: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    // Search Trigger
    val onSearchExplicitlyTriggered = {
        onSearchClick(text)

        keyboardController?.hide()
        focusManager.clearFocus()
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .onKeyEvent {// 엔터키 감지
                    if(it.key == Key.Enter) {
                        onSearchExplicitlyTriggered()
                        true
                    } else {
                        false
                    }
                },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint_text),
                    color = GrayAB,
                )
            },
            leadingIcon = {
                IconButton(
                    onClick = {
                        onSearchExplicitlyTriggered()
                    },
                ) {
                    Icon(
                        imageVector = AppIcons.SearchBar,
                        contentDescription = stringResource(
                            id = R.string.search_hint_text
                        ),
                    )
                }
            },
            trailingIcon= {
                if(text.isNotEmpty()) {
                    IconButton(
                        onClick = { text = "" },
                    ) {
                        Icon(
                            imageVector = AppIcons.Clear,
                            contentDescription = stringResource(
                                id = R.string.clear_description_text
                            ),
                        )
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors( // Todo : Theme를 통해 Color 변경
                containerColor = GrayE9,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchExplicitlyTriggered()
                }
            ),
        )
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

@Preview(
    showBackground = true,
)
@Composable
private fun SearchScreenPreview(
    @PreviewParameter(SearchUiStatePreviewParameterProvider::class)
    searchUiState: SearchUiState,
) {
    AmazingMovieTheme {
        SearchScreen(searchUiState = searchUiState,)
    }
}