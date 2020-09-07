package com.tinytongtong.leetcodetest.targetoffer.question21;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @Author tinytongtong
 * @Date 2020/9/7 9:40 PM
 * @Version
 */
public class ExchangeOrder {
    private static int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            // 奇数
            while (start < nums.length - 1 && (nums[start] & 1) == 1) {
                start++;
            }
            // 偶数
            while (end > 0 && (nums[end] & 1) == 0) {
                end--;
            }
            // swap
            if (start < end) {
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] result = exchange(nums);
        System.out.println(Arrays.toString(result));
    }
}
