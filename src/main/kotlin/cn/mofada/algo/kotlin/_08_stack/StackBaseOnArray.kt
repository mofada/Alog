package cn.mofada.algo.kotlin._08_stack

/**
 * 基于数组实现的顺序栈
 */
class StackBaseOnArray(capacity: Int) {
    val items: Array<String> = Array(capacity) { "" }
    var count: Int = 0

    /**
     * 入栈操作
     */
    fun push(item: String): Boolean {
        //数组容量超出
        if (count == items.size) {
            return false
        }

        //将item放到下标为count的位置,并且count加一
        items[count] = item

        count++

        return false
    }

    /**
     * 出栈操作
     */
    fun pop(): String? {
        //栈为空,直接返回null
        if (count == 0) return null

        //返回下标为count-1的数据,并且栈中元素个数减一
        val temp = items[count - 1]

        count--

        return temp
    }
}