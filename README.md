# leetcodeKotlin
Application to learn/refresh on kotlin.
* [Generate Project](#generate-project)
* [Update Project Files](#update-project-files)
* [Logging Configuration](#logging-configuration)

## Setup
- - -
How this project was setup.

Dependencies and Assumptions:
- VS Code
- Gradle - I use 7.6
- Kotlin - I use 1.8.0 (JRE 19.0.1)
- JVM (set in PATH too. I use 11)

### Create repo
- - -
Log in to your github and create a new repo
Go to the desired directory on your local, clone the repo, cd into the cloned folder

### Generate Projec
- - -
In terminal on the project folder run `gradle init` and follow the prompts to:
1. Application
2. Kotlin
3. Single application
4. Kotlin DSL

Set the project name and then set the directory (e.x. org.example.kotlin).

### Update Project File
- - -
Add the following in your project root
in .vscode/launch.json:

```json
    {
    "version": "0.2.0",
        "configurations": [
            {
                "type": "kotlin",
                "request": "launch",
                "name": "Kotlin Launch",
                "projectRoot": "/Users/codymolisee/Documents/leetcode-kotlin/app",
                "mainClass": "/src/main/kotlin/cmolisee/leetcode/kt/App",
                "preLaunchTask": "build"
            }
        ]
    }
```

in .vscode/tasks.json:

```json
{
	"version": "2.0.0",
	"tasks": [
        {
            "label": "build",
            "type": "shell",
            "command": "./gradlew clean build -x test",
            "problemMatcher": [],
            "group": {
                "kind": "build",
                "isDefault": true
            }
        },
        {
            "label": "run",
            "type": "shell",
            "command": "./gradlew run",
            "problemMatcher": []
        },
        {
            "label": "test",
            "type": "shell",
            "command": "./gradlew clean test",
            "problemMatcher": []
        }
    ]
}
```

Create a `gradle.properties` file in project root and set the following to write build output to file:
`kotlin.build.report.output=file`

### Logging Configuration
- - -
Add the following dependencies in `build.gradle` file:

```kotlin
implementation("org.slf4j:slf4j-simple:2.0.6")
implementation("io.github.microutils:kotlin-logging:3.0.4")
```

<mark>Versions may be different</mark>

Add the following `/resources/simplelogger.properties` under `app/src/main`.
Paste/edit the following template into the file you just created to configure slf4j-simplelogger for kotlin-logging.

```text
# - The output target which can be the path to a file, or the special values "System.out" and "System.err". Default is "System.err". example - /Users/name/Documents/project-name/.../log-file-name.xml
# org.slf4j.simpleLogger.logFile=
# - If the output target is set to "System.out" or "System.err" (see preceding entry), by default, logs will be output to the latest value referenced by System.out/err variables. By setting this parameter to true, the output stream will be cached, i.e. assigned once at initialization time and re-used independently of the current value referenced by System.out/err.
# org.slf4j.simpleLogger.cacheOutputStream 
# - Default log level for all instances of SimpleLogger. Must be one of ("trace", "debug", "info", "warn", "error" or "off"). If not specified, defaults to "info".
# org.slf4j.simpleLogger.defaultLogLevel 
# - Logging detail level for a SimpleLogger instance named "a.b.c". Right-side value must be one of "trace", "debug", "info", "warn", "error" or "off". When a SimpleLogger named "a.b.c" is initialized, its level is assigned from this property. If unspecified, the level of nearest parent logger will be used, and if none is set, then the value specified by org.slf4j.simpleLogger.defaultLogLevel will be used.
# org.slf4j.simpleLogger.log.a.b.c 
# - Set to true if you want the current date and time to be included in output messages. Default is false
# org.slf4j.simpleLogger.showDateTime=true
# - The date and time format to be used in the output messages. The pattern describing the date and time format is defined by SimpleDateFormat. If the format is not specified or is invalid, the number of milliseconds since start up will be output.
# org.slf4j.simpleLogger.dateTimeFormat=yyyy-MM-dd HH:mm:ss:SSS Z
# -Set to true if you want to output the current thread name. Defaults to true.
# org.slf4j.simpleLogger.showThreadName=true
# - Set to true if you want the Logger instance name to be included in output messages. Defaults to true.
# org.slf4j.simpleLogger.showLogName=true
# - Set to true if you want the last component of the name to be included in output messages. Defaults to false.
# org.slf4j.simpleLogger.showShortLogName 
# - Should the level string be output in brackets? Defaults to false.
# org.slf4j.simpleLogger.levelInBrackets=true 
# - The string value output for the warn level. Defaults to WARN.
# org.slf4j.simpleLogger.warnLevelString 
```