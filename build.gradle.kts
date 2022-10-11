import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.32"
}

group = project.properties["group"] as String
version = project.properties["version"] as String

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.kyori:adventure-api:4.11.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}