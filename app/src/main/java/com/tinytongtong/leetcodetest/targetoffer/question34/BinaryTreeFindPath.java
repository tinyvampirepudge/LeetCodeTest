package com.tinytongtong.leetcodetest.targetoffer.question34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * @Author tinytongtong
 * @Date 2020/9/9 4:46 PM
 * @Version
 */
public class BinaryTreeFindPath {
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

    private static List<List<Integer>> pathSum(TreeNode root, int expectedSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int currentSum = 0;
        LinkedList<TreeNode> path = new LinkedList<>();
        findCore(root, result, expectedSum, currentSum, path);
        return result;
    }

    private static void findCore(TreeNode root, List<List<Integer>> result, int expectedSum, int currentSum, LinkedList<TreeNode> path) {
        currentSum += root.val;
        path.addLast(root);
        boolean isLeaf = root.left == null && root.right == null;
        // 如果是叶子节点，并且路径上的节点值的和等于输入的值，则添加这条路径
        if (currentSum == expectedSum && isLeaf) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode item : path) {
                list.add(item.val);
            }
            result.add(list);
        }

        if (root.left != null) {
            findCore(root.left, result, expectedSum, currentSum, path);
        }
        if (root.right != null) {
            findCore(root.right, result, expectedSum, currentSum, path);
        }

        // 返回父节点之前，在路径上删除当前节点
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode pRoot1 = new TreeNode(5);
        TreeNode pNode11 = new TreeNode(4);
        TreeNode pRoot12 = new TreeNode(8);
        pRoot1.left = pNode11;
        pRoot1.right = pRoot12;

        TreeNode pNode21 = new TreeNode(11);
        pNode11.left = pNode21;

        TreeNode pNode23 = new TreeNode(13);
        TreeNode pRoot24 = new TreeNode(4);
        pRoot12.left = pNode23;
        pRoot12.right = pRoot24;

        TreeNode pNode31 = new TreeNode(7);
        TreeNode pRoot32 = new TreeNode(2);
        pNode21.left = pNode31;
        pNode21.right = pRoot32;

        TreeNode pNode33 = new TreeNode(5);
        TreeNode pRoot34 = new TreeNode(1);
        pRoot24.left = pNode33;
        pRoot24.right = pRoot34;

        System.out.println(pRoot1);

        List<List<Integer>> result = pathSum(pRoot1, 22);
        System.out.println(result);
    }
}
