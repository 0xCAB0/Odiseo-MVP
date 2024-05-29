

package dependencies

/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object Dependencies {
    // NEXUS NTTDATA
    const val CORE_DATA="com.everis.android.core:data:${BuildDependenciesVersions.CORE_DATA}"
    const val CORE_DATA_COMMONS = "com.everis.android.core.data:commons:${BuildDependenciesVersions.CORE_DATA_COMMONS}"
    const val CORE_DATA_NETWORK = "com.everis.android.core.data:network:${BuildDependenciesVersions.CORE_DATA_NETWORK}"
    const val CORE_DATA_NETWORK_COMMONS = "com.everis.android.core.data.network:commons:${BuildDependenciesVersions.CORE_DATA_NETWORK_COMMONS}"
    const val CORE_DATA_NETWORK_TEST = "com.everis.android.core.data.network:test:${BuildDependenciesVersions.CORE_DATA_NETWORK_TEST}"
    const val CORE_DOMAIN = "com.everis.android.core:domain:${BuildDependenciesVersions.CORE_DOMAIN}"
    const val CORE_NAVIGATION = "com.everis.android.core:navigation:${BuildDependenciesVersions.CORE_NAVIGATION}"
    const val CORE_VIEWMODEL = "com.everis.android.core:viewmodel:${BuildDependenciesVersions.CORE_VIEWMODEL}"
    const val DNIEDROID = "es.dniedroidfnmt:dniedroid:${BuildDependenciesVersions.DNIEDROID}"
    const val FABRIC_SDK = "org.hyperledger.fabric:sdk:${BuildDependenciesVersions.FABRIC_SDK}"

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val RECYCLE_VIEW = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLE_VIEW}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FRAGMENT = "androidx.navigation:navigation-dynamic-features-fragment:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE_EXT}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT_KTX}"
    const val CONSTRAIN_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"
    const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${BuildDependenciesVersions.SWIPE_REFRESH_LAYOUT}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val HILT = "com.google.dagger:hilt-android:${BuildDependenciesVersions.DAGGER}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.RETROFIT}"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val MOSHI = "com.squareup.moshi:moshi:${BuildDependenciesVersions.MOSHI}"
    const val MOSHI_KTX = "com.squareup.moshi:moshi-kotlin:${BuildDependenciesVersions.MOSHI}"
    const val MOSHI_RETROFIT = "com.squareup.retrofit2:converter-moshi:${BuildDependenciesVersions.MOSHI_RETROFIT}"
    const val COIL = "io.coil-kt:coil:${BuildDependenciesVersions.COIL}"
    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"
    const val GUAVA = "com.google.guava:guava:${BuildDependenciesVersions.GUAVA}"
    const val ZXING = "com.google.zxing:core:${BuildDependenciesVersions.ZXING}"
    const val ZXING_ANDROID_EMBEDDED = "com.journeyapps:zxing-android-embedded:${BuildDependenciesVersions.ZXING_ANDROID_EMBEDDED}"
    const val GSON = "com.google.code.gson:gson:${BuildDependenciesVersions.GSON}"
    const val ARROW_CORE = "io.arrow-kt:arrow-core:${BuildDependenciesVersions.ARROW}"
    const val ARROW_COROUTINES = "io.arrow-kt:arrow-fx-coroutines:${BuildDependenciesVersions.ARROW}"
}
