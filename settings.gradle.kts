pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Timers"

include(":app")
include(":feature:timers")
include(":feature:statistics")
include(":feature:settings")
include(":core")

project(":feature:timers").projectDir = file("feature/timers")
project(":feature:statistics").projectDir = file("feature/statistics")
project(":feature:settings").projectDir = file("feature/settings")