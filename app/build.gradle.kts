plugins {
    id("com.github.ben-manes.versions") version "0.53.0"
    id("org.sonarqube") version "7.2.3.7755"
    application
    id("java")
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}

sonar {
    properties {
        property("sonar.projectKey", "MatveyStarkov_java-project-71")
        property("sonar.organization", "matveystarkov-1")
    }
}

tasks.test {
    useJUnitPlatform()
}