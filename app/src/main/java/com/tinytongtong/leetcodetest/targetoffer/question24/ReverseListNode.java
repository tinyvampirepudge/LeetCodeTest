package com.tinytongtong.leetcodetest.targetoffer.question24;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 剑指 Offer 24. 反转链表
 * @Author tinytongtong
 * @Date 2020/9/8 10:48 AM
 * @Version
 */
public class ReverseListNode {
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
     * 迭代实现
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param pHead
     * @return
     */
    private static ListNode reverseListByIteration(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pCurr = pHead.next;
        ListNode pPrev = pHead;
        pPrev.next = null; // 避免野指针
        ListNode pNext = null;
        while (pCurr != null) {
            pNext = pCurr.next;
            // reverse
            pCurr.next = pPrev;
            pPrev = pCurr;
            pCurr = pNext;
        }
        return pPrev;
    }

    /**
     * 递归实现
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    private static ListNode reverseListByRecursive(ListNode head) {
        // 元素为空、或者是最后一个元素
        if (head == null || head.next == null) return head;
        // 递归处理好新链表，前面的数据。
        ListNode newHead = reverseListByRecursive(head.next);
        // reverse
        head.next.next = head;
        head.next = null; // 防止形成环
        return newHead; // 返回新链表中的前一个指针
    }

    /**
     * 用栈实现
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param pHead
     * @return
     */
    private static ListNode reverseListByStack(ListNode pHead) {
        while (pHead == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.push(new ListNode(pHead.val));
            pHead = pHead.next;
        }
        ListNode pResult = new ListNode(0);
        ListNode pNode = pResult;
        while (!stack.isEmpty()) {
            pNode.next = stack.pop();
            pNode = pNode.next;
        }
        return pResult.next;
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

//        System.out.println(reverseListByStack(pHead));
//        System.out.println(reverseListByIteration(pHead));
        System.out.println(reverseListByRecursive(pHead));
    }
}
