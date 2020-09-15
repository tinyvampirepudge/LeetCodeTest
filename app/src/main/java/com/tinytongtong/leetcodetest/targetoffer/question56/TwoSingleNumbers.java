package com.tinytongtong.leetcodetest.targetoffer.question56;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * @Author tinytongtong
 * @Date 2020/9/15 10:52 AM
 * @Version
 */
public class TwoSingleNumbers {
    private static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        // 求出所有的异或结果
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int indexBit = findFirstBitIs1(sum);
        // 根据最右侧的1，将数组分成两部分，然后各自异或的结果就是要查找的数据
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i], indexBit)) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};
    }

    private static int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    private static boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
