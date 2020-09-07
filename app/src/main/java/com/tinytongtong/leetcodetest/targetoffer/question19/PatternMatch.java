package com.tinytongtong.leetcodetest.targetoffer.question19;

/**
 * @Description: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * 剑指 Offer 19. 正则表达式匹配
 * @Author tinytongtong
 * @Date 2020/9/7 5:18 PM
 * @Version
 */
public class PatternMatch {
    private static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return matchCore(s, p, 0, 0);
    }

    private static boolean matchCore(String s, String p, int indexS, int indexP) {
        // TODO: 2020/9/7 6:10 PM  
        return false;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean result = isMatch(s, p);
        System.out.println(result);
    }
}
