package cn.mofada.algo.kotlin._11_sorts

import kotlin.math.min

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
}

fun main() {
    val array = arrayOf(5, 7, 1, 9, 2, 3, 4, 5, 6)

    Sorts.selectionSort(array)

    println(array.joinToString(","))
}