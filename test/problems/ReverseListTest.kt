
package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.cmolisee.problems.utils.ListNode
import org.cmolisee.problems.utils.testLinkedListIsEqual

class reverseList {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(ListNode.from(3,2,1), ListNode.from(1,2,3)),
            Arguments.of(ListNode.from(5,4,3,2,1), ListNode.from(1,2,3,4,5)),
            Arguments.of(ListNode.from(3,2), ListNode.from(2,3)),
            Arguments.of(null, null),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Test reverseList`(expected: ListNode?, input: ListNode?) {
        testLinkedListIsEqual(expected, reverseList(input))
    }
}
