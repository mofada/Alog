package cn.mofada.algo.java._05_array;

import org.junit.jupiter.api.Test;

public class GenericArrayTest {
    @Test
    public void add() {
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
