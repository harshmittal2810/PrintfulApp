import BuildConfiguration.Versions.hiltPluginVersion
import BuildConfiguration.Versions.saveArgsPluginVersion


const val kotlinVersion = "1.4.0"
const val appId = "com.harsh.printfulapp"

object BuildConfiguration {
    private object Versions {
        const val buildToolsVersion = "4.1.0"
        const val hiltPluginVersion = "2.28-alpha"
        const val saveArgsPluginVersion = "2.3.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${hiltPluginVersion}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${saveArgsPluginVersion}"

    object Plugins {
        const val androidApplication = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val kotlinKapt = "kotlin-kapt"
        const val hiltPlugin = "dagger.hilt.android.plugin"
        const val kotlin = "kotlin"
        const val kotlinJvm = "org.jetbrains.kotlin.jvm"
        const val javaLibrary = "java-library"
        const val safeArgs = "androidx.navigation.safeargs.kotlin"
    }
}

object AndroidSdk {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = compileSdk
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Libraries {
    private object Versions {

        const val appCompat = "1.0.2"
        const val materialDesign = "1.2.0-beta01"
        const val legacySupport = "1.1.0"
        const val ktx = "1.1.0"
        const val constraintLayout = "2.0.0-beta7"
        const val livedb = "19.3.1"
        const val roomVersion = "2.2.3"
        const val ktxSerialization = "1.0.0-RC"
        const val retrofit = "2.7.1"
        const val timber = "4.7.1"
        const val coroutines = "1.3.3"
        const val okHttp = "4.3.1"
        const val fragment = "1.2.1"
        const val androidxAnnotation = "1.1.0"
        const val sl4j = "1.7.30"
        const val logback = "2.0.0"
        const val okhttpLoggingInterceptor = "4.3.1"
        const val workManager = "2.4.0"
        const val dagger2 = "2.26"
        const val daggerHiltAndroidVersion = "2.28-alpha"
        const val daggerHiltVersion = "1.0.0-alpha02"
        const val archComponents = "2.2.0"
        const val navigation = "2.3.0"
        const val kotlinxSerializationConverter = "0.7.0"
        const val moshiConverter = "2.6.2"
        const val stateMachine = "0.2.0"
        const val activityKtx = "1.2.0-alpha06"
        const val glide = "4.11.0"
        const val googleMaps = "17.0.0"
    }

    object Arch {
        const val lifeCycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.archComponents}"
        const val lifeCycleCompiler =
            "androidx.lifecycle:lifecycle-compiler:${Versions.archComponents}"
        const val lifeCycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.archComponents}"
        const val lifeCycleRuntime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.archComponents}"
    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Network {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptor}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val kotlinxSerialisationHeaderInterceptor =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinxSerializationConverter}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    }

    object Design {
        const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    }

    object Hilt {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger2}"
        const val hiltAndroid =
            "com.google.dagger:hilt-android:${Versions.daggerHiltAndroidVersion}"
        const val hiltCommon = "androidx.hilt:hilt-common:${Versions.daggerHiltVersion}"
        const val hiltLifeCycle =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.daggerHiltVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltAndroidVersion}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.daggerHiltVersion}"
        const val hiltWorker = "androidx.hilt:hilt-work:${Versions.daggerHiltVersion}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val kotlinxSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.ktxSerialization}"
    const val kotlinxJvmSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:${Versions.ktxSerialization}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val fragments = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val androidxAnnotation = "androidx.annotation:annotation:${Versions.androidxAnnotation}"
    const val sl4jLogger = "org.slf4j:slf4j-api:${Versions.sl4j}"
    const val logback = "com.github.tony19:logback-android:${Versions.logback}"
    const val workRuntime = "androidx.work:work-runtime-ktx:${Versions.workManager}"

    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val stateMachine = "com.tinder.statemachine:statemachine:${Versions.stateMachine}"
    const val googleMaps = "com.google.android.gms:play-services-maps:${Versions.googleMaps}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.1"
        const val espresso = "3.2.0"
        const val roomVersion = "2.2.3"
        const val okHttp = "4.3.1"
        const val fragment = "1.2.1"
        const val workManagerVersion = "2.3.0"
        const val hilt = "2.28-alpha"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val roomTestHelper = "androidx.room:room-testing:${Versions.roomVersion}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    const val fragments = "androidx.fragment:fragment-testing:${Versions.fragment}"
    const val workTest = "androidx.work:work-testing:${Versions.workManagerVersion}"
    const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
}