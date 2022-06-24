import Libraries.Network.retrofit2

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
        const val kotlinNoArgs = "kotlin-noarg"
        const val advancedBuildVersion = "me.moallemi.advanced-build-version"
        const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
        const val daggerHilt = "dagger.hilt.android.plugin"
    }

    object Core {

        // Android Dependencies
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
        const val kotlinNoArgs = "org.jetbrains.kotlin:kotlin-noarg:${Versions.kotlinVersion}"
        const val kotlinReflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinReflectionVersion}"

        const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXSupportVersion}"
        const val androidCoreKtx = "androidx.core:core-ktx:${Versions.androidXCoreKtxVersion}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifeCycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    }

    object UI {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidXConstraintLayoutVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}"
        const val activity = "androidx.activity:activity:${Versions.activityVersion}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityVersion}"
    }

    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroidVersion}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHiltCompilerVersion}"
        const val androidxHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltCompilerVersion}"
    }

    object Room {

        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    }

    object Network {

        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptorVersion}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverterVersion}"
    }

    object Test {

        const val junit = "junit:junit:${Versions.junitTestVersion}"
        const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.androidXEspressoVersion}"
        const val junitAndroidTest = "androidx.test.ext:junit:"
    }
}
