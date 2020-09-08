package com.tinytongtong.leetcodetest.targetoffer.question23;


/**
 * @Description: 剑指 Offer 23. 链表中环的入口节点
 * @Author tinytongtong
 * @Date 2020/9/8 9:20 AM
 * @Version
 */
public class MeetingNodeInCycle {
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
                    '}';
        }
    }

    /**
     * 第一步确定是否有环
     * 快慢指针，找到环中任意一个节点
     *
     * @param head
     * @return
     */
    private static ListNode meetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode pFast = head;
        ListNode pSlow = head;
        while (pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast.val == pSlow.val) {
                result = pFast;
                break;
            }
        }
        return result;
    }

    /**
     * 第二步找到环的入口
     *
     * @param pHead
     * @return
     */
    private static ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode pMeeting = meetingNode(pHead);
        if (pMeeting == null) {
            return null;
        }
        // 先得到环节点的数目
        int count = 1;
        ListNode pNode = pMeeting.next;
        while (pNode.val != pMeeting.val) {
            pNode = pNode.next;
            count++;
        }
        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        // 快慢指针，找到入口节点
        while (count > 0) {
            pFast = pFast.next;
            count--;
        }
        while (pFast.val != pSlow.val) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
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
        pNode5.next = pNode4;
        System.out.println(pHead);

        System.out.println(entryNodeOfLoop(pHead));
    }
}
