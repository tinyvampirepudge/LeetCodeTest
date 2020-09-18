package com.tinytongtong.leetcodetest.targetoffer.question62;

import java.util.LinkedList;

/**
 * @Description: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 约瑟夫环问题
 * @Author tinytongtong
 * @Date 2020/9/17 11:37 PM
 * @Version
 */
public class CircleLastRemaining {

    /**
     * 使用环形链表解决
     *
     * @param n
     * @param m
     * @return
     */
    private static int lastRemainingByCycleLinked(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                if (index + 1 < list.size()) {
                    index++;
                } else {
                    index = 0;
                }
            }
            list.remove(index);
            if (index > list.size() - 1) {
                index = 0;
            }
        }
        return !list.isEmpty() ? list.peekFirst() : -1;
    }

    /**
     * 公式解法
     *
     * @param n
     * @param m
     * @return
     */
    private static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(lastRemainingByCycleLinked(5, 2));
        System.out.println(lastRemaining(5, 2));
    }
}
