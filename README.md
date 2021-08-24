# 《数据结构与算法之美》笔记以及代码实现

## 05 数组

数组是一种`线性表`结构数据。它用一组`连续的内存空间`，来存储一组具有`相同类型的数据`。

- 实现一个支持动态扩容的数组

- 实现一个大小固定的有序数组，支持动态增删改操作

- 实现两个有序数组合并为一个有序数组

数组为什么从0开始计数呢？

> 数组寻址公式：a[k]_address = base_address + k * type_size  
> 如果从1开始就是：a[k]_address = base_address + (k-1)*type_size  
> 从0开始可以减少一次运算  
>
> 当然还有历史原因，C语言开始采用0，其他语言效仿了C，方便C语言开发者学习。

 需要注意的地方

- 数组插入时，使用for循环必须从后往前搬，否则将导致数据重复

```java
//搬移数据
for (int i = size - 1; i >= index; i--) {
    data[i + 1] = data[i];
}
```

- 数组删除时，搬移需要从前往后搬
```java
for (int i = index; i < size - 1; i++) {
    data[i] = data[i + 1];
}
```
  

  
