import com.github.gradle.node.npm.task.NpmTask

plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.cloud.tools.jib") version "3.4.0"
    id("com.github.node-gradle.node") version "7.0.1"
}

group = "com.bae.harvester"
version = "0.0.3"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.0")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

node {
    version = "18.18.0"
    npmVersion = "10.2.0"
    download = true
    nodeProjectDir = file("${rootDir}/webapp")
}

tasks.register<NpmTask>("buildAdmin") {
    args = listOf("run", "build")
}

tasks.register<Delete>("deleteFiles") {
    delete(files("${rootDir}/src/main/resources/static"))
}

tasks.register<Copy>("copyFiles") {
    from("${rootDir}/webapp/build")
    into("${rootDir}/src/main/resources/static")
}

tasks.build {
    finalizedBy("buildAdmin")
}

tasks.named("buildAdmin") {
    finalizedBy("deleteFiles")
}

tasks.named("deleteFiles") {
    finalizedBy("copyFiles")
}

jib {
    from {
        image = "eclipse-temurin:21.0.1_12-jdk-alpine"
    }

    to {
        image = "harvester/${project.name}"
        tags = setOf("${project.version}")
    }

    container {
        ports = listOf("8488")
        creationTime.set("USE_CURRENT_TIMESTAMP")
    }
}
