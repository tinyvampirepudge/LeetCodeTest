package com.tinytongtong.leetcodetest.targetoffer.question56;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @Author tinytongtong
 * @Date 2020/9/15 2:41 PM
 * @Version
 */
public class FindNumberAppearingOnce {
    private static int findNumberAppearingOnce(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid input.");
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j]++;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 7, 9, 7, 9, 7};
        System.out.println(findNumberAppearingOnce(nums));
    }
}
