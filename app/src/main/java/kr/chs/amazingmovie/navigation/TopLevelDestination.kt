package kr.chs.amazingmovie.navigation

import kr.chs.core.designsystem.icon.AppIcons
import kr.chs.core.designsystem.icon.IconWrapper
import kr.chs.core.designsystem.icon.IconWrapper.ImageVectorIcon
import kr.chs.feature.favorite.navigation.favoriteNavigationRoute
import kr.chs.feature.movielist.navigation.movieListNavigationRoute
import kr.chs.feature.search.navigation.searchNavigationRoute
import kr.chs.feature.search.R as SearchR
import kr.chs.feature.movielist.R as MovieListR
import kr.chs.feature.favorite.R as FavoriteR

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: IconWrapper,
    val unselectedIcon: IconWrapper,
    val iconTextId: Int,
) {
    Search(
      searchNavigationRoute,
      ImageVectorIcon(AppIcons.SearchFilled),
      ImageVectorIcon(AppIcons.Search),
      SearchR.string.search_icon_text
    ),

    MovieList(
        movieListNavigationRoute,
        ImageVectorIcon(AppIcons.List),
        ImageVectorIcon(AppIcons.ListFilled),
        MovieListR.string.movie_list_icon_text
    ),

    Favorite(
        favoriteNavigationRoute,
        ImageVectorIcon(AppIcons.FavoriteFilled),
        ImageVectorIcon(AppIcons.Favorite),
        FavoriteR.string.favorite_icon_text
    )
}