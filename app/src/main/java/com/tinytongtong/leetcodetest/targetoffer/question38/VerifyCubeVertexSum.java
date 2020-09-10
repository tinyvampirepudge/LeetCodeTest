package com.tinytongtong.leetcodetest.targetoffer.question38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等
 * a1 + a2 + a3 + a4 = a5 + a6 + a7 + a8
 * a1 + a3 + a5 + a7 = a2 + a4 + a6 + a8
 * a1 + a2 + a5 + a6 = a3 + a4 + a7 + a8
 * @Author tinytongtong
 * @Date 2020/9/10 4:22 PM
 * @Version
 */
public class VerifyCubeVertexSum {
    private static boolean verify(int[] nums) {
        if (nums == null || nums.length < 8) {
            return false;
        }
        List<int[]> list = new ArrayList<>();
        permutationCore(nums, list, 0);
        for (int[] item : list) {
            if (verifyArrays(item)) {
                return true;
            }
        }
        return false;
    }

    private static void permutationCore(int[] nums, List<int[]> list, int start) {
        if (start == nums.length) {
            list.add(Arrays.copyOfRange(nums, 0, nums.length));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                permutationCore(nums, list, start + 1);
                swap(nums, i, start);
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static boolean verifyArrays(int[] nums) {
        if (nums == null || nums.length < 8) {
            return false;
        }
        boolean result = nums[0] + nums[1] + nums[2] + nums[3] == nums[4] + nums[5] + nums[6] + nums[7]
                || nums[0] + nums[2] + nums[4] + nums[6] == nums[1] + nums[3] + nums[5] + nums[7]
                || nums[0] + nums[1] + nums[4] + nums[5] == nums[2] + nums[3] + nums[6] + nums[7];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4, 5, 6, 7, 9};
        boolean result = verify(nums);
        System.out.println(result);
    }
}
