package kr.chs.feature.search

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel

class SearchUiStatePreviewParameterProvider : PreviewParameterProvider<SearchUiState> {
    override val values: Sequence<SearchUiState> = sequenceOf(
        SearchUiState.Success(
            BasePagingModel(
                page = 1,
                results = listOf(
                    Movie(
                        id = 1,
                        title = "test",
                        posterPath = "",
                    ),
                    Movie(
                        id = 2,
                        title = "test2",
                        posterPath = "",
                    ),
                    Movie(
                        id = 3,
                        title = "test3",
                        posterPath = "",
                    ),
                ),
                totalPages = 1,
                totalResults = 3,
            )
        )
    )
}