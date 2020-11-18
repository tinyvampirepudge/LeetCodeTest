package com.tinytongtong.leetcodetest.targetoffer.question59;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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

    private static int[] maxSlidingWindow1(int[] nums, int k) {
        // 异常数据校验
        if (nums == null || nums.length <= 0 || k > nums.length) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // m表示窗口的起点，n表示当前的元素角标
        // m大于等于0，表示窗口的数据满了，符合移动的条件了
        for (int m = 1 - k, n = 0; n < nums.length; m++, n++) {
            // 先删除超出窗口边界的元素。m=0表示第一个窗口，m>0表示移动后的窗口。
            if (m > 0 && deque.peekFirst() == nums[m - 1]) {
                deque.removeFirst();
            }
            // 比较新加入的元素跟现有元素的大小，保证最大值在左侧，同时要保证队列递减
            while (!deque.isEmpty() && deque.peekLast() < nums[n]) {
                deque.removeLast();
            }
            deque.addLast(nums[n]);
            if (m >= 0) {
                result[m] = deque.peekFirst();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, 3)));
    }
}
