package com.tinytongtong.leetcodetest.targetoffer.question53;

/**
 * @Description: 数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
 * @Author tinytongtong
 * @Date 2020/9/14 11:21 PM
 * @Version
 */
public class FindSameIndexNumber {
    private static int findSameIndexNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] == middle) {
                return middle;
            }
            if (nums[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -1, 1, 3, 4};
        System.out.println(findSameIndexNumber(nums));
    }
}
