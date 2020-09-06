package com.tinytongtong.leetcodetest.targetoffer.question14;

/**
 * @Description: 剑指 Offer 14. 剪绳子
 * @Author tinytongtong
 * @Date 2020/9/6 6:13 PM
 * @Version
 */
public class CutingRope {
    /**
     * 动态规划
     * 时间复杂度O(n²)
     * 空间复杂度O(n)
     *
     * @param length
     * @return
     */
    private static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;// 这个没用
        // 这三个长度是不剪的，是基本单位
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        // 从下到上计算
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    /**
     * 贪婪算法
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     *
     * @param length
     * @return
     */
    private static int maxProductAfterCutting1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        // 尽可能多地减去长度为3的绳子端
        int timeOf3 = length / 3;
        // 当绳子最后剩下的长度是4的时候，不能再减去长度为3的绳子段，
        // 此时更好地方式是把绳子剪成长度为2的两端，因为2 * 2 > 3 * 1
        if (length % 3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        System.out.println(String.format("timeOf3:%d, timeOf2:%d", timeOf3, timeOf2));
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }

    public static void main(String[] args) {
        int length = 7;

        int result = maxProductAfterCutting(length);
        System.out.println(result);

        int result1 = maxProductAfterCutting1(length);
        System.out.println(result1);
    }
}
