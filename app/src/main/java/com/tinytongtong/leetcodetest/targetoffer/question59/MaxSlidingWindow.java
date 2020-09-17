package com.tinytongtong.leetcodetest.targetoffer.question59;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description: https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Author tinytongtong
 * @Date 2020/9/17 9:40 AM
 * @Version
 */
public class MaxSlidingWindow {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        // 获取前k个数的最大值。
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        // 移动窗口，获取最大值
        for (int i = k; i < nums.length; i++) {
            result[i - k] = nums[deque.peekFirst()];
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        result[result.length - 1] = nums[deque.peekFirst()];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
