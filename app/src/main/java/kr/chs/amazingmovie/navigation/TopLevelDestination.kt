package kr.chs.amazingmovie.navigation

import kr.chs.core.designsystem.icon.AppIcons
import kr.chs.core.designsystem.icon.IconWrapper
import kr.chs.core.designsystem.icon.IconWrapper.ImageVectorIcon
import kr.chs.feature.test1.navigation.test1NavigationRoute
import kr.chs.feature.test2.navigation.test2NavigationRoute
import kr.chs.feature.test1.R as Test1R
import kr.chs.feature.test2.R as Test2R

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: IconWrapper,
    val unselectedIcon: IconWrapper,
    val iconTextId: Int,
) {
    Test1(
        test1NavigationRoute,
        ImageVectorIcon(AppIcons.SearchFilled),
        ImageVectorIcon(AppIcons.Search),
        Test1R.string.test1_icon_text
    ),

    Test2(
        test2NavigationRoute,
        ImageVectorIcon(AppIcons.FavoriteFilled),
        ImageVectorIcon(AppIcons.Favorite),
        Test2R.string.test2_icon_text
    )
}