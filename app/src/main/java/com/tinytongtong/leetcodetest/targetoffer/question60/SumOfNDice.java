package com.tinytongtong.leetcodetest.targetoffer.question60;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * 剑指 Offer 60. n个骰子的点数
 * @Author tinytongtong
 * @Date 2020/9/17 5:49 PM
 * @Versionm
 */
public class SumOfNDice {
    /**
     * 递归解法，包含大量重复计算
     *
     * @param n
     * @return
     */
    private static double[] sumOfNDiceByRecursive(int n) {
        if (n < 1) {
            return new double[0];
        }

        int maxValue = 6;
        int maxNum = 6 * n;
        double[] result = new double[maxNum - n + 1];
        sumOfNDiceByRecursiveCore(n, maxValue, result);
        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxNum; i++) {
            result[i - n] = result[i - n] / total;
        }
        return result;
    }

    private static void sumOfNDiceByRecursiveCore(int n, int maxValue, double[] result) {
        for (int i = 1; i <= maxValue; i++) {
            sumOfNDiceByRecursiveCore(n, maxValue, n, i, result);
        }
    }

    private static void sumOfNDiceByRecursiveCore(int n, int maxValue, int current, int sum, double[] result) {
        if (current == 1) {
            result[sum - n]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                sumOfNDiceByRecursiveCore(n, maxValue, current - 1, sum + i, result);
            }
        }
    }

    /**
     * 迭代解法
     *
     * @param n
     * @return
     */
    private static double[] sumOfNDiceByIteration(int n) {
        if (n < 1) {
            return new double[0];
        }

        int maxValue = 6;
        int maxNum = 6 * n;
        double[][] result = new double[2][maxNum + 1];

        int flag = 0;
        for (int i = 1; i <= maxValue; i++) {
            result[flag][i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                result[1 - flag][i] = 0;
            }
            for (int i = k; i <= maxNum; i++) {
                result[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    result[1 - flag][i] += result[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxNum; i++) {
            result[flag][i] = result[flag][i] / total;
        }
        double[] ds = new double[result[flag].length - n];
        System.arraycopy(result[flag], n, ds, 0, ds.length);
        return ds;
    }

    public static void main(String[] args) {
        double[] result = sumOfNDiceByRecursive(3);
        System.out.println("result.length: " + result.length);
        System.out.println(Arrays.toString(result));

        double[] result1 = sumOfNDiceByIteration(3);
        System.out.println("result1.length: " + result1.length);
        System.out.println(Arrays.toString(result1));
    }
}
