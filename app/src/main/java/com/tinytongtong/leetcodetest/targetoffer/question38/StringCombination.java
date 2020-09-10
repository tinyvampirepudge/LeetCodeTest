package com.tinytongtong.leetcodetest.targetoffer.question38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 求字符的所有组合
 * 输入三个字符a、b、c，则他们的组合有a、b、c、ab、ac、bc、abc。
 * 当交换字符串中的两个字符时，虽然能得到两个不同的排列，但却是同一个组合。
 * 比如ab和ba是不同的排列，但只算一个组合。
 * @Author tinytongtong
 * @Date 2020/9/10 3:31 PM
 * @Version
 */
public class StringCombination {
    private static String[] getStringCombination(String str) {
        if (str == null || str.length() == 0) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int m = 1;
        while (m <= str.length()) {
            combinationCore(str, list, sb, m);
            m++;
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    private static void combinationCore(String str, List<String> list, StringBuilder sb, int m) {
        if (m == 0) {
            list.add(sb.toString());
            return;
        }
        if (str.length() > 0) {
            sb.append(str.charAt(0));
            // 从剩余的n-1中选择m-1个
            combinationCore(str.substring(1), list, sb, m - 1);
            sb.deleteCharAt(sb.length() - 1);
            // 从剩余的n-1中选择m个
            combinationCore(str.substring(1), list, sb, m);
        }
    }

    public static void main(String[] args) {
        String data = "abcd";
        String[] result = getStringCombination(data);
        System.out.println(Arrays.toString(result));
    }
}
