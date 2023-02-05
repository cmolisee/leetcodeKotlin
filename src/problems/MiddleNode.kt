
package org.cmolisee.problems

import org.cmolisee.problems.utils.assertLinkedListEquals
import org.cmolisee.problems.utils.ListNode

fun middleNode(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow
}

fun main() {
    run {
        assertLinkedListEquals(ListNode(3), middleNode(ListNode.from(1,2,3,4,5)))
    }
}
