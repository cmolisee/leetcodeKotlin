package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class longestPalindrome {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(9, "abccccddeee"),
            Arguments.of(7, "abccccdd"),
            Arguments.of(1, "a"),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test longestPalindrome`(expected: Int, input: String) {
        testIsEqual(expected, longestPalindrome(input))
    }
}
