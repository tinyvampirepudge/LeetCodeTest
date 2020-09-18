package com.tinytongtong.leetcodetest.targetoffer.question65;

/**
 * @Description: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 剑指 Offer 65. 不用加减乘除做加法
 * @Author tinytongtong
 * @Date 2020/9/18 9:20 PM
 * @Version
 */
public class AddNotByArithmetic {

    private static int add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);// 没有进位时才终止。
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 20));
    }
}
