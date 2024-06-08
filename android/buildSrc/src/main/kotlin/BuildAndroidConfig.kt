/**
 * Configuration of android build
 */
object BuildAndroidConfig {
    const val APPLICATION_ID = "es.thalos.odiseo.mvp"

    const val BUILD_TOOLS_VERSION = "33.0.1"
    const val COMPILE_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 33

    const val VERSION_CODE = 1
    const val VERSION_NAME = "0.1.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    val TEST_INSTRUMENTATION_RUNNER_ARGUMENTS = mapOf(
        "leakcanary.FailTestOnLeakRunListener" to "listener"
    )
}
