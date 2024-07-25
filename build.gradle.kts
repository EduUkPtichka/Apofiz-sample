plugins {

    alias(libs.plugins.jetbrains.kotlinCocoapods) apply false
    alias(libs.plugins.jetbrains.kotlinMultiplatform) apply false
    alias(libs.plugins.jetbrains.kotlinSerialization) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.ktorfit.plugin) apply false

    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
}