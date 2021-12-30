plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

android.buildFeatures {
    dataBinding = true
    viewBinding = true
}

android {

    defaultConfig {
        applicationId = Packages.name

        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(project(":core"))
    api(project(":feature:home"))
    api(project(":data:api"))
    api(project(":data:repository"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.activityKtx)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.OkHttp.okhttp)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)

    implementation(Dep.Util.timber)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)
    testImplementation(Dep.Junit.junit)
}
