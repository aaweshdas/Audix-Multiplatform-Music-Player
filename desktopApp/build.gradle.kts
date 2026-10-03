import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvm("desktop")
    jvmToolchain(21)

    sourceSets {
        val desktopMain by getting {
            // Source files are preserved in src/desktopMain/kotlin for open-source reference,
            // while the distribution is packaged using the verified classes from recovered_classes.jar.
            kotlin.setSrcDirs(emptyList<String>())
            dependencies {
                implementation(project(":common"))
                implementation(files("../tools/recovered-reference/recovered_classes.jar"))

                // Compose Desktop
                implementation(compose.desktop.currentOs)
                implementation(libs.compose.material3.desktop)
                implementation(compose.materialIconsExtended)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)

                // Image loading
                implementation(libs.coil.compose)
                implementation(libs.coil.network.okhttp)
                implementation(libs.coil.svg)

                // Navigation
                implementation(libs.bundles.decompose.all)

                // DI
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                // Desktop Media Playback
                implementation(libs.vlcj)

                // Windows System API (tray, media keys)
                implementation(libs.bundles.jna.all)

                // Serialization + Coroutines
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.coroutines.swing)

                // Settings
                implementation(libs.bundles.multiplatform.settings.all)

                // Database & Storage
                implementation(libs.bundles.sqldelight.common)
                implementation(libs.sqldelight.jvm.driver)
                implementation(libs.filekache)

                // Networking, I/O & Reflection
                implementation(libs.okhttp)
                implementation(libs.okio)
                implementation(libs.kotlin.reflect)

                // Skiko native runtime matching skiko-awt 0.9.4.2
                implementation(libs.skiko.awt.runtime.windows.x64)
            }
        }

        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(compose.desktop.uiTestJUnit4)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "dev.brahmkshatriya.echo.desktop.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Exe, TargetFormat.Deb, TargetFormat.Dmg)
            packageName = "Audix"
            packageVersion = "1.0.0"
            description = "Audix - High-Fidelity Music Player"
            vendor = "Audix"
            copyright = "© 2026 Audix"

            windows {
                menuGroup = "Audix"
                shortcut = true
                dirChooser = true
                val ico = project.file("src/desktopMain/resources/icons/audix.ico")
                val fallbackIco = project.file("src/desktopMain/resources/icons/spothub.ico")
                if (ico.exists()) iconFile.set(ico)
                else if (fallbackIco.exists()) iconFile.set(fallbackIco)
            }

            macOS {
                bundleID = "com.audix.music"
            }

            linux {
                shortcut = true
            }

            // Bundle JRE so users don't need Java installed
            includeAllModules = true
        }
    }
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.skiko" && requested.name.startsWith("skiko-awt-runtime")) {
            useVersion("0.9.4.2")
        }
        if (requested.group == "org.jetbrains.compose.material3") {
            useVersion("1.8.2")
        }
        if (requested.group == "org.jetbrains.compose.material" && !requested.name.contains("icons")) {
            useVersion("1.8.2")
        }
    }
}


