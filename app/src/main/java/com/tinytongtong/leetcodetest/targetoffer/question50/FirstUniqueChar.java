package com.tinytongtong.leetcodetest.targetoffer.question50;

import java.util.HashMap;

/**
 * @Description: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 剑指 Offer 50. 第一个只出现一次的字符
 * @Author tinytongtong
 * @Date 2020/9/14 9:23 AM
 * @Version
 */
public class FirstUniqueChar {
    /**
     * 借助辅助空间
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param s
     * @return
     */
    private static char firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("abaccdeff"));
    }
}
