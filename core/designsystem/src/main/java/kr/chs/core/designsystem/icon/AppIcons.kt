package kr.chs.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

object AppIcons {
    val Favorite = Icons.Outlined.FavoriteBorder
    val FavoriteFilled = Icons.Outlined.Favorite
    val Search = Icons.Outlined.Search
    val SearchFilled = Icons.Rounded.Search
    val List = Icons.Outlined.List
    val ListFilled = Icons.Rounded.List

}

sealed class IconWrapper {
    data class ImageVectorIcon(val imageVector: ImageVector): IconWrapper()
    data class DrawableResourceIcon(@DrawableRes val id: Int): IconWrapper()
}