package com.tinytongtong.leetcodetest.targetoffer.question57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * @Author tinytongtong
 * @Date 2020/9/15 9:01 PM
 * @Version
 */
public class FindContinuousSequence {

    private static int[][] findContinuousSequence(int target) {
        if (target < 2) {
            return new int[0][0];
        }
        List<List<Integer>> lists = new ArrayList<>();
        int small = 1;
        int big = 2;
        while (small < (target + 1) >> 1) {
            int sum = (big + small) * (big - small + 1) / 2;
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                big++;
            } else if (sum > target) {
                small++;
            } else {
                big++;
            }
        }
        int[][] result = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            result[i] = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                result[i][j] = list.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = findContinuousSequence(9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
