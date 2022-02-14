package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author wangjianzhou
 * @Date 2022/2/13 11:41 PM
 * @Version
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 3, 2, 1};
//        int[] array = new int[]{6,5,4,3,2,1};
        int n = 6;
        System.out.println(Arrays.toString(array));
        selectionSort(array, n);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     *
     * @param a
     * @param n
     */
    private static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[index]) {
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }
}
