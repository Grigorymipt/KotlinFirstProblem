plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.kotlin.link")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.lets-plot:lets-plot-kotlin-jvm:4.3.0")
    implementation("org.jetbrains.lets-plot:lets-plot-image-export:3.1.0")
    //implementation("space.kscience:plotlykt-server:1.1.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}