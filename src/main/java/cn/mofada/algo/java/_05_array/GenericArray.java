package cn.mofada.algo.java._05_array;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] data;
    private int size;

    /**
     * 根据传入容量,构造Array
     *
     * @param capacity
     */
    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造方法
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改index位置的元素
     * O(1)
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        checkIndex(index);

        data[index] = e;
    }

    /**
     * 获取index位置的元素
     * O(1)
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);

        return data[index];
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (T datum : data) {
            if (datum.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据元素查找下标,未找到 : -1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 在index位置插入元素e
     * 时间复杂度O(n)
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexAdd(index);

        // 需要扩容
        if (size == data.length) {
            resize(data.length + (data.length >> 1));
        }

        //搬移数据
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    /**
     * 向数组头添加元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组尾添加元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除指定位置的元素并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        //数位置空
        data[size] = null;

        //缩容
        if (size == data.length / 2 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 移除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 移除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) remove(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d,\n", size, data.length));
        builder.append("[");

        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            if (i != data.length - 1) {
                builder.append(",");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    /**
     * 扩容方法,时间复杂度O(n)
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        //数据搬移
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组序号" + index + "不合法");
        }
    }

    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组序号" + index + "不合法");
        }
    }
}
