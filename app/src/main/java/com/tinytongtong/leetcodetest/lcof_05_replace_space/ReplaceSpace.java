package com.tinytongtong.leetcodetest.lcof_05_replace_space;

/**
 * @Description: 替换字符串中的空格
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author tinytongtong
 * @Date 2020-02-08 14:56
 * @Version
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        String result = replaceSpace(sb);
        System.out.println(String.format("result:%s", result));
    }
}
