package cn.mofada.algo.kotlin._09_queue

/**
 * 用数组实现的队列
 */
class ArrayQueue(capacity: Int) {
    /**
     * 数组item
     */
    private val items = Array(capacity) { "" }

    /**
     * head表示队头
     */
    private var head: Int = 0

    /**
     * tail表示队尾
     */
    private var tail = 0

    fun enqueue(item: String): Boolean {
        //如果tail==items.size 表示队列已经满了
        if (tail == items.size) {
            //如果head==0,说明整个队列满了
            if (head == 0) return false

            //数据搬移
            for (i in head until tail) {
                items[i - head] = items[i]
            }

            tail -= head
            head = 0
        }
        items[tail] = item
        tail++
        return true
    }

    fun dequeue(): String? {
        //如果head==tail, 表示队列为空
        if (head == tail) return null

        val ret = items[head]

        head++

        return ret
    }
}

