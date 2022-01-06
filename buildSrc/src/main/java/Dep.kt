object Dep {

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.4.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        val constraint = "androidx.constraintlayout:constraintlayout:2.1.2"
        val design = "com.google.android.material:material:1.4.0"
        val coreKtx = "androidx.core:core-ktx:1.7.0"
        val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"

        object Navigation {
            val version = "2.4.0-beta02"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${version}"
            val args = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Paging {
            private val version = "3.1.0"
            val runtime = "androidx.paging:paging-runtime:$version"

            val test = "androidx.paging:paging-common:$version"
        }

        object Compose {
            private const val version = "1.0.5"
            const val activity = "androidx.activity:activity-compose:1.3.1"
            const val material = "androidx.compose.material:material:$version"
            const val animation = "androidx.compose.animation:animation:$version"
            const val compiler = "androidx.compose.compiler:compiler:$version"
            const val hilt = "androidx.hilt:hilt-navigation-compose:1.0.0-beta01"
            const val paging = "androidx.paging:paging-compose:1.0.0-alpha14"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val runtime = "androidx.compose.runtime:runtime-livedata:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-rc01"
        }
    }

    object Retrofit {
        private val version = "2.9.0"

        val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val gson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private val version = "4.9.3"
        val okhttp = "com.squareup.okhttp3:okhttp:$version"
        val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Kotlin {
        val version = "1.5.10"
        val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val coroutinesVersion = "1.6.0"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object Hilt {
        const val version = "2.40.5"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object Coil {
        private const val version = "1.4.0"
        const val coil = "io.coil-kt:coil:$version"
        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object Util {
        private val version = "5.0.1"
        val timber = "com.jakewharton.timber:timber:$version"
    }

    object Junit {
        private val version = "4.13.2"
        val junit = "junit:junit:$version"
    }
}
