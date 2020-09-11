package com.tinytongtong.leetcodetest.targetoffer.question43;

/**
 * @Description: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * @Author tinytongtong
 * @Date 2020/9/11 3:41 PM
 * @Version
 */
public class CountDigitOne {
    /**
     * @param x
     * @return
     */
    private static int countDigitOne(int x) {
        if (x <= 0) {
            return 0;
        }
        return countCore(x);
    }

    /**
     * 将数字分为两部分
     *
     * @param x
     * @return
     */
    private static int countCore(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 10) {
            return 1;
        }
        int sum = 0;
        // 获取数字的位数
        int m = getHighDigit(x);
        // 获取高位的值
        int n = getHighNum(x, m);
        // 获取地位的余数
        int delta = (int) (x % Math.pow(10, m - 1));
        // 1在最高位上出现的次数
        if (n > 1) {
            sum += Math.pow(10, m - 1);
        } else {
            sum += delta + 1;
        }
        // 1在除了最高位上出现的次数
        sum += n * Math.pow(10, m - 2) * (m - 1);
        // 计算低位所有数字的个数
        sum += countCore(delta);
        return sum;
    }

    /**
     * 获取数字的位数
     *
     * @param n
     * @return
     */
    private static int getHighDigit(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    /**
     * 获取最高位的数字
     *
     * @param n
     * @return
     */
    private static int getHighNum(int n, int highDigit) {
        return (int) (n / Math.pow(10, highDigit - 1));
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(10));// 2
        System.out.println(countDigitOne(20));// 14
    }
}
