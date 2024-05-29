/**
 * Configuration of build modules
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val CAMBIO_CUSTODIA = ":features:cambiocustodia"
        const val DATOS_GENERALES = ":features:datosgenerales"
        const val ESCENARIOS = ":features:escenarios"
        const val EXPEDIENTES = ":features:expedientes"
        const val INDICIOS = ":features:indicios"
        const val LOGIN = ":features:login"
        const val ZONAS = ":features:zonas"
        const val HOME = ":features:home"
    }

    object Plugins {
        const val SINCRONIZACION = ":plugins:sincronizacion"
        const val EXPORT_DOCUMENT = ":plugins:exportar_documento"
    }

    object Commons {
        const val UI = ":commons:ui"
        const val VIEWS = ":commons:views"
        const val FORM = ":commons:form"
    }

    object Libraries {
        const val TEST_UTILS = ":libraries:test_utils"
        const val FABRIC_CLIENT = ":libraries:fabric-client"
        const val NFC = ":libraries:nfc"
        const val ROCKET_CORE = ":libraries:nttdata-rocket"
    }
}
