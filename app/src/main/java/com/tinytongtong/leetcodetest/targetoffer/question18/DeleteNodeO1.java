package com.tinytongtong.leetcodetest.targetoffer.question18;

import java.util.Objects;

/**
 * @Description: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 剑指 Offer 18. 在O（1）时间删除链表结点
 * @Author tinytongtong
 * @Date 2020/9/7 11:26 AM
 * @Version
 */
public class DeleteNodeO1 {
    /**
     * Definition for singly-linked list.
     */
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    /**
     * 分三种情况：
     * ①如果pToBeDelete不是尾节点，就删除它。将它下一个节点的值赋值给pToBeDelete，同时pToBeDelete.next执行pToBeDelete.next.next
     * ②如果pToBeDelete是尾节点，则只能从头遍历，找到上一个pToBeDelete的上一个节点
     * ③如果pToBeDelete就是pHead，则将pHead置为null即可
     *
     * @param pHead
     * @param pToBeDelete
     */
    private static ListNode deleteNode(ListNode pHead, ListNode pToBeDelete) {
        if (pHead == null || pToBeDelete == null) {
            return null;
        }
        // 情况①
        if (pToBeDelete.next != null) {
            ListNode pNext = pToBeDelete.next;
            pToBeDelete.val = pNext.val;
            pToBeDelete.next = pNext.next;
            pNext = null;
        } else if (pHead == pToBeDelete) { // 情况③
            pHead = null;
            pToBeDelete = null;
        } else {// 情况②
            ListNode pNode = pHead;
            while (pNode.next != pToBeDelete) {
                pNode = pNode.next;
            }
            pNode.next = null;
            pToBeDelete = null;
        }
        return pHead;
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

        System.out.println(deleteNode(pHead, pNode5));
    }
}
