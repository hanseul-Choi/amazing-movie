package kr.chs.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCardResource(
    movieCardUiState: MovieCardUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier,
    ) {
        Column() {
            // Todo: 이미지 넣기 - Rounded 16, 총 크기 60%정도?
            // Todo: 관람 등급(이미지), 제목(10자이상 넘어가면 elipse처리), 출시일, 평점(별모양 + 점수), 아래 자세히 보기 버튼 - 롯데 시네마 앱 참고
            Text(text = "test")
        }
    }
}

// 여기서 Movie Content의 ui를 다루는게 맞아보임
sealed interface MovieCardUiState {
    object Loading: MovieCardUiState
    data class Success(
        val movie: Movie
    ): MovieCardUiState
}

@Preview
@Composable
fun MovieCardContentPreview(
    @PreviewParameter(SearchUiStatePreviewParameterProvider::class)
    movieData: BasePagingModel<Movie>,
) {
    MovieCardResource(
        movieCardUiState = MovieCardUiState.Success(
            movie = movieData.results[0]
        ),
        onClick = {},
    )
}