plugins {
    id(Libraries.Plugins.androidApplication)
    id(Libraries.Plugins.kotlinAndroid)
    id(Libraries.Plugins.kotlinKapt)
    id(Libraries.Plugins.daggerHilt)
    id("org.jetbrains.kotlin.android")
}

android {

    signingConfigs {
        create("release") {
            storeFile =
                file("C:\\Users\\ROG-Zephyrus\\AndroidStudioProjects\\Keystore\\keystore.jks")
            storePassword = "acepluscodingtest"
            keyAlias = "UserInfo"
            keyPassword = "acepluscodingtest"
        }
    }
    setCompileSdkVersion(Configs.compileSdkVersion)
    buildToolsVersion = Configs.buildToolsVersion

    defaultConfig {
        applicationId = Configs.appId
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.compileSdkVersion
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }

        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    flavorDimensions += listOf("environment")
    productFlavors {
        create("staging") {
            dimension = "environment"
            applicationIdSuffix = ".staging"
            buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }
        create("production") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Android Core
    implementation(Libraries.Core.androidCoreKtx)
    implementation(Libraries.Core.appCompat)
    implementation(Libraries.Core.lifecycleRuntimeKtx)
    implementation(Libraries.Core.lifeCycleViewModelKtx)

    // Kotlin
    implementation(Libraries.Core.coroutinesCore)
    implementation(Libraries.Core.coroutinesAndroid)

    // UI
    implementation(Libraries.UI.constraintLayout)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.swipeRefreshLayout)
    implementation(Libraries.UI.activity)
    implementation(Libraries.UI.activityKtx)

    // Hilt
    implementation(Libraries.Hilt.hiltAndroid)
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    kapt(Libraries.Hilt.androidxHiltCompiler)
    kapt(Libraries.Hilt.daggerHiltCompiler)

    // Room
    implementation(Libraries.Room.roomKtx)
    implementation(Libraries.Room.roomRuntime)
    kapt(Libraries.Room.roomCompiler)

    // Network
    implementation(Libraries.Network.retrofit2)
    implementation(Libraries.Network.okHttpLoggingInterceptor)
    implementation(Libraries.Network.gsonConverter)

    // Test
    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitAndroidTest)
    androidTestImplementation(Libraries.Test.espresso)
}
