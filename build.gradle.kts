import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dep.Kotlin.version}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Dep.AndroidX.Navigation.version}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28.3-alpha")
    }
}

plugins {
    id("com.diffplug.gradle.spotless") version "3.27.1"
    id("io.gitlab.arturbosch.detekt") version "1.12.0"
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.diffplug.gradle.spotless")
    val ktlintVer = "0.37.2"
    spotless {
        kotlin {
            target("**/*.kt")
            ktlint(ktlintVer).userData(
                mapOf("max_line_length" to "100", "disabled_rules" to "import-ordering")
            )
            licenseHeaderFile(project.rootProject.file("copyright.kt"))
        }
        kotlinGradle {
            // same as kotlin, but for .gradle.kts files (defaults to '*.gradle.kts')
            target("**/*.gradle.kts")
            ktlint(ktlintVer)
            licenseHeaderFile(
                project.rootProject.file("copyright.kt"),
                "(plugins |import |include)"
            )
        }
    }

    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt.html")
            }
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

    // TODO: Remove when the Coroutine and Flow APIs leave experimental/internal/preview.
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs +=
            "-Xuse-experimental=" +
                "kotlin.Experimental," +
                "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                "kotlinx.coroutines.InternalCoroutinesApi," +
                "kotlinx.coroutines.FlowPreview"
    }

    tasks {
        withType<io.gitlab.arturbosch.detekt.Detekt> {
            // Target version of the generated JVM bytecode. It is used for type resolution.
            this.jvmTarget = "1.8"
        }
    }
}
