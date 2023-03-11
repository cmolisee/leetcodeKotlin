
package org.cmolisee.problems

import org.cmolisee.problems.utils.testLinkedListIsEqual
import org.cmolisee.problems.utils.ListNode

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 *  Input: head = [1,2,3,4,5]
 *  Output: [3,4,5]
 *  Explanation: The middle node of the list is node 3.
 * Example 2:
 *  Input: head = [1,2,3,4,5,6]
 *  Output: [4,5,6]
 *  Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * Constraints:
 *  The number of nodes in the list is in the range [1, 100].
 *  1 <= Node.val <= 100
 */
fun middleNode(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
}

fun main() {
    run {
        testLinkedListIsEqual(ListNode.from(3,4,5), middleNode(ListNode.from(1,2,3,4,5)))
    }
}
