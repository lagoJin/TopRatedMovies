plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
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

    implementation(Dep.Hilt.android)
    androidTestImplementation(Dep.Hilt.testing)
    kapt(Dep.Hilt.compiler)
    kaptAndroidTest(Dep.Hilt.compiler)
    kaptAndroidTest(Dep.Hilt.androidCompiler)
}
