package kr.chs.core.data.model

import kr.chs.core.network.model.NetworkMovie
import kr.chs.cpre.model.data.Movie

fun NetworkMovie.asMovie() = Movie(
    id = id,
    title = title,
    posterPath = posterPath
)