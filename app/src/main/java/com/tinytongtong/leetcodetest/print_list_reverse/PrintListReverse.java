package com.tinytongtong.leetcodetest.print_list_reverse;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 反转打印链表，不破坏原有链表结构
 * 剑指offer第五题
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author wangjianzhou@qding.me
 * @Date 2020-02-08 15:51
 * @Version
 */
public class PrintListReverse {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 使用栈来反转链表的顺序
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode originNode = new ListNode(0);
        int i = 1;
        ListNode node = originNode;
        while (i < 10) {
            ListNode listNode = new ListNode(i);
            node.next = listNode;
            node = listNode;
            i++;
        }

        ArrayList<Integer> result = printListFromTailToHead(originNode);
        System.out.println(String.format("result:%s", result.toString()));
    }
}
