// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.vanniktech.dependency.graph.generator.DependencyGraphGeneratorExtension

//plugins.apply(BuildPlugins.GIT_HOOKS)
plugins.apply(BuildPlugins.UPDATE_DEPENDENCIES)
plugins.apply(BuildPlugins.GRAPH_GENERATOR)

configure<DependencyGraphGeneratorExtension> {

//    repositories.applyDefault()
    plugins.apply(BuildPlugins.DETEKT)
    plugins.apply(BuildPlugins.DOKKA)
    plugins.apply(BuildPlugins.KTLINT)
    plugins.apply(BuildPlugins.SPOTLESS)
    plugins.apply(BuildPlugins.GRAPH_GENERATOR)

}
