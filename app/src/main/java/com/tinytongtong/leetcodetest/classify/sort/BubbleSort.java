package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Author wangjianzhou
 * @Date 2022/2/13 12:36 PM
 * @Version
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 3, 2, 1};
//        int[] array = new int[]{6,5,4,3,2,1};
        int n = 6;
        System.out.println(Arrays.toString(array));
        bubbleSort(array, n);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序-将较大的数放到后面。
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            // 提前退出冒泡排序的标记位，当数据全部有序时，就不再需要排序了。
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) { // swap
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) { // 数据已全部有序，不再需要排序了。
                break;
            }
        }
    }
}
