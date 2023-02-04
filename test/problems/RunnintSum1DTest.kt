package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertContentEquals

class RunningSum1DTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(intArrayOf(1,3,6,10), intArrayOf(1,2,3,4)),
            Arguments.of(intArrayOf(1,2,3,4,5), intArrayOf(1,1,1,1,1)),
            Arguments.of(intArrayOf(3,4,6,16,17), intArrayOf(3,1,2,10,1))
        )
    }
    
    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Running sum for 1D IntArray`(expected: IntArray, input: IntArray) {
        assertContentEquals(expected, runningSum(input))
    }
}