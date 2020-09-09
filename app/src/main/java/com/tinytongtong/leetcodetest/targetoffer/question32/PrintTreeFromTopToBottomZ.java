package com.tinytongtong.leetcodetest.targetoffer.question32;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/submissions/
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * Z字形打印
 * @Author tinytongtong
 * @Date 2020/9/9 11:16 AM
 * @Version
 */
public class PrintTreeFromTopToBottomZ {
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

    private static List<List<Integer>> printTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        // 当前行数
        int level = 1;
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            Stack<TreeNode> stackNotEmpty = !stack1.isEmpty() ? stack1 : stack2;
            Stack<TreeNode> stackEmpty = stack1.isEmpty() ? stack1 : stack2;
            while (!stackNotEmpty.isEmpty()) {
                TreeNode node = stackNotEmpty.pop();
                list.add(node.val);
                if ((level & 1) == 1) { // 奇数行，从左到右打印，从右到左添加
                    if (node.left != null) {
                        stackEmpty.push(node.left);
                    }
                    if (node.right != null) {
                        stackEmpty.push(node.right);
                    }
                } else { // 偶数行，从右到左打印，从左到右添加
                    if (node.right != null) {
                        stackEmpty.push(node.right);
                    }
                    if (node.left != null) {
                        stackEmpty.push(node.left);
                    }
                }

            }
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode pRoot1 = new TreeNode(1);
        TreeNode pNode11 = new TreeNode(2);
        TreeNode pRoot12 = new TreeNode(3);
        pRoot1.left = pNode11;
        pRoot1.right = pRoot12;

        TreeNode pNode21 = new TreeNode(4);
        TreeNode pRoot22 = new TreeNode(5);
        pNode11.left = pNode21;
        pNode11.right = pRoot22;

        TreeNode pNode23 = new TreeNode(6);
        TreeNode pRoot24 = new TreeNode(7);
        pRoot12.left = pNode23;
        pRoot12.right = pRoot24;
        System.out.println(pRoot1);

        List<List<Integer>> result = printTree(pRoot1);
        System.out.println(result);
    }
}
