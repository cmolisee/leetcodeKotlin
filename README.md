# leetcodeKotlin
Application to learn/refresh on kotlin.
* [Generate Project](#generate-project)
* [Update Project Files](#update-project-files)
* [Gradle Commands](#gradle-commands)
* [Python Script Commands](#python-script-commands)

## Setup
- - -
How this project was setup.

Dependencies and Assumptions:
- VS Code
- Gradle - version 7.6
- Kotlin - version 1.8.0 (JRE 19.0.1)
- JVM - version 11 (ensure PATH is also set)
- Python 3 - if you want to use all the scripts

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

### Gradle Commands
- - -

> | name | command |
> | --- | --- |
> | build | ./gradlew clean build [-x test] |
> | execute | ./gradlew execute -PmainClass=org.cmolisee.problems.[file-name]Kt |
> | test | ./gradlew test |

### Python Script Commands
- - -

To run python scripts you must firt run the following command to change file permissions:
> ``` chmod u+x [script-name].sh ```

Then you can run the script with:
> ``` ./[script-name].sh ```

<br/>

> | script command | descritpion |
> | --- | --- |
> | ```./run.sh``` | runs the main() function for all classes in the project skipping any class/file without a main() function. This is only scripted for Kotlin and will not work for Java or otherwise.
> | ```./generate.sh [new-file-name] [--no-test]``` | Generates new files with basic content. The optional --no-test flag will notify script to not create matching test file. |