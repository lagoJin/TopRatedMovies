object Dep {

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.2.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.1"
        val design = "com.google.android.material:material:1.2.0"
        val coreKtx = "androidx.core:core-ktx:1.3.1"
        val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.5"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0-beta01"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

        object Navigation {
            val version = "2.3.0"
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${version}"
            val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:$version"
            val args = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Paging {
            private val version = "3.0.0-alpha01"
            val runtime = "androidx.paging:paging-runtime:$version"
            val test = "androidx.paging:paging-common:$version"
        }
    }

    object Retrofit {
        private val version = "2.9.0"

        val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val gson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private val version = "4.8.1"
        val okhttp = "com.squareup.okhttp3:okhttp:$version"
        val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Threetenabp {
        private val version = "1.2.4"
        val threetenabp = "com.jakewharton.threetenabp:threetenabp:$version"
    }

    object Kotlin {
        val version = "1.4.0"
        val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val coroutinesVersion = "1.3.9"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object Hilt {
        private val version = "2.28-alpha"
        val android = "com.google.dagger:hilt-android:$version"
        val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
        val androidCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
        val compiler = "com.google.dagger:hilt-android-compiler:$version"
        val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object Coil {
        private val version = "0.11.0"
        val coil = "io.coil-kt:coil:$version"
    }

    object Util {
        private val version = "4.7.1"
        val timber = "com.jakewharton.timber:timber:$version"
    }

    object Junit {
        private val version = "4.13"
        val junit = "junit:junit:$version"
    }
}
