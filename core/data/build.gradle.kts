plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.hilt")
}

android {
    namespace = "kr.chs.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
}