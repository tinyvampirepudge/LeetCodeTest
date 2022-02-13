package com.tinytongtong.leetcodetest.question.question_0844;

import java.util.Stack;

/**
 * @Description: 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * @Author tinytongtong
 * @Date 2020/10/19 4:29 PM
 * @Version
 */
public class Q844_BackspaceStringCompare {
    /**
     * 用栈
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompareByStack(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int indexS = 0;
        while (indexS < s.length()) {
            if (s.charAt(indexS) != '#') {
                stack1.add(s.charAt(indexS));
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
            indexS++;
        }
        int indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) != '#') {
                stack2.add(t.charAt(indexT));
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
            indexT++;
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针解法，从后往前遍历
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompareByTwoPointers(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        int skip1 = 0;
        int skip2 = 0;
        while (p1 >= 0 || p2 >= 0) {
            // 找一个有效字符
            while (p1 >= 0) {
                if (s.charAt(p1) == '#') {
                    skip1++;
                    p1--;
                } else if (skip1 > 0) {
                    skip1--;
                    p1--;
                } else {// 普通字符且skip为0
                    break;
                }
            }
            while (p2 >= 0) {
                if (t.charAt(p2) == '#') {
                    skip2++;
                    p2--;
                } else if (skip2 > 0) {
                    skip2--;
                    p2--;
                } else {
                    break;
                }
            }
            if (p1 >= 0 && p2 >= 0) {
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                }
            } else {
                if (p1 >= 0 || p2 >= 0) {
                    return false;
                }
            }
            p1--;
            p2--;
        }
        return true;
    }

    /**
     * 福写的
     *
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int n = T.length() - 1;

        int tempS = 0, tempT = 0;

        while (s >= 0 || n >= 0) {

            while (s >= 0) {
                if (S.charAt(s) == '#') {
                    tempS++;
                    s--;
                } else if (tempS > 0) {
                    tempS--;
                    s--;
                } else {
                    break;
                }
            }
            while (n >= 0) {
                if (T.charAt(n) == '#') {
                    tempT++;
                    n--;
                } else if (tempT > 0) {
                    tempT--;
                    n--;
                } else {
                    break;
                }
            }

            if (s >= 0 && n >= 0) {
                if (S.charAt(s) != T.charAt(n)) {
                    return false;
                }
            } else {
                if (s >= 0 || n >= 0) {
                    return false;
                }
            }
            s--;
            n--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println(backspaceCompareByStack(s1, t1));
        System.out.println(backspaceCompareByTwoPointers(s1, t1));
        System.out.println(backspaceCompare(s1, t1));
        System.out.println("-------------------------------");

        String s2 = "ab##";
        String t2 = "c#d#";
        System.out.println(backspaceCompareByStack(s2, t2));
        System.out.println(backspaceCompareByTwoPointers(s2, t2));
        System.out.println(backspaceCompare(s2, t2));
        System.out.println("-------------------------------");

        String s3 = "a##c";
        String t3 = "#a#c";
        System.out.println(backspaceCompareByStack(s3, t3));
        System.out.println(backspaceCompareByTwoPointers(s3, t3));
        System.out.println(backspaceCompare(s3, t3));
        System.out.println("-------------------------------");

        String s4 = "a#c";
        String t4 = "b";
        System.out.println(backspaceCompareByStack(s4, t4));
        System.out.println(backspaceCompareByTwoPointers(s4, t4));
        System.out.println(backspaceCompare(s4, t4));
        System.out.println("-------------------------------");

        String s5 = "bxj##tw";
        String t5 = "bxo#j##tw";
        System.out.println(backspaceCompareByStack(s5, t5));
        System.out.println(backspaceCompareByTwoPointers(s5, t5));
        System.out.println(backspaceCompare(s5, t5));
        System.out.println("-------------------------------");
    }
}
