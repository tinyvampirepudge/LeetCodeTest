package com.tinytongtong.leetcodetest.question_0098.binary_tree;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 * @Author tinytongtong
 * @Date 2020/9/2 2:31 PM
 * @Version
 */
public class ValidateBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        // 小于等于下届，不符合
        if (lower != null && lower >= val) {
            return false;
        }
        // 大于等于上届，不符合
        if (upper != null && upper <= val) {
            return false;
        }
        // 左子节点不符
        if (!helper(root.left, lower, val)) {
            return false;
        }
        // 右子节点不符
        if (!helper(root.right, val, upper)) {
            return false;
        }

        return true;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private static boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double preorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preorder) {
                return false;
            }
            preorder = root.val;
            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(3);
        root.left = treeNode11;
        root.right = treeNode12;

        boolean result = isValidBST1(root);
        System.out.println(result);

        TreeNode root1 = new TreeNode(10);
        TreeNode treeNode111 = new TreeNode(5);
        TreeNode treeNode112 = new TreeNode(15);
        root1.left = treeNode111;
        root1.right = treeNode112;
        TreeNode treeNode121 = new TreeNode(6);
        TreeNode treeNode122 = new TreeNode(20);
        treeNode112.left = treeNode121;
        treeNode112.right = treeNode122;

        boolean result1 = isValidBST1(root1);
        System.out.println(result1);

        TreeNode root2 = new TreeNode(0);

        boolean result2 = isValidBST1(root2);
        System.out.println(result2);
    }
}
