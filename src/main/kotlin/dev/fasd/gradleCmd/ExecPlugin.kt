package dev.fasd.gradleCmd

import org.gradle.api.Plugin
import org.gradle.api.Project

//Important - necessary use includeBuild("gradleCmd")
class ExecPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        //Use for only import functional from ExecCmd.kt
    }
}