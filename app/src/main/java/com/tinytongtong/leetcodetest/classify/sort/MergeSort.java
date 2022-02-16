package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @Author wangjianzhou@qding.me
 * @Date 2/15/22 8:31 AM
 * @Version
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 3, 2, 1};
//        int[] array = new int[]{6,5,4,3,2,1};
        int n = 6;
        System.out.println(Arrays.toString(array));
        mergeSort(array, n);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，
     * 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
     *
     * @param a
     * @param n
     */
    private static void mergeSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        mergeCore(a, 0, n - 1);
    }

    private static void mergeCore(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 分为前后两部分
        int q = (p + r) / 2;
        mergeCore(a, p, q);
        mergeCore(a, q + 1, r);
        // 合并
        merge(a, p, q, r);
    }

    /**
     * 合并有序数组[p,q]和[q+1,r]
     *
     * @param a 数组
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p, j = q + 1, k = 0;
        // 一个数组中的数据取完了就先停止。
        while (i <= q && j <= r) {
            if (a[i] > a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 找到没copy完的数组
        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据copy到临时数组中
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        // 将tmp中的数组copy回数组a中
        for (int m = p; m <= r; m++) {
            a[m] = tmp[m - p];
        }
    }
}
