package com.tinytongtong.leetcodetest.targetoffer.question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 头条面试题
 *  从上到下打印二叉树，每层的第一个节点
 * 分层打印
 * @Author tinytongtong
 * @Date 2020/11/25 10:11 AM
 * @Version
 */

public class PrintTreeFromTopToBottomLevelFirstNode {
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
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 下一层的节点数
        int nextLevel = 0;
        // 当前层中还没有打印的节点数
        int toBePrinted = 1;// 从root节点开始。
        List<Integer> list = new ArrayList<>();
        result.add(list);
        // 打印左侧第一个节点
        System.out.println(queue.peek().val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                // 如果下一层没有结点，就不添加list了
                if (nextLevel > 0) {
                    list = new ArrayList<>();
                    result.add(list);
                    // 打印左侧第一个节点
                    System.out.println(queue.peek().val);
                }
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
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
