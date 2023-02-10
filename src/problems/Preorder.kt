package org.cmolisee.problems

import org.cmolisee.problems.utils.testIsEqual
import org.cmolisee.problems.utils.Node

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal. Each group of 
 * children is separated by the null value (See examples)
 */
fun preorder(root: Node?): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    recurse(root, result)
    return result
}

private fun recurse(root: Node?, result: MutableList<Int>) {
    if (root == null) return

    result.add(root.`val`)

    for (n in root.children) {
        recurse(n, result)
    }
}

fun main() {
    run {
        // finish when Node.from() is implemented
    }
}
