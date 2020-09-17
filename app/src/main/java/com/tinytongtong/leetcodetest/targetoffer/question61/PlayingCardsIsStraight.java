package com.tinytongtong.leetcodetest.targetoffer.question61;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 剑指 Offer 61. 扑克牌中的顺子
 * @Author tinytongtong
 * @Date 2020/9/17 10:55 PM
 * @Version
 */
public class PlayingCardsIsStraight {
    private static boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        // 先把数据排序
        Arrays.sort(nums);
        // 其次统计数组中0的个数
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        // 最后统计排序之后的数组中，相邻两个数字之间的空缺总数
        int gapCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                if (nums[i + 1] == nums[i]) {
                    return false;
                }
                gapCount += nums[i + 1] - nums[i] - 1;
            }
        }
        return zeroCount >= gapCount;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 4, 3, 2, 1};
        int[] nums = new int[]{0, 0, 2, 2, 5};
        System.out.println(isStraight(nums));
        System.out.println(Arrays.toString(nums));
    }
}
