plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android.buildFeatures {
    compose = true
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    implementation(project(":core"))
    implementation(project(":model"))
    implementation(project(":widget"))
    implementation(project(":data:repository"))

    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.AndroidX.Compose.activity)
    implementation(Dep.AndroidX.Compose.viewModel)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.paging)
    implementation(Dep.AndroidX.Compose.compiler)
    implementation(Dep.AndroidX.Compose.hilt)
    implementation(Dep.AndroidX.Compose.runtime)

    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.viewModelKtx)
    implementation(Dep.AndroidX.recyclerView)
    implementation(Dep.AndroidX.liveDataKtx)
    implementation(Dep.AndroidX.design)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)
    implementation("androidx.navigation:navigation-compose:2.5.0-alpha03")

    implementation(Dep.Util.timber)

    implementation(Dep.Coil.coil)
    implementation(Dep.Coil.compose)

    androidTestImplementation(Dep.Hilt.testing)
    kapt(Dep.Hilt.compiler)
    implementation(Dep.Hilt.hilt)
    kaptAndroidTest(Dep.Hilt.compiler)

    testImplementation(Dep.Junit.junit)
}
