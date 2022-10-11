import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.32"
    `maven-publish`
    signing
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

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8

    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {

            from(components["java"])

            pom {
                artifactId = "adventure-kx"
                name.set("Adventure KX")
                description.set("Kotlin Extensions for Adventure API")
                url.set("https://github.com/Gorayan/adventure-kx")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/Gorayan/adventure-kx/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("gorayan")
                        name.set("Gorayan")
                        email.set("gorayan3838@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:github.com:Gorayan/adventure-kx.git")
                    developerConnection.set("scm:git:github.com:Gorayan/adventure-kx.git")
                    url.set("https://github.com/Gorayan/adventure-kx")
                }
            }

        }
    }

    repositories {

        maven {

            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

            credentials {

                val props = org.jetbrains.kotlin.konan.properties.loadProperties("${projectDir}/local.properties")

                username = props.getProperty("sonatype.user") ?: System.getenv("SONATYPE_USER")
                password = props.getProperty("sonatype.password") ?: System.getenv("SONATYPE_PASSWORD")

            }

        }

    }
}

signing {
    sign(publishing.publications["mavenJava"])
}
