plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Hibernate
    implementation("org.hibernate:hibernate-core:5.6.10.Final")
    // Lombok
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    // Base de datos H2 para desarrollo
    runtimeOnly("com.h2database:h2:2.2.220")
}

application {
    mainClass.set("org.example.Main") // Replace with your main class
}

tasks.test {
    useJUnitPlatform()
}