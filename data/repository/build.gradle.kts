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
    api(project(":model"))
    implementation(project(":data:api"))
    implementation(project(":core"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)
    implementation(Dep.OkHttp.okhttp)
    implementation(Dep.Retrofit.retrofit)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.Hilt.android)
    androidTestImplementation(Dep.Hilt.testing)
    kapt(Dep.Hilt.compiler)
    kaptAndroidTest(Dep.Hilt.compiler)
    kaptAndroidTest(Dep.Hilt.androidCompiler)
}
