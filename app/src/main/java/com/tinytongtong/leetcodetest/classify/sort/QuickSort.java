package com.tinytongtong.leetcodetest.classify.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 快速排序
 * {@link com.tinytongtong.leetcodetest.targetoffer.question11.QuickSort}
 * @Author wangjianzhou
 * @Date 2/16/22 10:22 PM
 * @Version
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] array = new int[]{4, 5, 6, 3, 2, 1};
        int[] array = new int[]{6, 5, 4, 3, 2, 1};
//        int[] array = new int[]{4, 2, 1};
        int n = 6;
        System.out.println(Arrays.toString(array));
        quickSort(array, n);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] a, int n) {
        if (a == null || n <= 1) {
            return;
        }
        quickSortCore(a, 0, n - 1);
    }

    private static void quickSortCore(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        // 获取分区点，并将
        int pivot = partition(a, start, end);
        quickSortCore(a, start, pivot - 1);
        quickSortCore(a, pivot + 1, end);
    }

    /**
     * 随机选择一个pivot，小于它的数据在左侧，大于它的数据在右侧。
     * 执行完毕后，这意味着pivot对应的数据在正确的位置。
     *
     * @return 返回pivot的角标。
     */
    private static int partition(int[] a, int start, int end) {
        if (a == null || a.length <= 0 || start < 0 || end >= a.length) {
            throw new IllegalArgumentException("invalid params in partition");
        }
        // 获取所及的pivot
        int randomIndex = new Random().nextInt(end - start) + start;
        // randomIndex 跟最后一个元素交换位置
        if (end != randomIndex) {
            a[end] ^= a[randomIndex];
            a[randomIndex] ^= a[end];
            a[end] ^= a[randomIndex];
        }

        // 从前到后遍历，将小于pivot的数交换到前面。
        int index = start;
        for (int i = start; i < end; i++) {
            if (a[i] < a[end]) {
                if (i != index) {
                    a[index] ^= a[i];
                    a[i] ^= a[index];
                    a[index] ^= a[i];
                }

                index++;
            }
        }
        // 将 randomIndex 交换到小于它的数的后面
        if (index != end) {
            a[index] ^= a[end];
            a[end] ^= a[index];
            a[index] ^= a[end];
        }

        return index;
    }
}
