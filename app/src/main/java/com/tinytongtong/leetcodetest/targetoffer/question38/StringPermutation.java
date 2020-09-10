package com.tinytongtong.leetcodetest.targetoffer.question38;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 剑指 Offer 38. 字符串的排列
 * 全排列的数量是 n!
 * @Author tinytongtong
 * @Date 2020/9/10 10:42 AM
 * @Version
 */
public class StringPermutation {
    private static String[] permutation(String pStr) {
        if (pStr == null || pStr.length() == 0) {
            return new String[0];
        }
        HashSet<String> list = new HashSet<>();
        char[] chars = pStr.toCharArray();
        permutationCore(chars, list, 0);
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    private static void permutationCore(char[] chars, HashSet<String> list, int start) {
        if (start == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char item : chars) {
                sb.append(item);
            }
            list.add(sb.toString());
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, i, start);
                permutationCore(chars, list, start + 1);
                swap(chars, i, start);
            }
        }
    }

    private static void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    public static void main(String[] args) {
        String data = "abc";
        String[] result = permutation(data);
        System.out.println(Arrays.toString(result));
    }
}
