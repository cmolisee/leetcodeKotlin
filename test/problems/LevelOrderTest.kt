package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class levelOrder {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(true, true),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test levelOrder`(expected: Boolean, input: Boolean) {
        testIsEqual(expected, levelOrder(input))
    }
}
