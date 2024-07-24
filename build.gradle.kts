plugins {

    alias(libs.plugins.jetbrains.kotlinCocoapods) apply false
    alias(libs.plugins.jetbrains.kotlinMultiplatform) apply false

    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}