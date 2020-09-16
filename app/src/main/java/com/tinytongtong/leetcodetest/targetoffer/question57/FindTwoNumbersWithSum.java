package com.tinytongtong.leetcodetest.targetoffer.question57;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 剑指 Offer 57. 和为s的两个数字
 * @Author tinytongtong
 * @Date 2020/9/15 5:06 PM
 * @Version
 */
public class FindTwoNumbersWithSum {
    private static int[] findTwoNumbersWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int index1 = 0;
        int index2 = nums.length - 1;
        while (index2 > index1) {
            if (nums[index1] + nums[index2] == target) {
                return new int[]{nums[index1], nums[index2]};
            } else if (nums[index1] + nums[index2] > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(findTwoNumbersWithSum(nums, 15)));
    }
}
