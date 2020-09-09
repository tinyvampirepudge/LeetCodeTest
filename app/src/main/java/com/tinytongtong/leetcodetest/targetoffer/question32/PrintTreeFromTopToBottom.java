package com.tinytongtong.leetcodetest.targetoffer.question32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * @Author tinytongtong
 * @Date 2020/9/9 11:16 AM
 * @Version
 */
public class PrintTreeFromTopToBottom {
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
     * 从上到下打印二叉树
     * 借助队列，先入先出
     *
     * @return
     */
    private static int[] printTree(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
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

        int[] result = printTree(pRoot1);
        System.out.println(Arrays.toString(result));
    }
}
