package com.tinytongtong.leetcodetest.targetoffer.question53;

/**
 * @Description: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * @Author tinytongtong
 * @Date 2020/9/14 6:10 PM
 * @Version
 */
public class FindNumberInSortedArray {

    /**
     * 基于二分查找，分别查找第一次出现的位置和最后一次出现的位置
     *
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int number = 0;
        int firstK = getFirstK(nums, target, 0, nums.length - 1);
        int lastK = getLastK(nums, target, 0, nums.length - 1);
        if (firstK > -1 && lastK > -1) {
            number = lastK - firstK + 1;
        }
        return number;
    }

    private static int getFirstK(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (nums[middle] == target) {
            if ((middle > 0 && nums[middle - 1] != target) || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (nums[middle] > target) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return getFirstK(nums, target, start, end);
    }

    private static int getLastK(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (nums[middle] == target) {
            if ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (nums[middle] > target) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return getLastK(nums, target, start, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(search(nums, 3));
    }
}
