import org.gradle.api.InvalidUserDataException
import java.io.File
import java.util.Properties

interface BuildType {
    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val isRelease: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isRelease: Boolean = false
    override val isTestCoverageEnabled = true
    var applicationIdSuffix = ".debug"
    var versionNameSuffix = "-DEBUG"
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
    override val isTestCoverageEnabled = false
    override val isRelease: Boolean = true
}

fun getLocalProperty(key: String): String {
    val properties = Properties()
    val rootDir = System.getProperty("user.dir")
    val propertiesFile = File(rootDir, "local.properties")
    if(!propertiesFile.exists())
        throw InvalidUserDataException("Please create a `local.properties` file in the root directory")
    properties.load(propertiesFile.inputStream())
    return properties.getProperty(key)?: throw InvalidUserDataException("Could not find key '$key' in local.properties file")
}
