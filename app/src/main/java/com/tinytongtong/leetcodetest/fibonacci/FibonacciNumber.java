package com.tinytongtong.leetcodetest.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 输出斐波那契数列的第n项，n<=39
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 剑指Offer面试题9
 * @Author wangjianzhou@qding.me
 * @Date 2020-02-08 22:03
 * @Version
 */
public class FibonacciNumber {

    /**
     * 普通解法，从在大量的重复计算，时间效率低
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
//        System.out.println("fibonacciWithCache:" + n);
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static Map<Integer, Integer> resultCache = new HashMap<>();

    /**
     * 将重复的计算缓存起来
     *
     * @param n
     * @return
     */
    public static int fibonacciWithCache(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int resultN1 = 0;
        int resultN2 = 0;
        if (resultCache.get(n - 1) != null) {
            resultN1 = resultCache.get(n - 1);
        } else {
            resultN1 = fibonacci(n - 1);
        }

        if (resultCache.get(n - 2) != null) {
            resultN2 = resultCache.get(n - 2);
        } else {
            resultN2 = fibonacci(n - 2);
        }

        return resultN1 + resultN2;
    }

    /**
     * 从下往上计算，时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public static int fibonacciFromTop(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fibOne = 0;
        int fibTwo = 1;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        int n =30;

        long startTime1 = System.nanoTime();
        int result1 = fibonacci(n);
        long endTime1 = System.nanoTime();
        System.out.println(String.format("从上往下递归，result1:%d, 耗时:%d", result1, endTime1 - startTime1));

        long startTime2 = System.nanoTime();
        int result2 = fibonacciWithCache(n);
        long endTime2 = System.nanoTime();
        System.out.println(String.format("从上往下递归 + 缓存，result2:%d, 耗时:%d", result2, endTime2 - startTime2));

        long startTime3 = System.nanoTime();
        int result3 = fibonacciFromTop(n);
        long endTime3 = System.nanoTime();
        System.out.println(String.format("从下往上计算，result3:%d, 耗时:%d", result3, endTime3 - startTime3));
    }
}
