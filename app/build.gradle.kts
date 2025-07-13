plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    application
    id("io.freefair.lombok") version "8.4"
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application { mainClass.set("hexlet.code.App") }

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.7")
    implementation(group=("com.fasterxml.jackson.core"), name=("jackson-databind"), version=("2.17.2"))
    implementation(group=("com.fasterxml.jackson.dataformat"), name=("jackson-dataformat-yaml"), version=("2.14.2"))
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "Lirk133_java-project-71")
        property("sonar.organization", "lirk133")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

