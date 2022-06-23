object Libraries {

    object Gradle {
        // Gradle Plugins
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val advancedBuildVersionGradle = "me.moallemi.gradle:advanced-build-version:${Versions.advancedBuildVersionGradle}"
        const val navigationSafeArgsGradle = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafeArgsGradle}"
        const val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltGradle}"
    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
        const val advancedBuildVersion = "me.moallemi.advanced-build-version"
        const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
        const val daggerHilt = "dagger.hilt.android.plugin"
    }

    object Core {

        // Android Dependencies
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
        const val kotlinReflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinReflectionVersion}"

        const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXSupportVersion}"
        const val androidCoreKtx = "androidx.core:core-ktx:${Versions.androidXCoreKtxVersion}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifeCycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidXConstraintLayoutVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object Test {

        const val junit = "junit:junit:${Versions.junitTestVersion}"
        const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.androidXEspressoVersion}"
        const val junitAndroidTest = "androidx.test.ext:junit:"
    }
}
