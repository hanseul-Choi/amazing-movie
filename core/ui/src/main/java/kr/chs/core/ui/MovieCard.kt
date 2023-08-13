package kr.chs.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.chs.core.model.data.Movie
import kr.chs.core.model.data.base.BasePagingModel
import kr.chs.core.designsystem.R as DesignsystemR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCardResource(
    movie: Movie,
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
        Column {
            // Todo: 이미지 넣기 - Rounded 16, 총 크기 60%정도?
            Row {
                MovieResourceHeaderImage(movie.posterPath)
            }

            // Todo: 관람 등급(이미지), 제목(10자이상 넘어가면 elipse처리), 출시일, 평점(별모양 + 점수), 아래 자세히 보기 버튼 - 롯데 시네마 앱 참고
            Text(text = "test")
        }
    }
}

// Todo : UiState는 리스트로 표현되는 곳에서 관리하는게 맞아보임
//sealed interface MovieCardUiState {
//    object Loading: MovieCardUiState
//    data class Success(
//        val movie: Movie
//    ): MovieCardUiState
//}

@Composable
fun MovieResourceHeaderImage(
    headerImageUrl: String?,
) {
    // coil 사용
    AsyncImage(
        placeholder = painterResource(id = DesignsystemR.drawable.movie_default_img),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentScale = ContentScale.Crop,
        model = headerImageUrl,
        contentDescription = null
    )
}

@Preview
@Composable
fun MovieCardContentPreview(
    @PreviewParameter(SearchUiStatePreviewParameterProvider::class)
    movieData: BasePagingModel<Movie>,
) {
    MovieCardResource(
        movie = movieData.results[0],
        onClick = {},
    )
}