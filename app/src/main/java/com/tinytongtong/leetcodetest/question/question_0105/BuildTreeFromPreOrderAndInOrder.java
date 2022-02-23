package com.tinytongtong.leetcodetest.question.question_0105;

import java.util.ArrayList;

/**
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author wangjianzhou
 * @Date 2022/2/23 5:23 PM
 */
public class BuildTreeFromPreOrderAndInOrder {

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 3, 1};
        BuildTreeFromPreOrderAndInOrder buildTree = new BuildTreeFromPreOrderAndInOrder();
        TreeNode tree = buildTree.buildTree(preorder, inorder);
        buildTree.logTree(tree);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd || preStart < 0 || preEnd >= preorder.length
                || inStart < 0 || inEnd >= inorder.length) return null;
        // 查找root的值。前序遍历的第一个数据就是
        int midNodeValue = preorder[preStart];
        // 在中序遍历的数组中，找到root值的位置。借此区分出左子树的数据，进而区分右子树的数据。
        int midNodeIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (midNodeValue == inorder[i]) {
                midNodeIndex = i;
                break;
            }
        }
        int leftCount = midNodeIndex - inStart;
        TreeNode left = buildNode(preorder, inorder, preStart + 1, preStart + leftCount, inStart, inStart + leftCount - 1);
        TreeNode right = buildNode(preorder, inorder, preStart + leftCount + 1, preEnd, inStart + leftCount + 1, inEnd);
        TreeNode node = new TreeNode(midNodeValue, left, right);
        return node;
    }

    private void logTree(TreeNode tree) {
        ArrayList<Integer> result = new ArrayList<>();
        if (tree == null) {
            System.out.println(result);
            return;
        }
        logTreeCore(tree, result);
        System.out.println(result);
    }

    private void logTreeCore(TreeNode tree, ArrayList<Integer> result) {
        if (tree == null) {
            result.add(null);
            return;
        }
        result.add(tree.val);
        logTreeCore(tree.left, result);
        logTreeCore(tree.right, result);
    }

    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
