package com.tinytongtong.leetcodetest.question_0144;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 144. 二叉树的前序遍历
 * @Author tinytongtong
 * @Date 2020/9/1 3:27 PM
 * @Version
 */
public class BinaryTreePreorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollLast();
            if (node == null) {
                return result;
            }
            result.add(node.val);
            if (node.right != null) {
                nodes.add(node.right);
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node2.left = node3;
        TreeNode root = new TreeNode(1);
        root.right = node2;

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }
}
