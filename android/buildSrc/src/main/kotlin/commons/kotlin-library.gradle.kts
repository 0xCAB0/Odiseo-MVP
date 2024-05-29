

package commons

import BuildAndroidConfig
import BuildProductDimensions
import dependencies.Dependencies
import extensions.implementation

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs +="-Xjvm-default=all"
    }

    buildFeatures {
        //dataBinding = true
        viewBinding = true
    }

    flavorDimensions += BuildProductDimensions.ENVIRONMENT
    productFlavors {
//        create("develop") {
//            versionNameSuffix   = "-dev"
//            dimension = BuildProductDimensions.ENVIRONMENT
//        }
//        create("qa") {
//            applicationIdSuffix = ".qa"
//            versionNameSuffix  = "-qa"
//            dimension = BuildProductDimensions.ENVIRONMENT
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
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.CORE_KTX)
}
