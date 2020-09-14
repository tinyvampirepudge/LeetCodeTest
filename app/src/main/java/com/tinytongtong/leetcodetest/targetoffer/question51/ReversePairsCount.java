package com.tinytongtong.leetcodetest.targetoffer.question51;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 剑指 Offer 51. 数组中的逆序对
 * @Author tinytongtong
 * @Date 2020/9/14 10:37 AM
 * @Version
 */
public class ReversePairsCount {
    /**
     * 递归解法
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    private static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] arrays = new int[nums.length];
        System.arraycopy(nums, 0, arrays, 0, nums.length);
        int result = reversePairsCore(nums, arrays, 0, nums.length - 1);
        return result;
    }

    private static int reversePairsCore(int[] nums, int[] arrays, int start, int end) {
        if (start == end) {
            arrays[start] = nums[start];
            return 0;
        }
        int length = (end - start) >> 1;
        int left = reversePairsCore(arrays, nums, start, start + length);
        int right = reversePairsCore(arrays, nums, start + length + 1, end);
        // i 初始化为前半段最后一个数字的角标
        int i = start + length;
        // j 初始化为后半段最后一个数值的角标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                arrays[indexCopy--] = nums[i--];
                count += j - start - length;
            } else {
                arrays[indexCopy--] = nums[j--];
            }
        }
        while (i >= start) {
            arrays[indexCopy--] = nums[i--];
        }
        while (j >= start + length + 1) {
            arrays[indexCopy--] = nums[j--];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }
}
