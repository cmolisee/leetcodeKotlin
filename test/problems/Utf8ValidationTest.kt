package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

class Utf8ValidationTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(true, intArrayOf(197,130,1)),
            Arguments.of(false, intArrayOf(235,140,4)),
            Arguments.of(false, intArrayOf(255)),
        )
    }
    
    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `UTF-8 Validation`(expected: Boolean, input: IntArray) {
        assertEquals(expected, validUtf8(input))
    }
}