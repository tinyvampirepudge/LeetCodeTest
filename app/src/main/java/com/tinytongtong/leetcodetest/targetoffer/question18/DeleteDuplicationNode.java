package com.tinytongtong.leetcodetest.targetoffer.question18;

/**
 * @Description: 删除链表中重复的节点
 * 在一个排序链表中，如何删除重复的节点
 * @Author tinytongtong
 * @Date 2020/9/7 2:00 PM
 * @Version
 */
public class DeleteDuplicationNode {
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
     * 1233445 -> 125
     *
     * @param pHead
     */
    private static ListNode deleteDuplicate(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        // 首节点会变，pHead 跟 第一个pHead 相同
        // 最后返回的链表，是 pPreNode 串起来的
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        ListNode pResult = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            // 是否需要删除，如果需要删除的话，这几个节点都不会添加进 pPreNode
            boolean needDelete = false;
            if (pNext != null && pNode.val == pNext.val) {
                needDelete = true;
            }
            if (!needDelete) {
                if (pPreNode == null) {// 第一次添加
                    pPreNode = new ListNode(pNode.val);
                    pResult = pPreNode;
                } else {
                    pPreNode.next = new ListNode(pNode.val);
                    pPreNode = pPreNode.next;
                }
                pNode = pNode.next;
            } else {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                // 查找多个相同的节点
                while (pToBeDel != null && pToBeDel.val == value) {
                    pToBeDel = pToBeDel.next;
                }
                pNode = pToBeDel;
            }
        }
        return pResult;
    }

    /**
     * 1233445 -> 12345
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param pHead
     */
    private static ListNode deleteDuplicate1(ListNode pHead) {
        ListNode pNode = pHead;
        while (pNode != null) {
            if (pNode.next != null && pNode.val == pNode.next.val) {
                ListNode temp = pNode.next;
                pNode.next = temp.next;
                temp.next = null;// 清除野指针
            } else {
                pNode = pNode.next;
            }
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
//        deleteDuplicate(pHead);
        System.out.println(deleteDuplicate(pHead));
//        System.out.println(deleteDuplicate2(pHead));
    }
}
