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

include(":navigation")
include(":ui")
include(":appScopes")

apply(from = "features/modules.gradle.kts")
