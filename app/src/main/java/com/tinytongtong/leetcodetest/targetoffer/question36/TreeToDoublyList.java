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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 最后一个节点
        Node[] pLast = new Node[1];
        midOrder(root, pLast);
        // 获取首节点
        while (pLast[0] != null && pLast[0].left != null) {
            pLast[0] = pLast[0].left;
        }
        return pLast[0];
    }

    private static void midOrder(Node root, Node[] pLast) {
        if (root == null) {
            return;
        }
        Node pCurrent = root;
        // 遍历左子节点
        if (pCurrent.left != null) {
            midOrder(pCurrent.left, pLast);
        }
        // 链接左子节点和中间节点
        pCurrent.left = pLast[0];
        if (pLast[0] != null) {
            pLast[0].right = pCurrent;
        }
        // 中间节点
        System.out.println(pCurrent.val);
        // 链接中间节点
        pLast[0] = pCurrent;
        // 遍历右子节点
        if (pCurrent.right != null) {
            midOrder(pCurrent.right, pLast);
        }
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
        System.out.println("从小到大：");
        Node pLast = null;
        while (result != null) {
            System.out.println(result.val);
            pLast = result;
            result = result.right;
        }
        System.out.println("从大到小：");
        while (pLast != null) {
            System.out.println(pLast.val);
            pLast = pLast.left;
        }
    }
}
