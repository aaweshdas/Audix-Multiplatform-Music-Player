import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvmToolchain(21)

    @Suppress("UnstableApiUsage")
    androidLibrary {
        namespace = "dev.brahmkshatriya.echo.core"
        compileSdk = 36
        minSdk = 24
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            api(project(":common"))
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.okhttp)
            implementation(libs.koin.core)
            implementation(libs.bundles.sqldelight.common)
            implementation(libs.filekache)
            implementation(libs.bundles.multiplatform.settings.all)
            implementation(libs.okio)
        }

        androidMain.dependencies {
            implementation(libs.sqldelight.android.driver)
            implementation(libs.koin.android)
            implementation(libs.bundles.koin.android.bundle)
        }

        val desktopMain by getting {
            dependencies {
                implementation(libs.sqldelight.jvm.driver)
                implementation(libs.vlcj)
                implementation(libs.kotlinx.coroutines.swing)
            }
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}

sqldelight {
    databases {
        create("EchoDatabase") {
            packageName.set("dev.brahmkshatriya.echo.core.db")
        }
    }
}

