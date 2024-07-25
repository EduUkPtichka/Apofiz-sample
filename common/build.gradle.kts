import de.jensklingenberg.ktorfit.gradle.ErrorCheckingMode
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.jetbrains.kotlinMultiplatform)
    alias(libs.plugins.jetbrains.kotlinCocoapods)
    alias(libs.plugins.jetbrains.kotlinSerialization)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.ktorfit.plugin)
    alias(libs.plugins.androidLibrary)
}

ktorfit {
    errorCheckingMode = ErrorCheckingMode.ERROR
    generateQualifiedTypeName = false
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0"

        framework {

            // Data
            export(libs.ktor.client.darwin)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.jetbrains.coroutines.core)
                implementation(libs.jetbrains.serialization.json)

                // Data
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktorfit.lib.light)
                implementation(libs.ktorfit.converters.flow)
                implementation(libs.ktorfit.converters.call)
                implementation(libs.ktorfit.converters.response)

            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.jetbrains.coroutines.android)

                // Data
                api(libs.ktor.client.okhttp)
                implementation(libs.squareup.okhttp3)
            }
        }
    }

    /*
     *  Настраиваем разом параметры компилятора, для всех платформ,
     */
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    namespace = "com.example.apofiz.common"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}


