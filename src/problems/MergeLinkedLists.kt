package org.cmolisee.problems

import org.cmolisee.problems.utils.ListNode
import org.cmolisee.problems.utils.testLinkedListIsEqual

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by 
 * splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    return if (list1.`val` <= list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }
}

fun main() {
    run {
        testLinkedListIsEqual(
            ListNode.from(1,1,2,3,3,4), 
            mergeTwoLists(ListNode.from(1,2,3), ListNode.from(1,3,4))
        )
    }
}