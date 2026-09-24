pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.kikugie.dev/snapshots")
        maven("https://maven.fabricmc.net")
    }
}

plugins {
    id("io.github.bizcub.multiloader") version "0.8+"
}

multiloader {
    matchExact("26.4", "26.4-snapshot-1", fb)
}
