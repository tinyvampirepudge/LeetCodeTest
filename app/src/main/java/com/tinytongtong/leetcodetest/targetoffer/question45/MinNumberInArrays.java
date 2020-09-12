package com.tinytongtong.leetcodetest.targetoffer.question45;

import java.util.Random;

/**
 * @Description: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * 剑指 Offer 45. 把数组排成最小的数
 * @Author tinytongtong
 * @Date 2020/9/11 10:59 PM
 * @Version
 */
public class MinNumberInArrays {

    private static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String item : strs) {
            sb.append(item);
        }
        return sb.toString();
    }

    private static void quickSort(String[] data, int start, int end) {
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

    /**
     * 快速排序
     * 最坏时间复杂度O(n²)
     * 平均时间复杂度O(nlogn)
     *
     * @param data
     * @param start
     * @param end
     */
    private static int partition(String[] data, int start, int end) {
        if (data == null || data.length == 0 || start < 0 || end >= data.length || end < start) {
            return -1;
        }
        // 随机获取角标
        int randomIndex = new Random().nextInt(end - start) + start;
        // swap，将随机选择的数字放到end角标上
        String temp = data[randomIndex];
        data[randomIndex] = data[end];
        data[end] = temp;

        // small 表示交换到前面的元素，最后一个元素的角标
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if ((data[i] + data[end]).compareTo(data[end] + data[i]) < 0) {
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

    public static void main(String[] args) {
//        int[] nums = new int[]{10, 2};
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String result = minNumber(nums);
        System.out.println(result);
    }
}
