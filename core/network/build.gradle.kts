plugins {
    id("amazingmovie.android.library")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.hilt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "kr.chs.core.network"

    buildFeatures {
        buildConfig = true
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.okhttp.logging)

    testImplementation(libs.junit4)
}