package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

class IsSubsequenceTest {
    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(Pair("axc", "ahbgdc"), false),
            Arguments.of(Pair("abc", "ahbgdc"), true),
            Arguments.of(Pair("", ""), true),
            Arguments.of(Pair("", "abcdefg"), true),
            Arguments.of(Pair("abc", ""), false),
            Arguments.of(Pair("bb", "abcddei"), false),
        )
    }
    

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `Is Subsequence`(input: Pair<String, String>, expected: Boolean) {
        assertEquals(expected, isSubsequence(input.first, input.second))
    }
}