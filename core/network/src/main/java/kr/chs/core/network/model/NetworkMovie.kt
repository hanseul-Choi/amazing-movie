package kr.chs.core.network.model

import com.google.gson.annotations.SerializedName

// question : NetworkMovie를 UI용 Model로 따로 뽑고 싶은데? - 여기서 확장함수로 코어의 model module로 변환시킨다면? -> module 간의 의존성이 발생..
// model의 변수 추가시 network의 확장함수도 변환시켜야함.. -> 한 module에서 변환하려면 model module에서 진행해야하는데 model에 network 의존성이 추가되어 좋지 못할 것 같음
// 그렇다면? data layer로 책임을 넘기고 model에서 변경 시 그 위의 data module에서도 변경 (=> nowinandroid 방법)
data class NetworkMovie(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String = " ",
    @SerializedName("genre_ids") val genreIds: List<Int> = listOf(),
    @SerializedName("id") val id: Int = 0,
    @SerializedName("original_language") val originalLanguage: String = "en",
    @SerializedName("original_title") val originalTitle: String = " ",
    @SerializedName("overview") val overview: String = " ",
    @SerializedName("popularity") val popularity: Double = 0.0,
    @SerializedName("poster_path") val posterPath: String? = " ",
    @SerializedName("release_data") val releaseDate: String = " ",
    @SerializedName("title") val title: String = " ",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("vote_count") val voteCount: Long = 0
)