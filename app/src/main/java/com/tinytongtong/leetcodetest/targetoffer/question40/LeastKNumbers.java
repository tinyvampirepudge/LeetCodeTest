package com.tinytongtong.leetcodetest.targetoffer.question40;

import android.annotation.SuppressLint;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Description: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 剑指 Offer 40. 最小的k个数
 * @Author tinytongtong
 * @Date 2020/9/10 10:05 PM
 * @Version
 */
public class LeastKNumbers {
    private static int[] getLeastNumbers(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[k];
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }
        return result;
    }

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
        int randomIndex;
        if (end == start) {
            randomIndex = start;
        } else {
            randomIndex = new Random().nextInt(end - start) + start;
        }
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

    private static int[] getLeastNumbers1(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }

        @SuppressLint({"NewApi", "LocalSuppress"})
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else if (nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        int[] result = new int[k];
        int idx = 0;
        for (Integer item : queue) {
            result[idx++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
//        int[] nums = new int[]{0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
//        int[] result = getLeastNumbers(nums, 75);
        int[] result = getLeastNumbers1(nums, 4);
        System.out.println(Arrays.toString(result));
    }
}
