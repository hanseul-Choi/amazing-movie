plugins {
    id("amazingmovie.android.application")
    id("amazingmovie.android.compose")
    id("amazingmovie.jetbrains.kotlin.android")
    id("amazingmovie.android.hilt")
}

android {
    namespace = "kr.chs.amazingmovie"

    defaultConfig {
        applicationId = "kr.chs.amazingmovie"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":feature:movielist"))
    implementation(project(":feature:search"))
    implementation(project(":feature:favorite"))

    implementation(libs.androidx.core.ktx)
//    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation(libs.androidx.lifecycle.ktx)
    implementation(libs.androidx.activity.compose)
//    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.compose.material3)
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2022.10.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
}