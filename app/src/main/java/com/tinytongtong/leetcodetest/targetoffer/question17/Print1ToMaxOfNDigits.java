package com.tinytongtong.leetcodetest.targetoffer.question17;

import java.util.Arrays;

/**
 * @Description: https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 剑指 Offer 17. 打印1到最大的n位数
 * 大数问题
 * @Author tinytongtong
 * @Date 2020/9/7 9:40 AM
 * @Version
 */
public class Print1ToMaxOfNDigits {
    /**
     * 逐个打印
     *
     * @param n
     */
    private static void printNumbers(int n) {
        if (n <= 0) {
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (!increment(chars)) {
            printNumber(chars);
        }
    }

    /**
     * O(1)的时间判断是不是已经到了最大的n位数
     *
     * @param chars
     * @return
     */
    private static boolean increment(char[] chars) {
        // 是否已经到了最大数
        boolean isOverFlow = false;
        // 进位的数字
        int nTakeOver = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int nSum = chars[i] - '0' + nTakeOver;
            if (i == chars.length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    chars[i] = (char) ('0' + nSum);
                }
            } else {
                chars[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 打印字符串代表的数据
     * 只有在碰到第一个非0的字符之后才开始打印
     *
     * @param chars
     */
    private static void printNumber(char[] chars) {
        boolean isBeginning0 = true;
        for (int i = 0; i < chars.length; i++) {
            if (isBeginning0 && chars[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(chars[i]);
            }
        }
        System.out.println();
    }

    /**
     * 数组排列
     * 全排列用递归实现
     *
     * @param n
     */
    private static void printNumbers1(int n) {
        if (n <= 0) {
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        for (int i = 0; i < 10; i++) {
            chars[0] = (char) (i + '0');
            printNumberRecursively(chars, 0);
        }
    }

    /**
     * 递归
     *
     * @param chars
     * @param index
     */
    private static void printNumberRecursively(char[] chars, int index) {
        if (index == chars.length - 1) {
            printNumber(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char) (i + '0');
            printNumberRecursively(chars, index + 1);
        }
    }

    public static void main(String[] args) {
        int n = 2;
//        printNumbers(n);
        printNumbers1(n);
    }
}
