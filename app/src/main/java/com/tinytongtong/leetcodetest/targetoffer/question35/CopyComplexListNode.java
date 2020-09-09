package com.tinytongtong.leetcodetest.targetoffer.question35;

import org.w3c.dom.Node;

/**
 * @Description: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 剑指 Offer 35. 复杂链表的复制
 * @Author tinytongtong
 * @Date 2020/9/9 6:00 PM
 * @Version
 */
public class CopyComplexListNode {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ComplexTreeNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 分三步：克隆、链接、删除原节点
     *
     * @param head
     * @return
     */
    private static Node cloneComplexNode(Node head) {
        if (head == null) {
            return null;
        }
        copyNode(head);
        linkNode(head);
        return reLinkNode(head);
    }

    private static void copyNode(Node head) {
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }

    private static void linkNode(Node head) {
        while (head != null) {
            Node node = head.next;
            if (head.random !=null) {
                node.random = head.random.next;
            }
            head = node.next;
        }
    }

    private static Node reLinkNode(Node head) {
        Node result = head.next;
        head = head.next;
        while (head != null && head.next !=null) {
            Node node = head.next;
            head.next = node.next;
            head = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node pRoot1 = new Node(7);

        Node pNode2 = new Node(13);
        pRoot1.next = pNode2;

        Node pNode3 = new Node(11);
        pNode2.next = pNode3;

        Node pNode4 = new Node(10);
        pNode3.next = pNode4;

        Node pNode5 = new Node(1);
        pNode4.next = pNode5;

        pNode2.random = pRoot1;
        pNode3.random = pNode5;
        pNode4.random = pNode3;
        pNode5.random = pRoot1;

        System.out.println(cloneComplexNode(pRoot1));
    }
}
