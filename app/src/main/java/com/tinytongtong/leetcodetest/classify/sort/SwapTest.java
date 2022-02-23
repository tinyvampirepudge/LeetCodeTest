package com.tinytongtong.leetcodetest.classify.sort;

/**
 * @Description: swap交换小技巧
 * @Author wangjianzhou
 * @Date 2/17/22 8:55 AM
 * @Version
 */
public class SwapTest {

    public static void main(String[] args) {
        int a = 5;
        int b = 12;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }
}
