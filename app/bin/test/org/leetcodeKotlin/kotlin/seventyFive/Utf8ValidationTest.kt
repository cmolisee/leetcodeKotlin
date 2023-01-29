package org.leetcodeKotlin.kotlin.seventyFive

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

class Utf8ValidationTest {
    private val utf8Validation = Utf8Validation()

    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(intArrayOf(197,130,1), true),
            Arguments.of(intArrayOf(235,140,4), false),
            Arguments.of(intArrayOf(255), true),
        )
    }
    
    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `UTF-8 Validation`(input: IntArray, expected: Boolean) {
        assertEquals(expected, utf8Validation(input))
    }
}