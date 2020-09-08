package com.tinytongtong.leetcodetest.targetoffer.question27;


import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 剑指 Offer 27. 二叉树的镜像
 * @Author tinytongtong
 * @Date 2020/9/8 5:07 PM
 * @Version
 */
public class MirrorBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    private static TreeNode mirrorTreeByRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTreeByRecursive(root.left);
        mirrorTreeByRecursive(root.right);
        return root;
    }

    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    private static TreeNode mirrorTreeByIteration(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // swap
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode pRoot1 = new TreeNode(8);
        TreeNode pNode11 = new TreeNode(6);
        TreeNode pRoot12 = new TreeNode(10);
        pRoot1.left = pNode11;
        pRoot1.right = pRoot12;

        TreeNode pNode21 = new TreeNode(5);
        TreeNode pRoot22 = new TreeNode(7);
        pNode11.left = pNode21;
        pNode11.right = pRoot22;

        TreeNode pNode23 = new TreeNode(9);
        TreeNode pRoot24 = new TreeNode(11);
        pRoot12.left = pNode23;
        pRoot12.right = pRoot24;

        System.out.println(pRoot1);
        // 递归
//        System.out.println(mirrorTreeByRecursive(pRoot1));
        // 迭代
        System.out.println(mirrorTreeByIteration(pRoot1));
    }
}
