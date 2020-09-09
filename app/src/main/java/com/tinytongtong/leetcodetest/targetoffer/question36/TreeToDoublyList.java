package com.tinytongtong.leetcodetest.targetoffer.question36;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * @Author tinytongtong
 * @Date 2020/9/9 9:43 PM
 * @Version
 */
public class TreeToDoublyList {
    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    private static Node head, prev;

    private static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        convertCore(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private static void convertCore(Node root) {
        if (root == null) {
            return;
        }
        convertCore(root.left);
        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }
        root.left = prev;
        prev = root;
        convertCore(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node11 = new Node(6);
        Node node12 = new Node(14);
        root.left = node11;
        root.right = node12;
        Node node21 = new Node(4);
        Node node22 = new Node(8);
        node11.left = node21;
        node11.right = node22;
        Node node23 = new Node(12);
        Node node24 = new Node(16);
        node12.left = node23;
        node12.right = node24;

        System.out.println(root);
        Node result = treeToDoublyList(root);
        System.out.println(result);
    }
}
