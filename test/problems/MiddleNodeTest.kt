
package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.cmolisee.problems.utils.ListNode
import org.cmolisee.problems.utils.assertLinkedList

class middleNode {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(ListNode.from(3,4,5), ListNode.from(1,2,3,4,5)),
            Arguments.of(ListNode.from(4,5,6), ListNode.from(1,2,3,4,5,6)),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `middleNode`(expected: ListNode, input: ListNode) {
        assertLinkedList(expected, middleNode(input))
    }
}
