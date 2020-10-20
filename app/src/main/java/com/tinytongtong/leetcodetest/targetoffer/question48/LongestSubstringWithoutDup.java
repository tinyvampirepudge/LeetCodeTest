package com.tinytongtong.leetcodetest.targetoffer.question48;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @Author tinytongtong
 * @Date 2020/10/20 9:31 PM
 * @Version
 */
public class LongestSubstringWithoutDup {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("arabcacfrr"));
        System.out.println(lengthOfLongestSubstring("abcabcabc"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
