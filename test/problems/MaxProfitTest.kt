package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class maxProfit {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(5, intArrayOf(7,1,5,3,6,4)),
            Arguments.of(0, intArrayOf(7,6,4,3,1))
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test maxProfit`(expected: Int, input: IntArray) {
        testIsEqual(expected, maxProfit(input))
    }
}
