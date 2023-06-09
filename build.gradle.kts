plugins {
    java
}

val mailosaurVersion: String by project
val junitJupiterVersion: String by project

group = "com.josdem.mailosaur"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.mailosaur:mailosaur-java:$mailosaurVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("mailosaurApiKey", System.getProperty("mailosaurApiKey"))
    systemProperty("mailosaurServerId", System.getProperty("mailosaurServerId"))
}