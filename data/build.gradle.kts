import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    kotlin("plugin.serialization").version("1.9.0")
}

android {
    val localProperties = gradleLocalProperties(rootDir)
    namespace = "de.multimodule.compposeapp.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    flavorDimensions.add("buildType")
    productFlavors {
        create("dev") {
            buildConfigField(
                "String",
                "API_BASE_URL",
                localProperties["API_BASE_URL_PROD"].toString()
            )
        }

        create("production") {
            buildConfigField(
                "String",
                "API_BASE_URL",
                localProperties["API_BASE_URL_PROD"].toString()
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(projects.domainLayer)
    testImplementation(libs.junit)
    testImplementation(libs.test.mock)
    testImplementation (libs.kotlin.mockito)
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.bundles.ktor.common)
    implementation(libs.ktor.http)

}