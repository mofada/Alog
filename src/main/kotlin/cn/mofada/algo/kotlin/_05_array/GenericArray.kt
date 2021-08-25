package cn.mofada.algo.kotlin._05_array

import cn.mofada.algo.java._05_array.GenericArray
import kotlin.Array as KArray

/**
 *
 */
class GenericArray<T>(private val capacity: Int) {
    /**
     * 根据传入容量构造Array
     */
    constructor() : this(10)

    private var data = arrayOfNulls<Any>(capacity)

    private var size = 0

    /**
     * 获取数组容量
     */
    fun capacity() = data.size

    /**
     * 获取当前元素个数
     */
    fun getCount() = size

    /**
     * 判断数组是否为空
     */
    fun isEmpty() = size == 0

    /**
     * 修改index位置的元素
     */
    fun set(index: Int, element: T) {
        checkIndex(index)

        data[index] = element
    }

    /**
     * 获取指定位置的元素
     */
    fun get(index: Int): T? {
        checkIndex(index)

        return data[index] as T?
    }

    /**
     * 检查数组是否包含
     */
    fun contains(element: T): Boolean {
        for (datum in data) {
            if (element == datum) return true
        }

        return false
    }

    /**
     * 查找元素对应的位置,如果没有则返回-1
     */
    fun find(element: T): Int {
        for (i in data.indices) {
            if (element == data[i]) return i
        }
        return -1
    }

    /**
     * 在指定位置插入元素
     */
    fun add(index: Int, element: T) {
        checkIndexAdd(index)

        if (size == data.size) {
            //需要扩容
            resize(size + (size shr 1))
        }

        //搬移数据
        for (i in (size - 1) downTo index) {
            data[i + 1] = data[i]
        }

        data[index] = element

        size++
    }

    /**
     * 添加元素到数组头
     */
    fun addFirst(element: T) {
        add(0, element)
    }

    /**
     * 添加元素到数组尾
     */
    fun addLast(element: T) {
        add(size, element)
    }

    /**
     * 删除指定位置的元素并返回
     */
    fun remove(index: Int): T? {
        checkIndex(index)

        val ret = data[index] as T?

        for (i in index until size) {
            data[i] = data[i + 1]
        }

        size--

        data[size] = null

        //缩容
        if (size == data.size / 2 && data.size / 2 != 0) {
            resize(data.size / 2)
        }

        return ret
    }

    /**
     * 移除第一个元素
     */
    fun removeFirst() = remove(0)

    /**
     * 移除最后一个
     */
    fun removeLast() = remove(size - 1)

    /**
     * 移除指定元素
     */
    fun removeElement(element: T) {
        find(element).takeIf { it != -1 }?.also { remove(it) }
    }


    /**
     * 数组容量调整
     */
    private fun resize(capacity: Int) {
        val newData = KArray(capacity) {
            //创建的同时并赋值
            if (it < size) {
                return@KArray data[it]
            } else {
                return@KArray null
            }
        }

        data = newData
    }

    /**
     * 检查数组的下标
     */
    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) throw IllegalArgumentException("数组序号" + index + "不合法")
    }

    private fun checkIndexAdd(index: Int) {
        if (index < 0 || index > size) throw IllegalArgumentException("数组序号" + index + "不合法")
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Array size = $size, capacity = ${data.size}, \n")
        builder.append("[")
        for (index in data.indices) {
            builder.append(data[index])

            if (index != data.lastIndex) {
                builder.append(",")
            }
        }
        builder.append("]")

        return builder.toString()
    }
}

fun main() {
    // 这里测试所以用的int类型
    // 如果数据用于存储基本数据类型，建议使用数组，不适用列表
    // 因为每次会进行Autoboxing和Unboxing
    val array = GenericArray<Int>(10)

    array.add(0, 15)
    array.add(0, 0)
    array.add(1, 8)
    array.add(2, 9)
    array.add(3, 1)
    array.add(3, 5)
    array.add(3, 2)
    array.add(3, 8)
    array.add(3, 4)
    array.add(3, 5)
    array.add(3, 9)
    array.add(3, 4)

//    array.remove(0)
//    array.remove(0)
//    array.remove(0)
//    array.remove(0)
//    array.remove(0)

    println(array)
}