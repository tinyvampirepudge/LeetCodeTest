package com.tinytongtong.leetcodetest.targetoffer.question10;

/**
 * @Description: 剑指 Offer 10. 斐波那契数列
 * @Author tinytongtong
 * @Date 2020/9/5 3:46 PM
 * @Version
 */
public class Fibonacci {
    /**
     * 递归实现fibonacci数列
     * 存在大量重复计算
     *
     * @param n
     * @return
     */
    private static int fibonacciByRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciByRecursion(n - 1) + fibonacciByRecursion(n - 2);
    }

    /**
     * 迭代实现fibonacci数列
     * 从下往上计算
     *
     * @param n
     * @return
     */
    private static int fibonacciByIteration(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = 0;
        int index = 2;
        int one = 0;
        int two = 1;
        while (index <= n) {
            result = two + one;
            one = two;
            two = result;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = fibonacciByRecursion(9);
        System.out.println(result);

        int result1 = fibonacciByIteration(9);
        System.out.println(result1);
    }
}
