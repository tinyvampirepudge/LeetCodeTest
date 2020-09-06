package com.tinytongtong.leetcodetest.targetoffer.question15;

/**
 * @Description: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 剑指 Offer 15. 二进制中1的个数
 * @Author tinytongtong
 * @Date 2020/9/6 7:48 PM
 * @Version
 */
public class NumberOfOne {
    /**
     * 首先把n和1做与运算，判断n的最低位是不是1；
     * 接着把1左移一位得到2，再和n的最低位做与运算，就能判断n的次低位是不是1……
     * 这样反复左移，每次都能判断n的其中一位是不是1.
     * 时间复杂度O(1)：因为int类型是32位，所以就是32次。
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    private static int hammingWeight(int n) {
        int limit = 0;
        int count = 0;
        // 负数的符号位也需要计入，但是在左移过程中，符号位是不参与移位运算的。
        if (n < 0) {
            count++;
        }
        int flag = 1;
        while (limit <= 32) {
            if ((n & flag) > 0) {
                count++;
            }
            flag = flag << 1;
            limit++;
        }
        return count;
    }

    public int hammingWeight0(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    private static int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        test(0);
        test(1);
        test(0x7FFFFFFF);
        test(0x80000000);
        test(0xfFFFFFFF);
    }

    private static void test(int number) {
        boolean isPositive = number >= 0;
        System.out.println(String.format("--------------%s---------------", isPositive ? "正数" : "负数"));
        System.out.println("二进制表示：" + Integer.toBinaryString(number));
        int result = hammingWeight(number);
        System.out.println(result);
        int result1 = hammingWeight1(number);
        System.out.println(result1);
        System.out.println("-----------------------------");
    }
}
