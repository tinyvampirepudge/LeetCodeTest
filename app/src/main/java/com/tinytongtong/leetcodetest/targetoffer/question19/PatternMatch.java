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
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 分为 空正则 和 非空正则 两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    // 非空正则分为两种情况， * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        // 碰到 * 了，分为看和不来看两种情况
                        // 不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        // 看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }

        return f[n][m];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean result = isMatch(s, p);
        System.out.println(result);
    }
}
