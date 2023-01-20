plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    implementation("com.google.guava:guava:31.1-jre")
}

application {
    mainClass.set("org.leetcodeKotlin.kotlin.AppKt")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
