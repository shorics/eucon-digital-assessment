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
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.hibernate.orm:hibernate-core:7.1.9.Final")
    implementation("com.opencsv:opencsv:5.12.0")
    runtimeOnly("com.h2database:h2:2.4.240")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

noArg {
    annotation("wtf.shorics.annotation.NoArg")
}