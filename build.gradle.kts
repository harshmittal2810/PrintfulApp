buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildConfiguration.androidGradlePlugin)
        classpath(BuildConfiguration.kotlinGradlePlugin)
        classpath(BuildConfiguration.hilt)
        classpath(BuildConfiguration.safeArgs)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        maven("https://jitpack.io")
        jcenter()
    }
}

tasks.register("clean").configure {
    delete("build")
}
