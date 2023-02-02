# leetcodeKotlin
Application to learn/refresh on kotlin.
* [Generate Project](#generate-project)
* [Update Project Files](#update-project-files)

## Setup
- - -
How this project was setup.

Dependencies and Assumptions:
- VS Code
- Gradle - version 7.6
- Kotlin - version 1.8.0 (JRE 19.0.1)
- JVM - version 11 (ensure PATH is also set)

### Create repo
- - -
Log in to your github and create a new repo
Go to the desired directory on your local, clone the repo, cd into the cloned folder

### Generate Project
- - -
In terminal on the project folder run `gradle init` and follow the prompts to:
1. (1) Basic
2. (2) Kotlin

Create new directory in root 'src/problems', 'src/resources', 'test/problems'

See [build.gradle.kts](./build.gradle.kts) for build configurations

Create and see [gradle.properties](./gradle.properties) for gradle configurations