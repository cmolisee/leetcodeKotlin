package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsEqual
import org.cmolisee.problems.utils.ListNode

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by 
 * continuously following the next pointer. Internally, pos is used to denote the index of the node that 
 * tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not 
 * passed as a parameter.
 * Do not modify the linked list.
 */
fun detectCycle(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return null

    var slow = head
    var fast = head
    
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) break
    }

    if (slow == null || slow.next == null) return null
    
    slow = head
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}

fun main() {
    run {
        testIsEqual(2, detectCycle(ListNode.fromWithLoop(1,3,2,0,-4))?.`val`)
    }
}
