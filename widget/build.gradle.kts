plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    api(project(":model"))
    implementation(project(":core"))

    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.design)
    testImplementation(Dep.Junit.junit)
}
