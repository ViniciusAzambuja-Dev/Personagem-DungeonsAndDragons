plugins {
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = "org.example" // Identificador do grupo
            artifactId = "PersonagemDeD" // Nome do artefato
            version = "1.0-SNAPSHOT" // Versão do artefato
        }
    }
    repositories {
        maven {
            url = uri("https://jitpack.io") // URL do repositório onde o artefato será publicado
        }
    }
}