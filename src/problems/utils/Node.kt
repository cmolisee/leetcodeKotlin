package org.cmolisee.problems.utils

class Node(var `val`: Int) {
    var children: List<Node?> = emptyList()

    companion object {
        // implement to create n-ary tree from array (i.e. [1,null,2,3,4,null,2,3] )
    }

    override fun toString(): String {
        return if (children.isNotEmpty()) {
            "$`val`, ${children.forEach { it.toString() }}"
        } else {
            "$`val`"
        }
    }
}