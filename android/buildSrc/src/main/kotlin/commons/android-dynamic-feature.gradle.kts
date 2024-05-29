package commons

import BuildAndroidConfig
import BuildModules
import BuildProductDimensions
import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.addTestsDependencies
import extensions.implementation

plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-allopen")
    id("androidx.navigation.safeargs.kotlin")
    id("com.vanniktech.dependency.graph.generator")
    id("org.jetbrains.kotlin.android")
}

allOpen {
    // allows mocking for classes w/o directly opening them for release builds
    annotation("com.nttdata.gc.core.annotations")
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
//        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        viewBinding = true
    }
    packagingOptions { resources.excludes.add("META-INF/*") }


    flavorDimensions += BuildProductDimensions.ENVIRONMENT

    productFlavors {
//        create("develop") {
//            dimension = BuildProductDimensions.ENVIRONMENT
////            versionNameSuffix  = "-dev"
//
//        }
//        create("qa") {
//            dimension = BuildProductDimensions.ENVIRONMENT
////            applicationIdSuffix  = ".qa"
////            versionNameSuffix = "-qa"
//        }
//        create("production") {
//            dimension = BuildProductDimensions.ENVIRONMENT
//        }
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    lint {
        lintConfig = rootProject.file(".lint/config.xml")
        checkAllWarnings = true
        warningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    api(project(BuildModules.APP))

    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.DAGGER)
    implementation(Dependencies.HILT)
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.LOGGING)
//    implementation(Dependencies.GUAVA)

    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER)

    kapt(AnnotationProcessorsDependencies.DAGGER)
    kapt(AnnotationProcessorsDependencies.DATABINDING)
    kapt(AnnotationProcessorsDependencies.ROOM)
    kapt(AnnotationProcessorsDependencies.LIFECYCLE)

    testImplementation(project(BuildModules.Libraries.TEST_UTILS))
    addTestsDependencies()
}
