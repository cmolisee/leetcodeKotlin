package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.cmolisee.problems.utils.ListNode
import org.cmolisee.problems.utils.assertLinkedList

class MergeLinkedListsTest {
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                ListNode.from(1,1,2,3,4,4),
                Pair(ListNode.from(1,2,4), ListNode.from(1,3,4)),
            ),
            Arguments.of(
                ListNode.from(0),
                Pair(null, ListNode.from(0)),
            ),
            Arguments.of(
                ListNode.from(1,2),
                Pair(ListNode.from(2), ListNode.from(1)),
            ),
        )
    }
    

    @ParameterizedTest(name = "{1} should return {0}")
    @MethodSource("args")
    fun `Merge Two Linked Lists`(expected: ListNode, input: Pair<ListNode?, ListNode?>) {
        assertLinkedList(expected, mergeTwoLists(input.first, input.second))
    }
}