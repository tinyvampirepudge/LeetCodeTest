package com.tinytongtong.leetcodetest.targetoffer.question58;

/**
 * @Description: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 剑指 Offer 58 - II. 左旋转字符串
 * @Author tinytongtong
 * @Date 2020/9/16 1:28 PM
 * @Version
 */
public class ReverseLeftWords {
    private static String reverseLeftWords(String s, int n) {
        if (s == null || n >= s.length() || n < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverseChars(chars, 0, n - 1);
        reverseChars(chars, n, chars.length - 1);
        reverseChars(chars, 0, chars.length - 1);
        StringBuilder sb = new StringBuilder();
        for (char item : chars) {
            sb.append(item);
        }
        return sb.toString();
    }

    private static void reverseChars(char[] chars, int start, int end) {
        if (chars == null || end >= chars.length) {
            return;
        }
        char temp = '0';
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
