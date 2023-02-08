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
    
    // using fast/slow
    // MATH:
    // assume X is the distance from 0 to the start of the cycle
    // assume Y is the distance from X to the intersection of fast and slow
    // assume Z is the distance from Y to the tail
    // 
    // slow = x + y and fast = x + y + z + y or x + 2y + z
    // Since fast is 2 times slow we can multiply slow by 2
    // 2x + 2y = x + 2y + z -> x = z
    // since x == z we know that once we find the intersection
    //    if we restart from the head and from the point of intersection and step
    //    by 1, then the next intersection will be at the end of X (or the start 
    //    of Y) - which is the start of the cycle.
    // <----X----><--y--><----Z---->
    //
    // thus, we run a fast/slow loop from head to get to intersect at the 
    // start of Z. Then we run a slow/slow loop from head and the intersection
    // point to get to Y - the start of the cycle.
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) break
    }

    if (fast?.next == null || slow == null || slow.next == null) return null
    
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
