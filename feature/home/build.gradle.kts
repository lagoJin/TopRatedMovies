plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android.buildFeatures {
    dataBinding = true
    viewBinding = true
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data:repository"))
    implementation(project(":widget"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.viewModelKtx)
    implementation(Dep.AndroidX.recyclerView)
    implementation(Dep.AndroidX.liveDataKtx)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)

    implementation(Dep.Util.timber)

    implementation(Dep.Coil.coil)

    implementation(Dep.Hilt.android)
    implementation(Dep.Hilt.viewModel)
    androidTestImplementation(Dep.Hilt.testing)
    kapt(Dep.Hilt.compiler)
    kapt(Dep.Hilt.androidCompiler)
    kaptAndroidTest(Dep.Hilt.compiler)
    kaptAndroidTest(Dep.Hilt.androidCompiler)
}
