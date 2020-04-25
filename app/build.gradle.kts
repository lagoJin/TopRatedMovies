plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

apply {
    from(rootProject.file("ktlint.gradle"))
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = Packages.name
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments = mapOf("clearPackageData" to "true")
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.activityKtx)

    implementation(Dep.Dagger.core)
    implementation(Dep.Dagger.androidSupport)
    implementation(Dep.Dagger.android)
    kapt(Dep.Dagger.compiler)
    kapt(Dep.Dagger.androidProcessor)
    compileOnly(Dep.Dagger.assistedInjectAnnotations)
    kapt(Dep.Dagger.assistedInjectProcessor)
}
