package com.tinytongtong.leetcodetest.targetoffer.question44;

/**
 * @Description: https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * 剑指 Offer 44. 数字序列中某一位的数字
 * @Author tinytongtong
 * @Date 2020/9/11 4:57 PM
 * @Version
 */
public class FindNthDigit {
    private static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int result = 0;
        result = findNthDigitCore(n, 9, 1);
        return result;
    }

    private static int findNthDigitCore(int n, int sum, int digit) {
        int delta = 0;
        int start = 0;
        do {
            start = sum + 1;
            digit++;
            delta = (int) (digit * 9 * Math.pow(10, digit - 1));
            sum += delta;
        } while (n > sum);

        // 在[start, end]区间内查找对应位数
        int nDelta = n - start + 1;
        // 第几个数，从0开始
        int j = (nDelta - 1) / digit;
        // 数字的第几位
        int k = (nDelta - 1) % digit;
        int nStart = (int) Math.pow(10, digit - 1);
        return getIntAtIndex(nStart + j, k, digit);
    }

    /**
     * 获取第n位的数字，从左到右，从0开始
     *
     * @param n
     * @param index
     * @return
     */
    private static int getIntAtIndex(int n, int index, int digit) {
        int count = 0;
        while (count < index) {
            n %= Math.pow(10, digit - 1 - count);
            count++;
        }
        int result = (int) (n / Math.pow(10, digit - 1 - count));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(12));
        System.out.println(findNthDigit(13));
        System.out.println(findNthDigit(14));
        System.out.println(findNthDigit(15));
        System.out.println(findNthDigit(16));
        System.out.println(findNthDigit(17));
    }
}
