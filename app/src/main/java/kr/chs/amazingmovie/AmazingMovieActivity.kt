package kr.chs.amazingmovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kr.chs.amazingmovie.ui.AmazingMovieApp
import kr.chs.core.designsystem.theme.AmazingMovieTheme

class AmazingMovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmazingMovieTheme {
                // A surface container using the 'background' color from the theme
                AmazingMovieApp()
            }
        }
    }
}