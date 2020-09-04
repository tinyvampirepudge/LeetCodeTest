package com.tinytongtong.leetcodetest.targetoffer.question07;

import java.util.HashMap;

/**
 * @Description: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 剑指 Offer 07. 重建二叉树
 * @Author tinytongtong
 * @Date 2020/9/4 10:31 AM
 * @Version
 */
public class RebuildBinaryTree {
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
     * 迭代实现
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode rebuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        // 利用HashMap定位
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildNode(map, preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    /**
     * 构建根节点，构建左子树，构建右子树
     *
     * @param preorder
     * @param inorder
     * @param startPre
     * @param endPre
     * @param startIn
     * @param endIn
     * @return
     */
    private static TreeNode buildNode(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre > endPre || startPre < 0 || endPre >= preorder.length || startIn < 0 || endIn >= preorder.length) {
            return null;
        }
        // 只有一个结点
        if (startPre == endPre) {
            return new TreeNode(preorder[startPre]);
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        // 或取根节点在中序遍历数组中的角标
        int rootIndex = map.get(preorder[startPre]);
        int leftCount = rootIndex - startIn;
        // 左节点
        root.left = buildNode(map, preorder, inorder, startPre + 1, startPre + leftCount, startIn, rootIndex - 1);
        // 有节点
        root.right = buildNode(map, preorder, inorder, startPre + leftCount + 1, endPre, rootIndex + 1, endIn);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = rebuildTree(preorder, inorder);
        System.out.println(result);
    }
}
