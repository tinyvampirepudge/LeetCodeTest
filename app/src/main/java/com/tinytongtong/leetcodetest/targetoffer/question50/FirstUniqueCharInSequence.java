package com.tinytongtong.leetcodetest.targetoffer.question50;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 字符流中第一个只出现一次的字符
 * 请实现一个函数，用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g';
 * 当从该字符流中读出前6个字符"google"时，第一个只出现一次的字符是'l'。
 * @Author tinytongtong
 * @Date 2020/9/14 10:23 AM
 * @Version
 */
public class FirstUniqueCharInSequence {
    LinkedHashMap<Character, Integer> map;

    public FirstUniqueCharInSequence() {
        map = new LinkedHashMap<>();
    }

    public void insert(char ch) {
        if (map.get(ch) == null) {
            map.put(ch, 1);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    public char firstAppearingOnce() {
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (item.getValue() != null && item.getValue() == 1) {
                return item.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqueCharInSequence firstUniqueCharInSequence = new FirstUniqueCharInSequence();
        firstUniqueCharInSequence.insert('g');
        firstUniqueCharInSequence.insert('o');
        System.out.println(firstUniqueCharInSequence.firstAppearingOnce());
        firstUniqueCharInSequence.insert('o');
        firstUniqueCharInSequence.insert('g');
        firstUniqueCharInSequence.insert('l');
        firstUniqueCharInSequence.insert('e');
        System.out.println(firstUniqueCharInSequence.firstAppearingOnce());
    }
}
