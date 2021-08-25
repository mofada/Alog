package cn.mofada.algo.kotlin._07_linked_list

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

            if(slow == fast) return true
        }

        return false
    }
}

data class Node<T>(var data: T, var next: Node<T>?)