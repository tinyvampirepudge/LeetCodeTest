package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author wangjianzhou
 * @Date 2022/2/13 11:06 PM
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 3, 2, 1};
//        int[] array = new int[]{6,5,4,3,2,1};
        int n = 6;
        System.out.println(Arrays.toString(array));
        insertionSort(array, n);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * @param a
     * @param n
     */
    private static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 未排序数组
        for (int i = 1; i < n; i++) {
            // 从后向前遍历已排序数组
            int value = a[i];
            int j = i - 1; // 排序数组最后一个元素
            for (; j >= 0; j--) {
                if (value > a[j]) { // 移动数据
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
