package com.tinytongtong.leetcodetest.targetoffer.question06;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 剑指 Offer 06. 从尾到头打印链表
 * @Author tinytongtong
 * @Date 2020/9/4 9:18 AM
 * @Version
 */
public class ReversePrintLinked {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 用栈实现
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    private static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i < 10; i++) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = node;
        }

        int[] result = reversePrint(head);
        System.out.println(Arrays.toString(result));
    }
}
