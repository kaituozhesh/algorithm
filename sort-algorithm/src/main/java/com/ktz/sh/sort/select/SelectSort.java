package com.ktz.sh.sort.select;

import com.ktz.sh.sort.SortTestHelper;

/**
 * @ClassName : SelectSort
 * @Description : 选择排序  每次选择一个最小（大）的元素放到排序号的元素后面
 * @Author : kaituozhesh
 * @Date: 2020-06-07 15:42
 * @Version: 1.0.0
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateRandomArray(10000, 0, 10000);
        SortTestHelper.testSort("com.ktz.sh.sort.select.SelectSort", array, "method2");
        SortTestHelper.printArray(array);
    }

    /**
     * 方法一
     */
    public static void method1(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            // 寻找[i, n)区间里的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[index]) < 0) {
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    /**
     * 方法二 ： 每次都找出最小值和最大值
     */
    public static void method2(Comparable[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时，要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }
            // 每轮都寻找出一个最小值和最大值
            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }

    /**
     * 元素交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Object arr[], int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
