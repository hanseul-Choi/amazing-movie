plugins {
    `kotlin-dsl`
}

group = "kr.chs.amazingmovie.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "amazingmovie.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidKotlin") {
            id = "amazingmovie.jetbrains.kotlin.android"
            implementationClass = "AndroidKotlinConventionPlugin"
        }

        register("androidLibrary") {
            id = "amazingmovie.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidCompose") {
            id = "amazingmovie.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
    }
}