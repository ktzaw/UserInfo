 plugins {
    id(Libraries.Plugins.androidApplication)
    id(Libraries.Plugins.kotlinAndroid)
    id(Libraries.Plugins.kotlinKapt)
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
            isMinifyEnabled = false
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
        jvmTarget = JavaVersion.VERSION_11.toString()
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
        }
        create("production") {
            dimension = "environment"
        }
    }
}

dependencies {

    // Android Core
    implementation(Libraries.Core.androidCoreKtx)
    implementation(Libraries.Core.appCompat)
    implementation(Libraries.Core.lifecycleRuntimeKtx)
    implementation(Libraries.Core.lifeCycleViewModelKtx)

    // UI
    implementation(Libraries.UI.constraintLayout)
    implementation(Libraries.UI.material)

    // Test
    testImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitAndroidTest)
    androidTestImplementation(Libraries.Test.espresso)
}
