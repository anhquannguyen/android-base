// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    apply("dependencies.gradle")

    val kotlinVersion = "1.4.21"
    val gradleVersion = "4.1.1"

    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:${gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.google.com")

    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
