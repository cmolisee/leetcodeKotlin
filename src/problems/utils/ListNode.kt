package org.cmolisee.problems.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    var tail: Boolean = false

    companion object {
        fun from(arr: IntArray): ListNode {
            val node = ListNode(arr[0])
            if (arr.size == 1) return node

            var current = node
            for (i in 1..arr.lastIndex) {
                current.next = ListNode(arr[i])
                current = current.next!!
            }

            current.tail = true

            return node
        }

        fun from(value: Int, vararg others: Int): ListNode {
            return from(intArrayOf(value, *others.toTypedArray().toIntArray()))
        }

        fun fromWithLoop(loopIndex: Int, vararg values: Int): ListNode {
            if (values.size <= 1) throw Exception("Must have 2 or more values to create a loop")
            if (loopIndex > values.size - 1) throw Exception("Provided loopIndex is not within range")

            val node = ListNode(values.first())

            var current = node
            var loopStart = if (loopIndex == 0) current else null
            for (i in 1..values.lastIndex) {
                current.next = ListNode(values[i])
                current = current.next!!

                if (loopIndex == i) loopStart = current
            }

            current.tail = true
            current.next = loopStart

            return node
        }
    }

    override fun toString(): String {
        return if (next != null && tail == false) {
            "$`val`, ${next.toString()}"
        } else {
            "$`val`"
        }
    }
}