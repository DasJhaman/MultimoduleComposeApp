pluginManagement {
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

rootProject.name = "CompposeMultimoduleApp"
include(":app")
include(":presentation")
include(":data")
include(":domain-layer")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")