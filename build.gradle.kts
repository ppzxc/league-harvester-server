plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.cloud.tools.jib") version "3.4.0"
}

group = "com.bae.harvester"
version = "0.0.1-SNAPSHOT"

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
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
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
