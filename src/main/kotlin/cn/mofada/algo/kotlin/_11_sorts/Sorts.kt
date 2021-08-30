package cn.mofada.algo.kotlin._11_sorts

import kotlin.random.Random

/**
 * 冒泡排序、插入排序、选择排序
 */
object Sorts {
    /**
     * 冒泡排序
     * 空间复杂度：O(1),原地排序
     * 时间复杂度：最好情况O(n)，最坏情况O(n^2)，平均时间复杂度O(n^2)
     * 是一种稳定排序算法
     */
    fun bubbleSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) return array
        //提前退出标志
        var flag = false
        var temp: Int

        for (i in array.indices) {
            for (j in 0 until array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp

                    flag = false
                }
            }
            //如果上一次一整伦都没有交换，说明结束了
            if (flag) break
        }



        return array
    }

    /**
     * 插入排序
     * 空间复杂度：O(1),原地排序
     * 时间复杂度：最好情况O(n)，最坏情况O(n^2)，平均时间复杂度O(n^2)
     * 是一种稳定排序算法
     */
    fun insertionSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) return array

        for (i in array.indices) {
            val value = array[i]
            var j = i - 1

            while (j >= 0) {
                if (array[j] > value) {
                    //数据移动
                    array[j + 1] = array[j]
                } else {
                    break
                }

                j--
            }

            array[j + 1] = value
        }

        return array
    }

    /**
     * 选择排序
     * 空间复杂度：O(1),原地排序
     * 时间复杂度：最好情况O(n)，最坏情况O(n^2)，平均时间复杂度O(n^2)
     * 不是稳定排序算法
     */
    fun selectionSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) return array

        for (i in array.indices) {
            //查找最小值
            var minIndex = i

            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }

            //交换位置
            val tmp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = tmp
        }

        return array
    }

    /**
     * 归并排序
     * 空间复杂度：O(n),不是原地排序
     * 时间复杂度：O(n log n)
     * 不是稳定排序算法
     */
    fun mergeSort(array: Array<Int>, left: Int, right: Int) {
        if (left >= right) return

        //取中间点
        val q = (left + right) / 2

        mergeSort(array, left, q)
        mergeSort(array, q + 1, right)
        merge(array, left, q, right)
    }

    /**
     * 数据合并
     */
    private fun merge(array: Array<Int>, left: Int, q: Int, right: Int) {
        //创建左右的数组，+2是因为要放q和哨兵
        val arrayLeft = Array<Int>(q - left + 2) { 0 }
        //+1是因为只要放哨兵
        val arrayRight = Array<Int>(right - q + 1) { 0 }

        //左边数据数据放进去
        for (i in 0..q - left) {
            arrayLeft[i] = array[left + i]
        }
        //添加哨兵
        arrayLeft[q - left + 1] = Int.MAX_VALUE

        for (i in 0 until right - q) {
            arrayRight[i] = array[q + i + 1]
        }
        //添加哨兵
        arrayRight[right - q] = Int.MAX_VALUE

        // 左边数组的下标
        var i = 0
        //右边数组的下标
        var j = 0
        var k = left

        while (k <= right) {
            if (arrayLeft[i] <= arrayRight[j]) {
                array[k++] = arrayLeft[i++]
            } else {
                array[k++] = arrayRight[j++]
            }
        }
    }

    /**
     * 快速排序
     * 空间复杂度：O(n),是原地排序
     * 时间复杂度：O(n log n)
     * 不是稳定排序算法
     */
    fun quickSort(array: Array<Int>, left: Int, right: Int) {
        if (left >= right) return

        //取中间点
        val q = partition(array, left, right)
        quickSort(array, left, q - 1)
        quickSort(array, q + 1, right)
    }

    /**
     * 分区函数
     */
    fun partition(array: Array<Int>, left: Int, right: Int): Int {
        val middle = (left + right) / 2
        val pivot = array[middle]

        //交换到右边
        var tmp = array[right]
        array[right] = pivot
        array[middle] = tmp

        var i = left
        for (j in left until right) {
            if (array[j] < pivot) {
                if (i == j) {
                    i++
                } else {
                    tmp = array[i]
                    array[i++] = array[j]
                    array[j] = tmp
                }
            }
        }

        tmp = array[i]
        array[i] = array[right]
        array[right] = tmp

        return i
    }
}

fun main() {
    val random = Random(100)
    val array = Array(1000000) {
        random.nextInt(1000000)
    }
    val starter = System.currentTimeMillis()
    Sorts.mergeSort(array, 0, array.lastIndex)
//    Sorts.quickSort(array, 0, array.lastIndex)
//    Sorts.bubbleSort(array)
//    Sorts.selectionSort(array)
    val end = System.currentTimeMillis()

    println(array.joinToString("\n"))

    println()
    println((end - starter))

//    val array = arrayOf(6,11,3,9,8)
//    Sorts.quickSort(array, 0, array.size - 1)

//    println(array.joinToString("\n"))
}