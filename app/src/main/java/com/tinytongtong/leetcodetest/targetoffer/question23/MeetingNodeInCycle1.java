package com.tinytongtong.leetcodetest.targetoffer.question23;


/**
 * @Description: 美团面试题：找到链表中环的入口节点，如果无环就返回空
 * @Author tinytongtong
 * @Date 2020/9/8 9:20 AM
 * @Version
 */
public class MeetingNodeInCycle1 {
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

    private static ListNode entryNodeOfLoop(ListNode head) {
        // 1、先根据快慢指针确定是否有环。如果有环就找到一个环内节点，如果没有就返回null
        ListNode cycleNode = findCycleNode(head);
        // 无环
        if (cycleNode == null) {
            return null;
        }
        // 2、然后确定环的个数n。快慢指针，相遇的时候，慢指针走过的距离
        int n = countCycleNodeNum(cycleNode);
        // 3、然后两个指针P1和P2，均指向链表头部节点，P1先移动n，然后P1和P2以相同的速度前进，它两相遇的节点就是入口节点。
        ListNode p1 = head, p2 = head;
        while (n > 0) {
            p1 = p1.next;
            n--;
        }
        while (p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 判断链表是否有环，如果有，就返回环中的一个node;
     * 如果没有就返回null;
     *
     * @param head
     * @return
     */
    private static ListNode findCycleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else { // 无环
                return null;
            }
            if (slow != null && fast != null && slow.val == fast.val) {
                return fast;
            }
        }
        return null;
    }

    /**
     * 统计环形链表中环的个数
     *
     * @param node
     * @return
     */
    private static int countCycleNodeNum(ListNode node) {
        if (node == null) {
            return 0;
        }
        int n = 1;
        ListNode slow = node.next;
        ListNode fast = node.next.next;
        while (slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next.next;
            n++;
        }
        return n;
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
        pNode5.next = pNode5;
        System.out.println(pHead);

        System.out.println(entryNodeOfLoop(pHead));
    }
}
