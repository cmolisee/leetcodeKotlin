
package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.cmolisee.problems.utils.ListNode
import org.cmolisee.problems.utils.testIsEqual

class detectCycle {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(2, ListNode.fromWithLoop(1,3,2,0,-4)),
            Arguments.of(1, ListNode.fromWithLoop(0,1,2)),
            Arguments.of(null, ListNode.from(1)),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test detectCycle`(expected: Int?, input: ListNode?) {
        val res = detectCycle(input)
        println(res.toString())

        testIsEqual(expected, detectCycle(input)?.`val`)
    }
}
