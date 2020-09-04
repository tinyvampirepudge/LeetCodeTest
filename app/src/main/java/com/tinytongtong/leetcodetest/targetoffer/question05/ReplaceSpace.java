package com.tinytongtong.leetcodetest.targetoffer.question05;

/**
 * @Description: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 剑指 Offer 05. 替换空格
 * @Author tinytongtong
 * @Date 2020/9/3 11:30 PM
 * @Version
 */
public class ReplaceSpace {
    /**
     * 先查找出空格的个数，根据这个个数计算出
     *
     * @param s
     * @return
     */
    private static String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        char[] newChars = new char[chars.length + count * 2];
        for (int i = chars.length - 1, j = newChars.length - 1; i >= 0; i--, j--) {
            if (' ' == chars[i]) {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j] = '%';
            } else {
                newChars[j] = chars[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newChars.length; i++) {
            sb.append(newChars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String result = replaceSpace(s);
        System.out.println(result);
    }
}
