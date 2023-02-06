package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class IsSubsequenceTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(false, Pair("axc", "ahbgdc")),
            Arguments.of(true, Pair("abc", "ahbgdc")),
            Arguments.of(true, Pair("", "")),
            Arguments.of(true, Pair("", "abcdefg")),
            Arguments.of(false, Pair("abc", "")),
            Arguments.of(false, Pair("bb", "abcddei")),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test isSubsequence`(expected: Boolean, input: Pair<String, String>) {
        testIsEqual(expected, isSubsequence(input.first, input.second))
    }
}