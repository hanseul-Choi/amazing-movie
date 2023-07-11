plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.compose")
    id("amazingmovie.android.hilt")
}

// namespace가 없으면 Resource파일 인식 못함
android {
    namespace = "kr.chs.feature.favorite"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
}