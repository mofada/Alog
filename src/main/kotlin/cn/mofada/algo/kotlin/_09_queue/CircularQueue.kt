package cn.mofada.algo.kotlin._09_queue

class CircularQueue(val capacity: Int) {
    /**
     * 定义一个数组
     */
    private val items: Array<String> = Array(capacity) { "" }

    private var head: Int = 0
    private var tail: Int = 0

    fun enqueue(item: String): Boolean {
        //队列满了
        if ((tail + 1) % items.size == head) return false

        items[tail] = item
        //整数x对整数y取余得到的结果是0~y-1的整数
        tail = (tail + 1) % items.size
        return true
    }

    fun dequeue(): String? {
        //如果head == null 表示队列空
        if (head == tail) return null
        val ret = items[head]
        head = (head + 1) % items.size
        return ret
    }
}

fun main() {
    val circularQueue = CircularQueue(5)
    circularQueue.enqueue("1")
    circularQueue.enqueue("2")
    circularQueue.enqueue("3")
    circularQueue.enqueue("4")
    circularQueue.enqueue("5")
    circularQueue.enqueue("6")

    val dequeue = circularQueue.dequeue()
    println(dequeue)
    val dequeue1 = circularQueue.dequeue()
    println(dequeue1)
    val dequeue2 = circularQueue.dequeue()
    println(dequeue2)
}