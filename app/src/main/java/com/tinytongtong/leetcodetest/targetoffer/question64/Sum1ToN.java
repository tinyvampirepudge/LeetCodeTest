package com.tinytongtong.leetcodetest.targetoffer.question64;

/**
 * @Description: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 剑指 Offer 64. 求1+2+…+n
 * @Author tinytongtong
 * @Date 2020/9/18 5:22 PM
 * @Version
 */
public class Sum1ToN {
    /**
     * 递归实现，从n, n - 1, 一直加到1
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param n
     * @return
     */
    private static int sumNumsByRecursive(int n) {
        boolean flag = n > 1 && (n = n + sumNumsByRecursive(n - 1)) > 0;
        return n;
    }

    /**
     * 递归实现，n*(n + 1)/2
     * 使用俄罗斯农名算法模拟乘法n*(n + 1)
     *
     * @param n
     * @return
     */
    private static int sumNumsByRecursive1(int n) {
        return sumNumsByRecursiveCore(n, n + 1, 0) >> 1;
    }

    private static int sumNumsByRecursiveCore(int n, int k, int sum) {
        boolean s = (k & 1) == 1 && (sum += n) > 0;
        boolean flag = k > 0 && (sum = sumNumsByRecursiveCore(n << 1, k >> 1, sum)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumsByRecursive(4));
        System.out.println(sumNumsByRecursive1(4));
    }
}
