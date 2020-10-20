package com.tinytongtong.leetcodetest.targetoffer.question68;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @Author tinytongtong
 * @Date 2020/10/20 1:31 PM
 * @Version
 */
public class LowestCommonAncestorBinarySearchTree {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinarySearchTree lca = new LowestCommonAncestorBinarySearchTree();
        TreeNode root = new TreeNode(6);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(8);
        root.left = node11;
        root.right = node12;

        TreeNode node21 = new TreeNode(0);
        TreeNode node22 = new TreeNode(4);
        node11.left = node21;
        node11.right = node22;

        TreeNode node23 = new TreeNode(7);
        TreeNode node24 = new TreeNode(9);
        node12.left = node23;
        node12.right = node24;

        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(5);
        node22.left = node31;
        node22.right = node32;

        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(3);
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println(result != null ? result.toString() : "null");
    }
}
