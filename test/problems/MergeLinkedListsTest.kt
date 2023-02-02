package org.cmolisee.problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kotlin.test.assertEquals

import org.cmolisee.problems.utils.ListNode

class MergeLinkedListsTest {
    // Arguments.of(input, expected)
    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(
                Pair(ListNode.from(1,2,4), ListNode.from(1,3,4)),
                ListNode.from(1,1,2,3,4,4)
            ),
            Arguments.of(
                Pair(null, ListNode.from(0)),
                ListNode.from(0)
            ),
            Arguments.of(
                Pair(ListNode.from(2), ListNode.from(1)),
                ListNode.from(1,2)
            ),
        )
    }
    

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("args")
    fun `Merge Two Linked Lists`(input: Pair<ListNode?, ListNode?>, expected: ListNode) {
        recursiveAssert(expected, mergeTwoLists(input.first, input.second))
    }

    fun recursiveAssert(expected: ListNode?, actual: ListNode?) {
        assertEquals(expected?.`val`, actual?.`val`)

        if (expected?.next != null && actual?.next != null) {
            recursiveAssert(expected.next, actual.next)
        } else if (expected?.next != null || actual?.next != null) {
            throw Exception("MergeLinkedListsTest: ${expected} or ${actual} has no next value")
        }

        return
    }
}