package com.tinytongtong.leetcodetest.targetoffer.question03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 剑指 Offer 03. 数组中重复的数字
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
        if (nums == null) {
            return -1;
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
        if (nums == null) {
            return -1;
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
        if (nums == null) {
            return -1;
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

    /**
     * https://github.com/zhedahht/CodingInterviewChinese2/issues/63
     * 0~(n-1)这个n个数字在没有重复数字的情况下最多需要交换n-1次就可以让所有数字找到自己的位置
     * 验证方法
     *
     * @param nums
     * @return
     */
    private static int verifyTest(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int swapCount = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 交换元素
                temp = nums[i];
                nums[i] = i;
                i = temp;
                swapCount++;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        /**
         * 0~(n-1)这个n个数字在没有重复数字的情况下最多需要交换n-1次就可以让所有数字找到自己的位置
         */
        // 测试10遍
        for (int m = 0; m < 10; m++) {
            int[] nums1 = new int[100000];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = i;
                list.add(i);
            }
            // 列表乱序
            Collections.shuffle(list);
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = list.get(i);
            }
            // 获取交换次数
            int swapCount = verifyTest(nums1);
            System.out.println("swapCount:" + swapCount);
        }

        // 测试数据
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};

        int result = findRepeatNumber(nums);
        System.out.println(result);

        int result1 = findRepeatNumber1(nums);
        System.out.println(result1);

        int[] nums2 = new int[]{2, 3, 1, 0, 2, 5, 3};
        int result2 = findRepeatNumber2(nums2);
        System.out.println(result2);

    }
}
