package com.tinytongtong.leetcodetest.targetoffer.question15;

/**
 * @Description: 用一条语句判断一个整数是不是2的整数次方
 * @Author tinytongtong
 * @Date 2020/9/6 8:32 PM
 * @Version
 */
public class JudgeMultipleOfTwo {
    private static boolean judgeMultipleOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 65536;
        System.out.println(judgeMultipleOfTwo(n));
    }
}
