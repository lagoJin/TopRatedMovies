plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    //id("kotlin-parcelize")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.Paging.runtime)

    testImplementation(Dep.Junit.junit)
}
