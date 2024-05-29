/**
 * Configuration of android build
 */
object BuildAndroidConfig {
    const val APPLICATION_ID = "com.nttdata.gc.sirvec"

    const val BUILD_TOOLS_VERSION = "30.0.3"
    const val COMPILE_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 23
    const val TARGET_SDK_VERSION = 33

    const val VERSION_CODE = 5
    const val VERSION_NAME = "2.0.0-beta"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    val TEST_INSTRUMENTATION_RUNNER_ARGUMENTS = mapOf(
        "leakcanary.FailTestOnLeakRunListener" to "listener"
    )
}
