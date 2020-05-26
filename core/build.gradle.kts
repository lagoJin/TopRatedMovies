plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android.dataBinding.isEnabled = true

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    implementation(Dep.AndroidX.appCompat)

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.AndroidX.activityKtx)
    implementation(Dep.AndroidX.fragmentKtx)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)

    implementation(Dep.Coil.coil)

    implementation(Dep.Dagger.android)

    implementation(Dep.Util.timber)
}
