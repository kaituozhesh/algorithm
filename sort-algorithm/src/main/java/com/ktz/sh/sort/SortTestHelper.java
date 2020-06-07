package com.ktz.sh.sort;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

public class SortTestHelper {

    /**
     * 生成有n个元素的随机数组，每个元素的随机范围为[rangeL，rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = Stream.generate(() -> (int) (Math.random() * (rangeR - rangeL + 1) + rangeL)).limit(n).toArray(Integer[]::new);
        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     */
    public static Integer[] generateArray(int n, int random) {
        Integer[] arr = Stream.iterate(0, (x) -> x + 1).limit(n).toArray(Integer[]::new);
        for (int i = 0; i < random; i++) {
            int x = (int) (Math.random() * n);
            int y = (int) (Math.random() * n);
            Integer temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        return arr;
    }


    public static void printArray(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void testSort(String sortClassName, Comparable[] arr, String methodName) {
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod(methodName, new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};
            Instant start = Instant.now();
            sortMethod.invoke(null, params);
            Instant end = Instant.now();
            System.out.println(isSorted(arr));
            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + " : " + (Duration.between(start, end).getNano() / 100000000.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
