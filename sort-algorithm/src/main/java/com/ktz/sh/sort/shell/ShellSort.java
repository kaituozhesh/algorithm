package com.ktz.sh.sort.shell;

/**
 * @ClassName ShellSort
 * @Description
 * @Author kaituozhesh
 * @Date 2020/6/8 16:12
 * @Version V1.0.0
 **/
public class ShellSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Comparable temp = arr[i];
                int j = i;
                for (; j >= h && temp.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }
            h /= 3;
        }
    }
}
