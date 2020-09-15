package com.tinytongtong.leetcodetest.targetoffer.question55;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 剑指 Offer 55 - I. 二叉树的深度
 * @Author tinytongtong
 * @Date 2020/9/15 10:23 AM
 * @Version
 */
public class BinaryTreeDepth {
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
     * 从下往上遍历
     *
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left = node11;
        root.right = node12;

        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        TreeNode node23 = new TreeNode(6);
        node11.left = node21;
        node11.right = node22;
        node12.right = node23;

        TreeNode node31 = new TreeNode(7);
        node22.left = node31;

        System.out.println(root);

        System.out.println(maxDepth(root));
    }
}
