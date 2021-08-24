package cn.mofada.algo.java._05_array;

import org.junit.jupiter.api.Test;

public class GenericArrayTest {
    @Test
    public void add() {
        // 这里测试所以用的int类型
        // 如果数据用于存储基本数据类型，建议使用数组，不适用列表
        // 因为每次会进行Autoboxing和Unboxing
        GenericArray<Integer> array = new GenericArray<Integer>(10);

        array.add(0, 5);
        array.add(0, 0);
        array.add(1, 8);
        array.add(2, 9);
        array.add(3, 1);
        array.add(3, 5);
        array.add(3, 2);
        array.add(3, 8);
        array.add(3, 4);
        array.add(3, 5);
        array.add(3, 9);
        array.add(3, 4);

        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);
        array.remove(0);

        System.out.println(array);
    }
}
