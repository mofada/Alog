package cn.mofada.algo.kotlin._05_array

import kotlin.Array as KArray

/**
 * 1、数组的插入、删除、按照下标随机访问操作
 * 2、数组的数据类型是int
 */
class Array<T>(capacity: Int) {
    /**
     * 定义数据data用于保存数据
     */
    private val data: KArray<Any?> = arrayOfNulls<Any?>(capacity)

    /**
     * 数组的实际个数
     */
    private var count: Int = 0

    /**
     * 根据数组下标查找元素
     */
    fun find(index: Int): T {
        checkIndex(index)

        return data[index] as T
    }

    /**
     *
     */
    fun insert(index: Int = count, value: T): Boolean {
        checkIndexInsert(index)

        //判断容量是否已满
        if (count == data.size) {
            println("数组已满")
            return false
        }

        //搬移数据
        for (i in count downTo index + 1) {
            data[i] = data[i - 1]
        }

        //数据存入
        data[index] = value
        //数量加一
        count++

        return true
    }

    /**
     * 删除指定下标的元素
     */
    fun delete(index: Int): Boolean {
        checkIndex(index)

        for (i in (index + 1)..count) {
            data[i - 1] = data[i]
        }
        count--

        return true
    }

    /**
     * 检查数组的下标
     */
    private fun checkIndex(index: Int) {
        if (index < 0 || index >= count) throw  ArrayIndexOutOfBoundsException(index)
    }

    /**
     * 检查插入的下标
     */
    private fun checkIndexInsert(index: Int) {
        if (index < 0 || index > count) throw  ArrayIndexOutOfBoundsException(index)
    }

    /**
     * 打印数组
     */
    fun printAll() {
        for (datum in data) {
            print("$datum - ")
        }
        println()
    }
}

fun main() {
    val array = Array<Int>(5)

    array.insert(value = 5)
    array.insert(0, 0)
    array.insert(1, 8)
    array.insert(2, 9)
    array.delete(2)
    array.printAll()
}