package com.tinytongtong.leetcodetest.targetoffer.question16;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 剑指 Offer 16. 数值的整数次方
 * @Author tinytongtong
 * @Date 2020/9/6 9:54 PM
 * @Version
 */
public class Power {

    private static double power(double base, int exponent) {
        // 底数为0
        if (base == 0) {
            return 0;
        }
        long absLongExp = exponent;
        double res = 1.0;
        if (absLongExp < 0) {
            base = 1 / base;
            absLongExp = -absLongExp;
        }
        while (absLongExp > 0) {
            // 基数
            if ((absLongExp & 1) == 1) {
                res *= base;
            }
            base *= base;
            absLongExp = absLongExp >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        double base = 2.00000;
        int exponent = 10;
        double result = power(base, exponent);
        System.out.println(result);

        double base1 = 2.10000;
        int exponent1 = 3;
        double result1 = power(base1, exponent1);
        System.out.println(result1);

        double base2 = 2.00000;
        int exponent2 = -2;
        double result2 = power(base2, exponent2);
        System.out.println(result2);
    }
}
