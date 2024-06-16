import java.util.regex.Pattern.compile

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.moviesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.moviesapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.material:material:1.0.0")
    implementation ("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")


//    val koin_version = "3.5.0"
//    implementation ("org.koin:koin-core:$koin_version")
//    implementation ("org.koin:koin-androidx-scope:$koin_version")
//    implementation ("org.koin:koin-androidx-viewmodel:$koin_version")
    implementation ("io.insert-koin:koin-android:3.2.0")
    testImplementation ("io.insert-koin:koin-test-junit4:3.2.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    val paging_version = "3.1.0"

    implementation ("androidx.paging:paging-runtime-ktx:$paging_version")
    implementation ("androidx.paging:paging-common-ktx:$paging_version")
}