package com.tinytongtong.leetcodetest.targetoffer.question11;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 快速排序，随机选择 pivot
 * @Author tinytongtong
 * @Date 2020/9/5 4:36 PM
 * @Version
 */
public class QuickSort {
    /**
     * 快速排序
     * 最坏时间复杂度O(n²)
     * 平均时间复杂度O(nlogn)
     *
     * @param data
     * @param start
     * @param end
     */
    private static int partition(int[] data, int start, int end) {
        if (data == null || data.length == 0 || start < 0 || end >= data.length || end < start) {
            return -1;
        }
        // 随机获取角标
        int randomIndex = new Random().nextInt(end - start) + start;
        // swap，将随机选择的数字放到end角标上
        int temp = data[randomIndex];
        data[randomIndex] = data[end];
        data[end] = temp;

        // small 表示交换到前面的元素，最后一个元素的角标
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                small++;
                if (small != i) {
                    // swap，将small和i位置的元素进行互换
                    temp = data[small];
                    data[small] = data[i];
                    data[i] = temp;
                }
            }
        }
        small++;
        // 还原位置
        temp = data[small];
        data[small] = data[end];
        data[end] = temp;
        return small;
    }

    private static void quickSort(int[] data, int start, int end) {
        if (data == null || start == end) {
            return;
        }
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
