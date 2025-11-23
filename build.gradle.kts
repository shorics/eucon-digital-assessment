plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.noarg") version "2.2.21"
}

group = "wtf.shorics"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.opencsv:opencsv:5.12.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

noArg {
    annotation("wtf.shorics.annotation.NoArg")
}