package com.tinytongtong.leetcodetest.targetoffer.question49;

/**
 * @Description: https://leetcode-cn.com/problems/chou-shu-lcof/
 * 剑指 Offer 49. 丑数
 * @Author tinytongtong
 * @Date 2020/9/13 9:07 PM
 * @Version
 */
public class UglyNumber {
    /**
     * 暴力解法
     * @param n
     * @return
     */
    private static int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < n) {
            ++number;
            if (isUgly(number)) {
                uglyFound++;
            }
        }
        return number;
    }

    /**
     * @param number
     * @return
     */
    private static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    /**
     * 只找丑数
     * @param n
     * @return
     */
    private static int nthUglyNumber1(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int[] multiply2 = uglyNumbers;
        int index2 = 0;
        int[] multiply3 = uglyNumbers;
        int index3 = 0;
        int[] multiply5 = uglyNumbers;
        int index5 = 0;

        while (nextUglyIndex < n) {
            int min = min(multiply2[index2] * 2, multiply3[index3] * 3, multiply5[index5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (multiply2[index2] * 2 <= uglyNumbers[nextUglyIndex]) {
                index2++;
            }
            while (multiply3[index3] * 3 <= uglyNumbers[nextUglyIndex]) {
                index3++;
            }
            while (multiply5[index5] * 5 <= uglyNumbers[nextUglyIndex]) {
                index5++;
            }
            nextUglyIndex++;
        }

        int number = uglyNumbers[nextUglyIndex - 1];
        return number;
    }

    private static int min(int number2, int number3, int number5) {
        int min = number2 < number3 ? number2 : number3;
        min = min < number5 ? min : number5;
        return min;
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(7));
        System.out.println(nthUglyNumber1(8));
    }
}
