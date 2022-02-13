package com.tinytongtong.leetcodetest.classify.fibonacci;

/**
 * @Description: 矩形覆盖问题，用2*1的小矩形覆盖2*n的矩形，有多少种方式
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 剑指Offer面试题9
 * @Author tinytongtong
 * @Date 2020-02-09 01:29
 * @Version
 */
public class RectCover {
    public static int rectCover(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int valueOne = 1;
        int valueTwo = 2;
        int valueN = 0;
        for (int i = 3; i <= n; i++) {
            valueN = valueOne + valueTwo;
            valueOne = valueTwo;
            valueTwo = valueN;
        }
        return valueN;
    }

    public static void main(String[] args) {
        int n = 3;

        long startTime1 = System.nanoTime();
        int result1 = rectCover(n);
        long endTime1 = System.nanoTime();
        System.out.println(String.format("矩形覆盖，result1:%d, 耗时:%d", result1, endTime1 - startTime1));
    }
}
