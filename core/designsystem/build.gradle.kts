plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.compose")
}

android {
    namespace = "kr.chs.core.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material.iconsExtended)
}