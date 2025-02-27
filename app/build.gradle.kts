plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias (libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.gms.google.services)

}

android {
    namespace = "com.example.myordermanager"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myordermanager"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    composeOptions {

        kotlinCompilerExtensionVersion = "1.7.20" // This is the Compose compiler version

    }

    buildTypes {
        /*release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }*/
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    flavorDimensions += "0.1"
    productFlavors {
        create("dev") {
            // Assigns this product flavor to the "version" flavor dimension.
            // If you are using only one dimension, this property is optional,
            // and the plugin automatically assigns all the module's flavors to
            // that dimension.
            dimension = "0.1"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }
        create("live") {
            dimension = "0.1"
            applicationIdSuffix = ".live"
            versionNameSuffix = "-live"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    kotlinOptions {
        jvmTarget = "19"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    //implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.credentials)
  //  implementation("org.jetbrains.kotlin.android:2.0.0")

    // optional - needed for credentials support from play services, for devices running
    // Android 13 and below.
 //   implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.androidx.animation.android)
    implementation(libs.androidx.ui.android)
    implementation (libs.androidx.foundation)
    implementation(libs.androidx.runtime)
  //  implementation (libs.androidx.material3.adaptive.navigation.suite)
    implementation( libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation (libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)
    implementation (libs.androidx.credentials.v120)
    implementation(libs.androidx.credentials.play.services.auth)
   // implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.material)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.firebase.auth)
    implementation(libs.googleid)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.core.splashscreen)
}