package com.tinytongtong.leetcodetest.targetoffer.question63;

/**
 * @Description: https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 剑指 Offer 63. 股票的最大利润
 * @Author tinytongtong
 * @Date 2020/9/18 10:07 AM
 * @Version
 */
public class StockMaxProfit {
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxProfit(prices));
    }
}
