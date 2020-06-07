package com.ktz.sh.sort.insert;

import com.ktz.sh.sort.SortTestHelper;

/**
 * @ClassName : InsertSort
 * @Description :插入排序  对于一个近乎有序的数组  插入排序的效率非常高
 * @Author : kaituozhesh
 * @Date: 2020-06-07 16:29
 * @Version: 1.0.0
 */
public class InsertSort {
    public static void main(String[] args) {
//        Integer[] array = SortTestHelper.generateRandomArray(10000, 0, 10000);
        // 生成一个近乎有序的数组
        Integer[] array = SortTestHelper.generateArray(10000, 100);
        SortTestHelper.testSort("com.ktz.sh.sort.insert.InsertSort", array, "sort4");
        SortTestHelper.printArray(array);
    }

    /**
     * 方法一
     */
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素arr[i]合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 优化一
     */
    public static void sort2(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 优化二  记录元素要的位置
     */
    public static void sort3(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index].compareTo(temp) > 0) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = temp;
        }
    }

    /**
     * 优化三  简化二 的写法
     */
    public static void sort4(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 对 arr[l...r]的区间使用insertSort排序
     */
    public static void insertSort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i < r; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }

    }

}
