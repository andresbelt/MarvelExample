const val kotlinVersion = "1.3.61"

object BuildPlugins {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComponentSafeArgsPlugins}"
    const val klint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlint}"





}


object Plugins{
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinLibraryAndroid = "com.android.library"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlin = "kotlin"
    const val kotlinKapt = "kotlin-kapt"

    const val safeArgsk = "androidx.navigation.safeargs.kotlin"


}

object AndroidSdk {
    const val min = 18
    const val compile = 28
    const val target = compile

}

private object Versions {
    const val buildToolsVersion = "4.0.0"
    const val navigationComponentSafeArgsPlugins = "2.2.0"
    const val ktlint = "7.1.0"

    val appcompat = "1.2.0-alpha01"
    val room = "2.2.3"
    val kotlin = "1.3.61"
    val timber = "4.7.1"
    val retrofit = "2.7.0"
    val loggingInterceptor = "4.2.2"
    val glide = "4.10.0"
    val moshi = "1.8.0"
    val lifecycle = "2.1.0"
    val junit = "4.12"
    val coroutine_test = "1.3.2"
    val mockito = "2.28.2"
    val dagger = "2.27"
    val espresso = "3.3.0-alpha03"
    val testRunner = "1.3.0-alpha03"
    val shimmer = "0.5.0"
    val navigation = "2.2.0-rc04"
    val design = "1.1.0"
    val cardview = "1.0.0"
    val recyclerview = "1.2.0-alpha01"
    val constraintLayout = "1.1.3"
    val material="1.2.0-alpha06"
    val paging_version = "2.1.0"

}


object AndroidXLibraries {

    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation_fragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    val navigation = "androidx.navigation:navigation-ui:${Versions.navigation}"
    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}


object Libraries {

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    val room_compiler = "androidx.room:room-compiler:${Versions.room}"

    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"



    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerAndroidProcessor= "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val materialAndroid = "com.google.android.material:material:${Versions.material}"


    val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging_version}"

}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine_test}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val espresso_runner = "androidx.test:runner:${Versions.testRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Modules {
    val data = ":data"
    val domain = ":domain"
    val presentation = ":presentation"
}
