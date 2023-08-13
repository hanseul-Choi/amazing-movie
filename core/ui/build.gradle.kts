
plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.compose")
}

android {
    namespace = "kr.chs.core.ui"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)

    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.ui.tooling.preview)
}