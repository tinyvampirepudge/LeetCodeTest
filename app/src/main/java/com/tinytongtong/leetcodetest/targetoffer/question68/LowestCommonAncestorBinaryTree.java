package com.tinytongtong.leetcodetest.targetoffer.question68;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @Author tinytongtong
 * @Date 2020/10/20 1:47 PM
 * @Version
 */
public class LowestCommonAncestorBinaryTree {
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
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinaryTree lca = new LowestCommonAncestorBinaryTree();
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(1);
        root.left = node11;
        root.right = node12;

        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(2);
        node11.left = node21;
        node11.right = node22;

        TreeNode node23 = new TreeNode(0);
        TreeNode node24 = new TreeNode(8);
        node12.left = node23;
        node12.right = node24;

        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(4);
        node22.left = node31;
        node22.right = node32;

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(root);
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println(result != null ? result.toString() : "null");
    }
}
