dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "LearnCards"
include(":app")
include(":app:datasource")
apply(from = "features/modules.gradle.kts")
include(":navigation")
