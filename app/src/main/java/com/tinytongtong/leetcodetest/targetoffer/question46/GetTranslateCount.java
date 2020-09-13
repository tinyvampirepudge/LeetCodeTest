package com.tinytongtong.leetcodetest.targetoffer.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 剑指 Offer 46. 把数字翻译成字符串
 * @Author tinytongtong
 * @Date 2020/9/12 11:13 AM
 * @Version
 */
public class GetTranslateCount {

    /**
     * 递归解法
     * 缺点：存在重复的子问题
     *
     * @param num
     * @return
     */
    private static List<List<Character>> translateNumByRecursive(int num) {
        if (num < 0) {
            return new ArrayList<>();
        }
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        // 存储结果
        List<List<Character>> lists = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        translateNumByRecursiveCore(chars, 0, lists, list);
        return lists;
    }

    private static void translateNumByRecursiveCore(char[] chars, int start, List<List<Character>> lists, List<Character> list) {
        if (start == chars.length) {
            lists.add(list);
            return;
        }
        list.add((char) (chars[start] - '0' + 'a'));
        // 有下一个元素
        if (start + 1 < chars.length) {
            int value = (chars[start] - '0') * 10 + (chars[start + 1] - '0');
            if (value >= 10 && value <= 25) {
                List<Character> newList = new ArrayList<>();
                newList.addAll(list);
                newList.remove(newList.size() - 1);
                newList.add((char) (value + 'a'));
                translateNumByRecursiveCore(chars, start + 2, lists, newList);
            }
        }
        translateNumByRecursiveCore(chars, start + 1, lists, list);
    }

    /**
     * 迭代解法
     * 解决递归解法中存在重复的子问题
     *
     * @param num
     * @return
     */
    private static int translateNumByIteration(int num) {
        if (num < 0) {
            return 0;
        }
        int[] result = new int[1];
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        translateNumByIterationCore(chars, result);
        return result[0];
    }

    private static void translateNumByIterationCore(char[] chars, int[] result) {
        int length = chars.length;
        int[] counts = new int[chars.length];
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int digit1 = chars[i] - '0';
                int digit2 = chars[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count++;
                    }
                }
            }
            counts[i] = count;
        }
        result[0] = counts[0];
    }

    public static void main(String[] args) {
        int num = 12258;
        List<List<Character>> result = translateNumByRecursive(num);
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (Character c : result.get(i)) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

        int r1 = translateNumByIteration(12258);
        System.out.println(r1);
    }
}
