plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    api(project(":model"))
    implementation(project(":core"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.design)

    implementation(Dep.Dagger.core)
    implementation(Dep.Dagger.androidSupport)
}
