package com.tinytongtong.leetcodetest.question_0589;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 589. N叉树的前序遍历
 * @Author tinytongtong
 * @Date 2020/9/1 1:36 PM
 * @Version
 */
public class NAryTreePreorderTraversal {

    /**
     * Definition for a Node.
     */
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            // 拿尾部的元素
            Node node = nodes.pollLast();
            if (node == null) {
                return result;
            }
            result.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                // 精髓
                Collections.reverse(node.children);
                nodes.addAll(node.children);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node child111 = new Node(5);
        Node child112 = new Node(6);
        Node child11 = new Node(3, Arrays.asList(child111, child112));
        Node child12 = new Node(2);
        Node child13 = new Node(4);
        Node root = new Node(1, Arrays.asList(child11, child12, child13));

        List<Integer> list = preorder(root);
        System.out.println(list);
    }

}
