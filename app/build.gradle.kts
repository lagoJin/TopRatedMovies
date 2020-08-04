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
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("name.remal.check-updates") version "1.0.209"
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

android.buildFeatures {
    dataBinding = true
    viewBinding = true
}

android {

    defaultConfig {
        applicationId = Packages.name

        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments = mapOf("clearPackageData" to "true")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(project(":core"))
    api(project(":feature:home"))
    api(project(":data:api"))
    api(project(":data:repository"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.activityKtx)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.OkHttp.okhttp)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)
    implementation(Dep.AndroidX.Navigation.dynamicFeaturesFragment)

    implementation(Dep.Util.timber)

    implementation(Dep.Hilt.android)
    implementation(Dep.Hilt.viewModel)
    kapt(Dep.Hilt.compiler)
    kapt(Dep.Hilt.androidCompiler)
    testImplementation(Dep.Junit.junit)
}
