plugins {
    java
}


group = "com.josdem.mailosaur"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.mailosaur:mailosaur-java:7.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.mockito:mockito-junit-jupiter:2.17.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("mailosaurApiKey", System.getProperty("mailosaurApiKey"))
    systemProperty("mailosaurServerId", System.getProperty("mailosaurServerId"))
}