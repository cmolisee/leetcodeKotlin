package org.cmolisee.problems.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun from(arr: IntArray): ListNode {
            val node = ListNode(arr[0])
            if (arr.size == 1) return node

            var current = node
            for (i in 1..arr.lastIndex) {
                current.next = ListNode(arr[i])
                current = current.next!!
            }

            return node
        }

        fun from(value: Int, vararg others: Int): ListNode {
            return from(intArrayOf(value, *others.toTypedArray().toIntArray()))
        }
    }
}