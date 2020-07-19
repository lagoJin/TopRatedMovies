/*
 * Copyright 2020 LagoJin LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    implementation(Dep.AndroidX.design)

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

    testImplementation(Dep.Junit.junit)
}
