package com.tinytongtong.leetcodetest.targetoffer.question52;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * @Author tinytongtong
 * @Date 2020/9/14 4:52 PM
 * @Version
 */
public class FindFirstCommonNode {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 用辅助栈
     * 时间复杂度O(m + n)
     * 空间复杂度O(m + n)
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNodeByStack(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (headA != null) {
            stack1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stack2.push(headB);
            headB = headB.next;
        }
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() != stack2.peek()) {
                return result;
            }
            result = stack1.pop();
            stack2.pop();
        }
        return result;
    }

    /**
     * 用辅助栈
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = 0, sizeB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null) {
            sizeA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            sizeB++;
            nodeB = nodeB.next;
        }
        int delta = 0;
        if (sizeA > sizeB) {
            delta = sizeA - sizeB;
            while (delta > 0) {
                headA = headA.next;
                delta--;
            }
        } else {
            delta = sizeB - sizeA;
            while (delta > 0) {
                headB = headB.next;
                delta--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        headA.next = node2;
        node2.next = node3;

        ListNode headB = new ListNode(3);
//        ListNode node5 = new ListNode(3);
//        headB.next = node5;

        ListNode node4 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        node3.next = node4;
        headB.next = node4;

        node4.next = node6;

        System.out.println(headA);
        System.out.println(headB);

        System.out.println(getIntersectionNodeByStack(headA, headB));
        System.out.println(getIntersectionNode(headA, headB));
    }
}
