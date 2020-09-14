package com.tinytongtong.leetcodetest.targetoffer.question53;

/**
 * @Description: 找到0~n-1中缺失的数字
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0~n-1 之内。
 * @Author tinytongtong
 * @Date 2020/9/14 10:48 PM
 * @Version
 */
public class FindMissingNumber {

    private static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] != middle) {
                if (middle == 0 || nums[middle - 1] == middle - 1) {
                    return middle;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left == right) {
            return left;
        }

        if (left == nums.length) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 9};
//        int[] nums = new int[]{0};
        System.out.println(missingNumber(nums));
    }
}
