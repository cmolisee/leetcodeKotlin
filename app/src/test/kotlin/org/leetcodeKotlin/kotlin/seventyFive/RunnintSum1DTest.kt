package org.leetcodeKotlin.kotlin.seventyFive

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertContentEquals

class RunningSum1DTest {
    private val runningSum1D = RunningSum1D()

    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(intArrayOf(1,2,3,4), intArrayOf(1,3,6,10)),
            Arguments.of(intArrayOf(1,1,1,1,1), intArrayOf(1,2,3,4,5)),
            Arguments.of(intArrayOf(3,1,2,10,1), intArrayOf(3,4,6,16,17))
        )
    }
    
    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `Running sum for 1D IntArray`(input: IntArray, expected: IntArray) {
        assertContentEquals(expected, runningSum1D(input))
    }
}