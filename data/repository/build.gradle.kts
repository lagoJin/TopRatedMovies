plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    api(project(":model"))
    implementation(project(":data:api"))
    implementation(project(":core"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.Retrofit.retrofit)

    implementation(Dep.AndroidX.Compose.paging)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)

    testImplementation(Dep.Junit.junit)
}
