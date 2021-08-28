package cn.mofada.algo.kotlin._08_stack

import com.sun.org.apache.bcel.internal.generic.NEW

class StackBaseOnLinked {
    private var top: Node? = null

    fun push(value: Int) {
        val newNode = Node(value, null)
        //判断是否栈空
        if (top == null) {
            top = newNode
        } else {
            newNode.next = top
            top = newNode
        }
    }

    fun pop(): Int {
        if (top == null) return -1

        val value = top!!.data
        top = top!!.next
        return value
    }

}

data class Node(val data: Int, var next: Node?)