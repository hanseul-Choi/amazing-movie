pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AmazingMovie"
include(":app")
include(":core:designsystem")
include(":feature:movielist")
include(":feature:search")
include(":feature:favorite")
include(":core:network")
