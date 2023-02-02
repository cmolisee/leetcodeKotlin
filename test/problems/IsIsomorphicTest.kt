package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

class IsIsomorphicTest {
    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(Pair("egg", "add"), true),
            Arguments.of(Pair("foo", "bar"), false),
            Arguments.of(Pair("paper", "title"), true),
            Arguments.of(Pair("bbbaaaba", "aaabbbba"), false),
        )
    }
    

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `Is Isomorphic`(input: Pair<String, String>, expected: Boolean) {
        assertEquals(expected, isIsomorphic(input.first, input.second))
    }
}