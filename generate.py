import sys
import os

filePath = './src/problems/'
testPath = './test/problems/'

GREEN = "\u001B[32m"
RED = "\u001B[31m"
WHITE = "\u001B[37m"

content = """
package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsEqual

fun FILE_NAME(input: String): String {
    return "expected"
}

fun main() {
    run {
        testIsEqual("expected", FILE_NAME(), "message")
    }
}
"""

testContent = """
package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class FILE_NAME {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(true, true),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test FILE_NAME`(expected: Boolean, input: Boolean) {
        testIsEqual(expected, FILE_NAME(input))
    }
}
"""

def getFileName(s):
    return s[0].upper() + s[1:]

if not sys.argv[1]:
    print(RED + "ERROR: Must provide file name in camel case (i.e. myNewFile)" + WHITE)
    exit()

if os.path.exists(filePath + getFileName(sys.argv[1]) + ".kt"):
    print(RED + "ERROR: File already exists" + WHITE)
    exit()

with open(filePath + getFileName(sys.argv[1]) + ".kt", 'w') as f:
    f.write(content.replace("FILE_NAME", sys.argv[1]))

print(GREEN + "SUCCESS: File created at " + testPath + getFileName(sys.argv[1]) + ".kt" + WHITE)


if len(sys.argv) < 3:
    if os.path.exists(testPath + getFileName(sys.argv[1]) + ".kt"):
        print(RED + "ERROR: File already exists" + WHITE)
        exit()

    with open(testPath + getFileName(sys.argv[1]) + "Test.kt", 'w') as f:
        f.write(testContent.replace("FILE_NAME", sys.argv[1]))

    print(GREEN + "SUCCESS: Test file created at" + filePath + getFileName(sys.argv[1]) + "Test.kt" + WHITE)

exit()