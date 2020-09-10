package com.tinytongtong.leetcodetest.targetoffer.question38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 8皇后问题
 * 使用一维数组降维
 * @Author tinytongtong
 * @Date 2020/9/10 4:50 PM
 * @Version
 */
public class EightQueen {

    private static List<int[]> getQueenResult() {
        List<int[]> list = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        permutationCore(nums, list, 0);
        System.out.println("全排列的数量：" + list.size());// 全排列的数量是n!
        for (int[] item : list) {
            if (verifyQueue(item)) {
                result.add(item);
            }
        }
        return result;
    }

    private static void permutationCore(int[] nums, List<int[]> list, int start) {
        if (start == nums.length) {
            list.add(Arrays.copyOf(nums, nums.length));
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

    /**
     * 判断是否在同一个对角线上
     *
     * @param nums
     * @return true不在同一个对角线上，false表示在。
     */
    private static boolean verifyQueue(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    // 是对角线
                    if (j - i == nums[j] - nums[i] || i - j == nums[j] - nums[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<int[]> result = getQueenResult();
        System.out.println(result.size());
        for (int[] item : result) {
            System.out.println(Arrays.toString(item));
        }
    }
}
