package org.leetcodeKotlin.kotlin.seventyFive

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

class PivotIndexTest {
    private val pivotIndex = PivotIndex()

    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(intArrayOf(1,2,3), -1),
            Arguments.of(intArrayOf(2,1,-1), 0),
            Arguments.of(intArrayOf(1,7,3,6,5,6), 3),
            Arguments.of(intArrayOf(-1,-1,0,0,-1,-1), 2)
        )
    }
    

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `Pivot Index`(input: IntArray, expected: Int) {
        assertEquals(expected, pivotIndex(input))
    }
}