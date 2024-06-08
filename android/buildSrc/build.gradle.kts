plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://plugins.gradle.org/m2/")
    maven("https://ci.android.com/builds/submitted/5837096/androidx_snapshot/latest/repository")
}

object BuildPluginsVersions {
    const val GRADLE_ANDROID = "8.1.0"
    const val GRADLE_VERSIONS = "0.33.0"
    const val KOTLIN = "1.8.0"
    const val NAVIGATION = "2.5.0-alpha01"
    const val DOKKA = "0.10.0"
    const val KTLINT = "0.39.0"
    const val SPOTLESS = "5.6.1"
    const val DETEKT = "1.14.1"
    const val GRAPH_GENERATOR = "0.6.0"
    const val DAGGER_HILT = "2.40"
    const val KSP = "1.8.21-1.0.11"
}


dependencies {
    implementation("com.google.dagger:hilt-android-gradle-plugin:${BuildPluginsVersions.DAGGER_HILT}")
    implementation("com.android.tools.build:gradle:${BuildPluginsVersions.GRADLE_ANDROID}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${BuildPluginsVersions.GRADLE_VERSIONS}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildPluginsVersions.KOTLIN}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.6.0")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${BuildPluginsVersions.NAVIGATION}")
    implementation("com.vanniktech:gradle-dependency-graph-generator-plugin:${BuildPluginsVersions.GRAPH_GENERATOR}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${BuildPluginsVersions.DOKKA}")
    implementation("com.pinterest:ktlint:${BuildPluginsVersions.KTLINT}")
    //implementation("com.diffplug.spotless:spotless-plugin-gradle:${BuildPluginsVersions.SPOTLESS}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${BuildPluginsVersions.DETEKT}")
    //implementation("com.google.devtools.ksp:${BuildPluginsVersions.KSP}")
}
