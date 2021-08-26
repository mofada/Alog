package cn.mofada.algo.kotlin._07_linked_list

import com.sun.corba.se.spi.orbutil.fsm.FSM

/**
 * 1)单链表反转
 * 2)链表中换的检测
 * 3)两个有序链表合并
 * 4)删除链表倒数第n个节点
 * 5)求链表的中间节点
 * //todo 链表太难了吧,先看后面的
 */
object LinkedList {
    /**
     * 单链表反转
     */
    fun <T> reverse(list: Node<T>?): Node<T>? {
        var current = list
        var previous: Node<T>? = null

        while (current != null) {
            //首先把下一个的值拿出来
            val next = current.next
            //然后把当前的next的指向上一个
            current.next = previous
            //把当前赋值给上一个,在这里换位置
            previous = current
            //当前的换到下一个的值,这里就完成了位置交换
            current = next
        }

        return previous
    }

    /**
     * 检测环
     */
    fun <T> checkCircle(list: Node<T>?): Boolean {
        if (list == null) return false

        var fast = list.next
        var slow = list

        while (fast != null && slow != null) {
            fast = fast.next?.next
            slow = slow.next

            if (slow == fast) return true
        }

        return false
    }

    /**
     * 有序列表合并
     */
//    fun <T> mergeTwoLists(l1: Node<T>?, l2: Node<T>?): Node<T> {
//        // 利用哨兵结点简化实现难度
//        var soldier = Node<T>(null, null)
//        var p = soldier
//
//        while (l1 != null && l2 != null) {
//            if (l1.data < l2.data) {
//
//            }
//        }
//    }

    /**
     * 删除倒数第k个节点
     */
    fun <T> deleteLastKth(list: Node<T>, k: Int): Node<T>? {
        var result: Node<T>? = null

        var fast: Node<T>? = list
        var i = 1

        //首先循环,找到节点k所在位置
        while (fast != null && i < k) {
            fast = fast.next;
            i++
        }

        // 如果fast为空,说明k是尾节点
        if (fast == null) return list

        var slow: Node<T>? = list
        var previous: Node<T>? = null

        while (fast?.next != null) {
            fast = fast.next
            previous = slow
            slow = slow?.next
        }

        if (previous == null) {
            result = list.next
        } else {
            previous.next = previous.next?.next
        }

        return result
    }

    /**
     * 查找中间节点
     */
    fun <T> findMiddleNode(list: Node<T>): Node<T>? {
        var fast: Node<T>? = null
        var slow: Node<T>? = null

        while (fast != null && slow != null) {
            fast = fast.next?.next
            slow = slow.next?.next
        }

        return slow
    }
}

data class Node<T>(var data: T?, var next: Node<T>?)