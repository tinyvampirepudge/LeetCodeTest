package com.tinytongtong.leetcodetest.targetoffer.question20;

/**
 * @Description: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 剑指 Offer 20. 表示数值的字符串
 * @Author tinytongtong
 * @Date 2020/9/7 6:12 PM
 * @Version
 */
public class JudgeStringIsNumeric {

    private static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        int[] index = new int[1];
        boolean numeric = scanInteger(s, index);

        // 小数部分
        if (index[0] < s.length() && s.charAt(index[0]) == '.') {
            index[0]++;
            numeric = scanUnsignedInteger(s, index) || numeric;
        }
        if (index[0] < s.length() && (s.charAt(index[0]) == 'e' || s.charAt(index[0]) == 'E')) {
            index[0]++;
            numeric = numeric && scanInteger(s, index);
        }
        return numeric && index[0] == s.length();
    }

    /**
     * 扫描可能表示正负的'+'或者'-'起始的0~9的数位
     *
     * @param s
     * @param index
     * @return
     */
    private static boolean scanInteger(String s, int[] index) {
        if (index[0] < s.length() && (s.charAt(index[0]) == '+' || s.charAt(index[0]) == '-')) {
            index[0]++;
        }
        return scanUnsignedInteger(s, index);
    }

    /**
     * 扫描字符串中0~9的数位
     *
     * @param s
     * @param index
     * @return
     */
    private static boolean scanUnsignedInteger(String s, int[] index) {
        int before = index[0];
        while (index[0] < s.length() && s.charAt(index[0]) >= '0' && s.charAt(index[0]) <= '9') {
            index[0]++;
        }
        return index[0] > before;
    }

    public static void main(String[] args) {
        String s = "1";
        boolean result = isNumber(s);
        System.out.println(result);
    }
}
