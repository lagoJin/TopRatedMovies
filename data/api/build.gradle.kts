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
    implementation(project(":model"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.Retrofit.retrofit)
    implementation(Dep.Retrofit.gson)
    implementation(Dep.OkHttp.okhttp)
    implementation(Dep.OkHttp.interceptor)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)
    testImplementation(Dep.Junit.junit)
}
