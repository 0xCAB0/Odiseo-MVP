import dependencies.Dependencies
import extensions.addTestsDependencies

import org.jetbrains.dokka.ReflectDsl.get
import java.io.ByteArrayOutputStream
import java.util.Locale

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id("org.jetbrains.kotlin.android")
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    namespace = "es.thalos.odiseo.mvp"
    compileSdk = (BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = (BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdk = (BuildAndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion = (BuildAndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments.putAll(BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS)
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }

        getByName(BuildType.DEBUG) {
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
        }
    }

    lint {
        baseline = file("lint-baseline.xml")
    }


    flavorDimensions += (BuildProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorDevelop.appCreate(this)
        ProductFlavorQA.appCreate(this)
        ProductFlavorProduction.appCreate(this)
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
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

    packagingOptions {
        exclude("META-INF/**")
    }

}

tasks.register("makeDeps") {
    description = "Build gomobile.aar (Berty go core)"

    outputs.files(fileTree(mapOf("dir" to "${rootDir}/libs", "include" to listOf("*.jar", "*.aar"))))

    doLast {
        if (System.getProperty("os.name").lowercase(Locale.getDefault()).contains("windows")) {
            logger.warn("Warning: can't run make on Windows, you must build gomobile.aar manually")
            return@doLast
        }

        val checkMakeInPath = exec {
            standardOutput = ByteArrayOutputStream() // equivalent to '> /dev/null'
            isIgnoreExitValue = true
            commandLine("bash", "-l", "-c", "command -v make")
        }

        if (checkMakeInPath.exitValue == 0) {
            exec {
                val makefileDir = "$rootDir"
                logger.info(makefileDir)
                workingDir = file(makefileDir)
                environment("PWD", makefileDir)
                commandLine("cd", "..")
                commandLine("make", "asdf.install_tools")
                commandLine("cd", "android")
                try{
                commandLine("make", "android.gomobile")}
                catch (e: Exception){
                    logger.warn(e.toString())
                }
            }
        } else {
            logger.warn("Warning: make command not found in PATH")
        }
    }
}


dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation(tasks.named("makeDeps").map { it.outputs.files })

    implementation(project(BuildModules.CORE))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)

    addTestsDependencies()
}

kapt {
    correctErrorTypes = true
}

