package com.tinytongtong.leetcodetest.question2;

/**
 * @Description: 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author wangjianzhou
 * @Date 2022/2/8 6:23 PM
 * @Version
 */
public class AddTwoNumbers {

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        System.out.println(l1);

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        System.out.println(l2);

        ListNode ln = addTwoNumbers(l1, l2);
        System.out.println(ln);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 遍历l1和l2
        int extra = 0; // 进位
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (l1 != null || l2 != null || extra > 0) {
            // 构建新的node
            ListNode ln = new ListNode();
            // val相加
            if (l1 != null) ln.val += l1.val;
            if (l2 != null) ln.val += l2.val;
            // 累加extra的值
            if (extra > 0) {
                ln.val += extra;
            }
            // 重新计算extra的值
            extra = Math.max(ln.val / 10, 0);
            ln.val %= 10;
            // 组成新的链表
            head.next = ln;
            head = head.next;
            // 指向下一个指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
