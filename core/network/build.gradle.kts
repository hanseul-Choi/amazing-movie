plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.hilt")
}

android {
    namespace = "kr.chs.core.network"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson.converter)
}