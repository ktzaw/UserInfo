// Top-level build file where you can add configuration options common to all sub-projects/modules.
// plugins {
//    id("com.android.application") version "7.2.0" apply false
//    id("com.android.library") version "7.2.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
//    id("org.jetbrains.kotlin.jvm") version "1.7.0" apply false
// }

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libraries.Gradle.androidGradle)
        classpath(Libraries.Gradle.kotlinGradle)
        classpath(Libraries.Gradle.advancedBuildVersionGradle)
        classpath(Libraries.Gradle.navigationSafeArgsGradle)
        classpath(Libraries.Gradle.hiltGradle)
        classpath(Libraries.Core.kotlinNoArgs)
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

apply(plugin = "kotlin-noarg")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
