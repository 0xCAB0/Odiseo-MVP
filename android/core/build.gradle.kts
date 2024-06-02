import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.kapt

plugins {
    id("commons.android-library")
}

android{
    namespace = "es.thalos.odiseo.mvp.core"
}

dependencies {

    dependencies {
        implementation(Dependencies.LIFECYCLE_EXTENSIONS)
        implementation(Dependencies.LIFECYCLE_VIEWMODEL)
        implementation(Dependencies.CONSTRAIN_LAYOUT)
        implementation(Dependencies.RECYCLE_VIEW)
        implementation(Dependencies.CORE_KTX)
        implementation(Dependencies.FRAGMENT_KTX)
        implementation(Dependencies.NAVIGATION_FRAGMENT)
        implementation(Dependencies.NAVIGATION_UI)
        implementation(Dependencies.PAGING)
        implementation(Dependencies.COIL)

        kapt(AnnotationProcessorsDependencies.DATABINDING)
    }
}
