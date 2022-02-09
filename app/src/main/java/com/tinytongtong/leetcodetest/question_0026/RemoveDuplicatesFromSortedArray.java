package com.tinytongtong.leetcodetest.question_0026;

/**
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除排序数组中的重复项
 * @Author tinytongtong
 * @Date 2020/9/1 9:45 AM
 * @Version
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = removeDuplicates(nums);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        int[] nums1 = new int[]{1, 1, 2};
        int count1 = removeDuplicates(nums1);
        for (int i = 0; i < count1; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
}
