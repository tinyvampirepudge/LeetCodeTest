package com.tinytongtong.leetcodetest.targetoffer.question66;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * 剑指 Offer 66. 构建乘积数组
 * @Author tinytongtong
 * @Date 2020/9/18 9:50 PM
 * @Version
 */
public class ConstructProductArray {
    private static int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] result = new int[a.length];
        result[0] = 1;
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        double temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr(nums)));
    }
}
