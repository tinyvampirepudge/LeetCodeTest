package com.tinytongtong.leetcodetest.targetoffer.question15;

/**
 * @Description: 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
 * @Author tinytongtong
 * @Date 2020/9/6 9:11 PM
 * @Version
 */
public class ModifyBits {
    private static int modifyBits(int m, int n) {
        if (m == n) {
            return 0;
        }
        int count = 0;
        /**
         * 我们可以分为两步解决这个问题：第一步求这两个数的异或；第二步统计异或结果中1的位数
         */
        int r = m ^ n;
        while (r != 0) {
            count++;
            r = r & (r - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 0b11011;
        int n = 0b10100;
        System.out.println(modifyBits(m, n));
    }
}
