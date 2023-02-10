package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.cmolisee.problems.utils.testIsEqual

class preorder {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(true, true),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test preorder`(expected: Boolean, input: Boolean) {
        // create test when Node.from() is implemented
        // testIsEqual(expected, preorder(input))
    }
}
