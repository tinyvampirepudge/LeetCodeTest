package com.tinytongtong.leetcodetest.question.question_0003;

import java.util.HashMap;

/**
 * @Description: 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author wangjianzhou
 * @Date 2022/2/9 10:41 AM
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 空字符串
        if (s == null || s.length() == 0) return 0;
        // 滑动窗口解法
        int left = 0; // 窗口左侧
        int max = 0; // 记录最长子串的长度
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) left = Math.max(map.get(s.charAt(i)) + 1, left);
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
