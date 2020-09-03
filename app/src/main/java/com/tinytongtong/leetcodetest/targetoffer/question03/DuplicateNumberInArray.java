package com.tinytongtong.leetcodetest.targetoffer.question03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 剑指 Offer 03. 数组中重复的数字
 * 可以修改数组中的数字
 * @Author tinytongtong
 * @Date 2020/9/3 10:20 AM
 * @Version
 */
public class DuplicateNumberInArray {

    /**
     * 先排序，然后从左到右扫描
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    private static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return -1;
            }
        }
        Arrays.sort(nums);
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (pre == nums[i]) {
                return nums[i];
            }
            pre = nums[i];
        }
        return -1;
    }

    /**
     * 使用哈希表
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    private static int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return -1;
            }
        }
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return nums[i];
            }
            map.add(nums[i]);
        }
        return -1;
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    private static int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] >= nums.length) {
                return -1;
            }
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 测试数据
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        test(nums);

        // 无重复数据
        int[] nums2 = new int[]{0, 1, 2, 3, 4, 5, 6};
        test(nums2);

        // 数据不符合规定
        int[] nums3 = new int[]{3, 12, 2, 3, 4, 5, 6};
        test(nums3);
    }

    private static void test(int[] nums) {
        System.out.println("--------------------start--------------------");
        System.out.println(Arrays.toString(nums));
        // 测试数据
        int result = findRepeatNumber(nums);
        System.out.println(result);

        int result1 = findRepeatNumber1(nums);
        System.out.println(result1);

        int result2 = findRepeatNumber2(nums);
        System.out.println(result2);
        System.out.println("--------------------end--------------------");
    }
}
