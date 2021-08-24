package cn.mofada.algo.java._05_array;

/**
 * 1、数组的插入、删除、按照下标随机访问操作
 * 2、数组的数据类型是int
 */
public class Array {
    /**
     * 定义数据data用于保存数据
     */
    public int[] data;

    /**
     * 定义数组中的实际个数
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        //初始时没有数据，所以为null
        this.count = 0;
    }

    /**
     * 根据索引，找到数据中的元素并返回
     *
     * @param index
     * @return
     */
    public int find(int index) {
        checkIndex(index);

        return data[index];
    }

    /**
     * 插入元素: 头部插入,尾部插入
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //数组空间已满
        if (count == data.length) {
            //数组已满，需要扩容
            System.out.println("数组已满，无法插入");
            return false;
        }

        //数组count还没满，那么可以插入元素

        //位置不合法
        checkIndexInsert(index);

        //位置合法,开始搬移数据
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        //赋值
        data[index] = value;
        //数量增加
        count++;

        return true;
    }

    /**
     * 根据索引,删除指定元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        checkIndex(index);

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }

        count--;
        return true;
    }

    /**
     * 下标检查
     *
     * @param index
     */
    public void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    /**
     * 插入时的下标检查
     *
     * @param index
     */
    public void checkIndexInsert(int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    /**
     * 打印数组
     */
    public void printAll() {
        for (int datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);

        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);

        array.printAll();
    }
}
