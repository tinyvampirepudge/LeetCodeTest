package com.tinytongtong.leetcodetest.targetoffer.question22;


/**
 * @Description: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 剑指 Offer 22. 链表中倒数第k个节点
 * @Author tinytongtong
 * @Date 2020/9/8 7:55 AM
 * @Version
 */
public class KthNodeToTail {
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

    private static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        int index = 0;
        ListNode node1 = head;
        ListNode node2 = head;
        while (index < k) {
            if (node1 == null) {
                return null;
            }
            node1 = node1.next;
            index++;
        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode pNode2 = new ListNode(2);
        ListNode pNode3 = new ListNode(3);
        ListNode pNode4 = new ListNode(4);
        ListNode pNode5 = new ListNode(5);
        pHead.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        System.out.println(pHead);

        System.out.println(getKthFromEnd(pHead, 1));
    }
}
