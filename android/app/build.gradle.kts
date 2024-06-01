import dependencies.Dependencies
import org.jetbrains.dokka.ReflectDsl.get
import java.io.ByteArrayOutputStream

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id("org.jetbrains.kotlin.android")
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_PARCELIZE)
}

android {
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
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
}

tasks.register("makeDeps") {
    description = "Build gomobile.aar (Berty go core)"

    outputs.files(fileTree(mapOf("dir" to "${rootDir}/libs", "include" to listOf("*.jar", "*.aar"))))

    doLast {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
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
                commandLine("make", "android.gomobile")
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
}
