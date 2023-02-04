package org.cmolisee.problems

import org.cmolisee.problems.utils.assertLinkedListEquals
import org.cmolisee.problems.utils.ListNode

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head
    var stack: MutableList<ListNode> = mutableListOf()

    var node: ListNode? = head
    while (node != null) {
        stack.add(node)
        node = node.next
    }

    stack.asReversed().forEachIndexed { index, value -> 
        value.next = stack.getOrNull(stack.lastIndex - (index + 1))
    }

    return stack.last()
}

fun main() {
    run {
        assertLinkedListEquals(ListNode.from(3,2,1), reverseList(ListNode.from(1,2,3)))
    }
}
