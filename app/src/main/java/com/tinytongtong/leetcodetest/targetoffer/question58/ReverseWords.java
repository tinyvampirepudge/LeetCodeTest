package com.tinytongtong.leetcodetest.targetoffer.question58;

/**
 * @Description: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 剑指 Offer 58 - I. 翻转单词顺序
 * @Author tinytongtong
 * @Date 2020/9/16 9:24 AM
 * @Version
 */
public class ReverseWords {
    private static String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 整体反转
        reverseChars(chars, 0, chars.length - 1);
        // 单词反转
        int index1 = 0;
        int index2 = 0;
        while (index1 < chars.length && index2 < chars.length) {
            while (index1 < chars.length && chars[index1] == ' ') {
                index1++;
            }
            index2 = index1;
            while (index2 < chars.length && chars[index2] != ' ') {
                index2++;
            }
            reverseChars(chars, index1, index2 - 1);
            index1 = index2;
        }
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
//        String str = "we are student.";
        String str = "  hello world!  ";
        System.out.println(reverseWords(str));
    }
}
