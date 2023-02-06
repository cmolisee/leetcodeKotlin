package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class PivotIndexTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(-1, intArrayOf(1,2,3)),
            Arguments.of(0, intArrayOf(2,1,-1)),
            Arguments.of(3, intArrayOf(1,7,3,6,5,6)),
            Arguments.of(2, intArrayOf(-1,-1,0,0,-1,-1))
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test pivotIndex`(expected: Int, input: IntArray) {
        testIsEqual(expected, pivotIndex(input))
    }
}