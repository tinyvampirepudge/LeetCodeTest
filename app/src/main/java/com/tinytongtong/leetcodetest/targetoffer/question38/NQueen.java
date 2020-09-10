package com.tinytongtong.leetcodetest.targetoffer.question38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/eight-queens-lcci/
 * n皇后问题
 * @Author tinytongtong
 * @Date 2020/9/10 6:03 PM
 * @Version
 */
public class NQueen {
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        // 得到全排列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        List<int[]> list = new ArrayList<>();
        permutationCore(nums, list, 0);
        // 挑选符合规则的数组
        List<int[]> queenList = new ArrayList<>();
        for (int[] item : list) {
            if (verifyQueen(item)) queenList.add(item);
        }
        // 将数组转换成Q字符串
        for (int[] item : queenList) {
            result.add(convertToQueen(item));
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

    private static boolean verifyQueen(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (j - i == nums[j] - nums[i] || i - j == nums[j] - nums[i]) return false;
                }
            }
        }
        return true;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static List<String> convertToQueen(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            strList.add(sb.toString());
        }
        return strList;
    }

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }
}
