import java.nio.file.Files
import java.nio.file.Paths
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("io.github.microutils:kotlin-logging:3.0.4")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5")
    implementation("org.slf4j:slf4j-simple:2.0.6")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.1")

}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
    test {
        java {
            setSrcDirs(listOf("test"))
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Test> {
    // code from https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        lifecycle {
            events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
            exceptionFormat = TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
        }
        info.events = lifecycle.events
        info.exceptionFormat = lifecycle.exceptionFormat
    }

    val failedTests = mutableListOf<TestDescriptor>()
    val skippedTests = mutableListOf<TestDescriptor>()

    val ansiGreen = "\u001B[32m"
    val ansiRed = "\u001B[31m"
    val ansiYellow = "\u001B[33m"
    val ansiCyan = "\u001B[36m" 
    val ansiWhite = "\u001B[37m"

    // See https://github.com/gradle/kotlin-dsl/issues/836
    addTestListener(object : TestListener {
        override fun beforeSuite(suite: TestDescriptor) {}
        override fun beforeTest(testDescriptor: TestDescriptor) {}
        override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
            when (result.resultType) {
                TestResult.ResultType.FAILURE -> failedTests.add(testDescriptor)
                TestResult.ResultType.SKIPPED -> skippedTests.add(testDescriptor)
                else -> Unit
            }
        }

        override fun afterSuite(suite: TestDescriptor, result: TestResult) {
            if (suite.parent == null) { // root suite
                logger.lifecycle("----")
                logger.lifecycle("Test result: ${result.resultType}")
                logger.lifecycle(
                        "Test summary: $ansiCyan ${result.testCount} tests, " +
                        "$ansiGreen ${result.successfulTestCount} succeeded," +
                        "$ansiRed ${result.failedTestCount} failed, " +
                        "$ansiYellow ${result.skippedTestCount} skipped $ansiWhite")
                failedTests.takeIf { it.isNotEmpty() }?.prefixedSummary("\tFailed Tests")
                skippedTests.takeIf { it.isNotEmpty() }?.prefixedSummary("\tSkipped Tests:")
            }
        }

        private infix fun List<TestDescriptor>.prefixedSummary(subject: String) {
                logger.lifecycle(subject)
                forEach { test -> logger.lifecycle("\t\t${test.displayName()}") }
        }

        private fun TestDescriptor.displayName() = parent?.let { "${it.name} - $name" } ?: "$name"
    })
}

// Use this to call/run individual class files
tasks.create("execute", type = JavaExec::class) {
    val executor = this
    executor.isIgnoreExitValue = true
    sourceSets.main {
        executor.classpath = runtimeClasspath
    }
    jvmArgs = listOf("-ea")
    main = "org.cmolisee.problems." + project.properties["mainClass"].toString() + "Kt"

    doLast {
        if (executionResult.get().exitValue != 0) {
            println("\u001B[31m >>> Execution failed <<< \u001B[37m")
            executionResult.get().rethrowFailure()
        }
    }
}