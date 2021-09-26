plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins.create("dev.fasd.gradle.execCmd") {
        id = "dev.fasd.gradle.execCmd"
        implementationClass = "dev.fasd.gradleCmd.ExecPlugin"
    }
}