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
    id("name.remal.check-updates") version "1.0.209"
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

dependencies {
    api(project(":model"))
    implementation(project(":core"))

    implementation(Dep.Kotlin.stdlibJvm)
    implementation(Dep.Kotlin.coroutines)

    implementation(Dep.AndroidX.design)
    testImplementation(Dep.Junit.junit)
}
