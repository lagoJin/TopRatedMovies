buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dep.Kotlin.version}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Dep.AndroidX.Navigation.version}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dep.Hilt.version}")
    }
}

plugins {
    id("com.diffplug.spotless") version "6.2.0"
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    val ktlintVer = "0.43.2"
    spotless {
        kotlin {
            target("**/*.kt")
            ktlint(ktlintVer).userData(
                mapOf("max_line_length" to "100", "disabled_rules" to "import-ordering")
            )
        }
        kotlinGradle {
            // same as kotlin, but for .gradle.kts files (defaults to '*.gradle.kts')
            target("**/*.gradle.kts")
            ktlint(ktlintVer)
        }
    }

    // `spotlessCheck` runs when a build includes `check`, notably during presubmit. In these cases
    // we prefer `spotlessCheck` run as early as possible since it fails in seconds. This prevents a
    // build from running for several minutes doing other intensive tasks (resource processing, code
    // generation, compilation, etc) only to fail on a formatting nit.
    // Using `mustRunAfter` avoids creating a task dependency. The order is enforced only if
    // `spotlessCheck` is already scheduled to run, so we can still build and launch from the IDE
    // while the code is "dirty".
    tasks.whenTaskAdded {
        if (name == "preBuild") {
            mustRunAfter("spotlessCheck")
        }
    }
}
