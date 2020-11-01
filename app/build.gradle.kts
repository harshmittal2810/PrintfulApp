plugins {
    id(BuildConfiguration.Plugins.androidApplication)
    id(BuildConfiguration.Plugins.kotlinAndroid)
    id(BuildConfiguration.Plugins.kotlinAndroidExtensions)
    id(BuildConfiguration.Plugins.kotlinKapt)
    id(BuildConfiguration.Plugins.hiltPlugin)
}

android {
    compileSdkVersion(AndroidSdk.compileSdk)

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    defaultConfig {
        applicationId = appId
        compileSdkVersion(AndroidSdk.compileSdk)
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude("META-INF/atomicfu.kotlin_module")
    }

    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }

    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError = false
    }
}


dependencies {

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.Design.materialDesign)

    implementation(Libraries.kotlinxSerialization)
    implementation(Libraries.timber)
    implementation(Libraries.coroutineAndroid)
    implementation(Libraries.coroutineCore)
    implementation(Libraries.googleMaps)

    //region: arch
    implementation(Libraries.Arch.lifeCycleViewModel)
    implementation(Libraries.Arch.lifeCycleExtensions)
    kapt(Libraries.Arch.lifeCycleCompiler)
    implementation(Libraries.activityKtx)
    //endregion

    //region: Dagger
    implementation(Libraries.Hilt.dagger)
    implementation(Libraries.Hilt.hiltAndroid)
    implementation(Libraries.Hilt.hiltCommon)
    implementation(Libraries.Hilt.hiltLifeCycle)
    implementation(Libraries.Hilt.hiltWorker)
    kapt(Libraries.Hilt.daggerCompiler)
    kapt(Libraries.Hilt.hiltCompiler)
    kapt(Libraries.Hilt.hiltAndroidCompiler)
    //endregion

    //region glide
    implementation(Libraries.Glide.glide)
    kapt(Libraries.Glide.compiler)

    testImplementation(TestLibraries.roomTestHelper)
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.mockWebServer)
}
