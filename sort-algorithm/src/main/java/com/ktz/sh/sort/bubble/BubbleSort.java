package com.ktz.sh.sort.bubble;

import com.ktz.sh.sort.SortTestHelper;

/**
 * @ClassName : BubbleSort
 * @Description :冒泡排序
 * @Author : kaituozhesh
 * @Date: 2020-06-07 17:24
 * @Version: 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {

        Integer[] array = SortTestHelper.generateRandomArray(10000, 0, 10000);
        SortTestHelper.testSort("com.ktz.sh.sort.bubble.BubbleSort", array, "sort");
        SortTestHelper.printArray(array);

    }

    /**
     * 方法一
     */
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    SortTestHelper.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化一 ： 当一轮比较没有发生变化时，表示数组已经有序
     *
     * @param arr
     */
    public static void sort2(Comparable[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    flag = false;
                    SortTestHelper.swap(arr, j, j + 1);
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    /**
     * 优化二： 简化一的写法
     */
    public static void sort3(Comparable[] arr) {
        int length = arr.length;
        boolean flag;
        do {
            flag = false;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swap(arr, i - 1, i);
                    flag = true;
                }
            }
            length--;
        } while (flag);
    }

    /**
     * 优化三  记录最后一次变更的位置
     */
    public static void sort4(Comparable[] arr) {
        int length = arr.length;
        int num;
        do {
            num = 0;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swap(arr, i - 1, i);
                    num = i;
                }
            }
            length = num;
        } while (num > 0);
    }


}
