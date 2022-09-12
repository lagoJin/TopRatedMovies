plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from(rootProject.file("ktlint.gradle"))
    from(rootProject.file("gradle/android.gradle"))
}

android.buildFeatures {
    compose = true
}

android {

    defaultConfig {
        applicationId = Packages.name

        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.5"
    }

    android {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
            )
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:home"))
    implementation(project(":data:api"))
    implementation(project(":data:repository"))

    implementation(Dep.AndroidX.Compose.activity)
    implementation(Dep.AndroidX.Compose.viewModel)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.compiler)
    implementation(Dep.AndroidX.Compose.hilt)

    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.activityKtx)

    implementation(Dep.AndroidX.Paging.runtime)
    testImplementation(Dep.AndroidX.Paging.test)

    implementation(Dep.OkHttp.okhttp)

    implementation(Dep.AndroidX.Navigation.fragmentKtx)
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha01")

    implementation(Dep.Util.timber)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)
    testImplementation(Dep.Junit.junit)
}
