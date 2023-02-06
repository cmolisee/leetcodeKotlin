package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class IsIsomorphicTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(true, Pair("egg", "add")),
            Arguments.of(false, Pair("foo", "bar")),
            Arguments.of(true, Pair("paper", "title")),
            Arguments.of(false, Pair("bbbaaaba", "aaabbbba")),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test isIsomorphic`(expected: Boolean, input: Pair<String, String>) {
        testIsEqual(expected, isIsomorphic(input.first, input.second))
    }
}