package com.tinytongtong.leetcodetest.targetoffer.question55;

/**
 * @Description: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 剑指 Offer 55 - II. 平衡二叉树
 * @Author tinytongtong
 * @Date 2020/9/15 10:35 AM
 * @Version
 */
public class IsBalancedTree {
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

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int[] depth = new int[1];
        return isBalancedCore(root, depth);
    }

    private static boolean isBalancedCore(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1], right = new int[1];
        if (isBalancedCore(root.left, left) && isBalancedCore(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
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
        node31.left = new TreeNode(8);

        System.out.println(root);

        System.out.println(isBalanced(root));
    }
}
