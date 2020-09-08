package com.tinytongtong.leetcodetest.targetoffer.question25;

/**
 * @Description: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 剑指 Offer 25. 合并两个排序的链表
 * @Author tinytongtong
 * @Date 2020/9/8 2:14 PM
 * @Version
 */
public class MergeTwoSortedList {

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

    private static ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }

        ListNode dummy = new ListNode(0);
        ListNode pNode = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pNode.next = p1;
                p1 = p1.next;
            } else {
                pNode.next = p2;
                p2 = p2.next;
            }
            pNode = pNode.next;
            pNode.next = null;// 删除额外的结点
        }
        if (p1 != null) {
            pNode.next = p1;
        }
        if (p2 != null) {
            pNode.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode pNode2 = new ListNode(3);
        ListNode pNode3 = new ListNode(5);
        ListNode pNode4 = new ListNode(7);
        ListNode pNode5 = new ListNode(9);
        pHead.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = pNode5;
        System.out.println(pHead);

        ListNode p1Head = new ListNode(2);
        ListNode p1Node2 = new ListNode(4);
        ListNode p1Node3 = new ListNode(6);
        ListNode p1Node4 = new ListNode(8);
        ListNode p1Node5 = new ListNode(10);
        p1Head.next = p1Node2;
        p1Node2.next = p1Node3;
        p1Node3.next = p1Node4;
        p1Node4.next = p1Node5;
        System.out.println(p1Head);

        ListNode result = mergeTwoLists(pHead, p1Head);
        System.out.println(result);
    }
}
