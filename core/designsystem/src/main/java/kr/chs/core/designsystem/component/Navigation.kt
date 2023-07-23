package kr.chs.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kr.chs.core.designsystem.component.AmazingMovieNavigationDefaults.navigationBackgroundColor
import kr.chs.core.designsystem.icon.IconWrapper

@Composable
fun AmazingMovieNavigationBar(
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            thickness = 1.dp
        )

        NavigationBar(
            modifier = modifier,
            tonalElevation = 0.dp,
            containerColor = navigationBackgroundColor(),
            content = content,
        )
    }
}

@Composable
fun RowScope.AmazingMovieNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    unselectedIcon: IconWrapper,
    selectedIcon: IconWrapper = unselectedIcon,
    enabled: Boolean = true,
    @StringRes labelId: Int,
    alwaysShowLabel: Boolean = true,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            val icon = if(selected) {
                selectedIcon
            } else {
                unselectedIcon
            }

            when(icon) {
                is IconWrapper.ImageVectorIcon -> Icon(
                    imageVector = icon.imageVector,
                    contentDescription = "icon",
                )

                is IconWrapper.DrawableResourceIcon -> Icon(
                    painter = painterResource(id = icon.id),
                    contentDescription = "icon",
                )
            }
        },
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(
                text = stringResource(id = labelId)
            )
        },
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AmazingMovieNavigationDefaults.navigationSelectedIconColor(),
            unselectedIconColor = AmazingMovieNavigationDefaults.navigationContentColor(),
            selectedTextColor = AmazingMovieNavigationDefaults.navigationSelectedIconColor(),
            unselectedTextColor = AmazingMovieNavigationDefaults.navigationContentColor(),
            indicatorColor = AmazingMovieNavigationDefaults.navigationIndicatorColor()
        )
    )
}

object AmazingMovieNavigationDefaults {
    val navigationBackgroundColor = @Composable {
        MaterialTheme.colorScheme.surface
    }

    val navigationContentColor = @Composable {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    val navigationSelectedIconColor = @Composable {
        MaterialTheme.colorScheme.onPrimaryContainer
    }

    val navigationIndicatorColor = @Composable {
        MaterialTheme.colorScheme.primaryContainer
    }
}