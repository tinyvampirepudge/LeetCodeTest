package com.tinytongtong.leetcodetest.targetoffer.question39;

import java.util.Random;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @Author tinytongtong
 * @Date 2020/9/10 5:39 PM
 * @Version
 */
public class MoreThanHalfNumber {

    private static int majorityElement(int[] nums) {
        if (checkInvalidArray(nums)) {
            return 0;
        }

        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int result = nums[middle];
        if (!checkMoreThanHalf(nums, result)) {
            result = 0;
        }
        return result;
    }

    private static boolean checkInvalidArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkMoreThanHalf(int[] nums, int result) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                times++;
            }
        }
        if (times > nums.length >> 1) {
            return true;
        }
        return false;
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

    /**
     * 时间复杂度为O(n)的算法
     *
     * @param nums
     * @return
     */
    private static int moreThanHalfNumber(int[] nums) {
        if (checkInvalidArray(nums)) {
            return 0;
        }

        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            }
            if (nums[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanHalf(nums, result)) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] nums = new int[]{1};
//        int result = majorityElement(nums);
        int result = moreThanHalfNumber(nums);
        System.out.println(result);
    }
}
