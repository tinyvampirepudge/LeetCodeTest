package com.tinytongtong.leetcodetest.targetoffer.question26;

import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 剑指 Offer 26. 树的子结构
 * @Author tinytongtong
 * @Date 2020/9/8 2:47 PM
 * @Version
 */
public class SubStructureOfTree {
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
     * B是否是A的子结构
     * 第一步，先跟B的根节点比对，如果相同，就往下找
     * 第二步，比较子树
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean isSubStructure(TreeNode pRoot1, TreeNode pRoot2) {
        boolean result = false;
        if (pRoot1 != null && pRoot2 != null) {
            if (pRoot1.val == pRoot2.val) {
                result = doesTree1HaveTree2(pRoot1, pRoot2);
            }
            if (!result) {
                result = isSubStructure(pRoot1.left, pRoot2);
            }
            if (!result) {
                result = isSubStructure(pRoot1.right, pRoot2);
            }
        }
        return result;
    }

    /**
     * 递归解法
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean doesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
    }

    /**
     * 迭代解法
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean isSubStructureByIteration(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        boolean result = false;
        // 树的前序遍历，需要借助Stack
        Stack<TreeNode> stack = new Stack<>();
        // 添加根节点
        stack.push(pRoot2);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result = doesTree1HaveTree2ByIteration(node, pRoot2);
            if (result) {
                return true;
            }
            if (node != null) {
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }

    /**
     * 迭代解法
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean doesTree1HaveTree2ByIteration(TreeNode pRoot1, TreeNode pRoot2) {
        // 对 pRoot2 做中序遍历，同步比较 pRoot1 的节点
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot1);
        stack2.push(pRoot2);
        while (!stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1.val != node2.val) {
                return false;
            }
            if (node2.left != null) {
                if (node1.left != null && node1.left.val == node2.left.val) {
                    stack1.push(node1.left);
                    stack2.push(node2.left);
                } else {
                    return false;
                }
            }
            if (node2.right != null) {
                if (node1.right != null && node1.right.val == node2.right.val) {
                    stack1.push(node1.right);
                    stack2.push(node2.right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode pRoot1 = new TreeNode(8);
        TreeNode pNode11 = new TreeNode(8);
        TreeNode pRoot12 = new TreeNode(7);
        pRoot1.left = pNode11;
        pRoot1.right = pRoot12;
        TreeNode pNode21 = new TreeNode(9);
        TreeNode pRoot22 = new TreeNode(2);
        pNode11.left = pNode21;
        pNode11.right = pRoot22;
        TreeNode pNode31 = new TreeNode(4);
        TreeNode pRoot32 = new TreeNode(7);
        pRoot22.left = pNode31;
        pRoot22.right = pRoot32;

        TreeNode pRoot2 = new TreeNode(8);
        TreeNode pNode211 = new TreeNode(8);
        TreeNode pRoot212 = new TreeNode(7);
        pRoot2.left = pNode211;
        pRoot2.right = pRoot212;

        System.out.println(pRoot1);
        System.out.println(pRoot2);

        boolean result = isSubStructure(pRoot1, pRoot2);
        System.out.println(result);
        boolean result1 = doesTree1HaveTree2ByIteration(pRoot1, pRoot2);
        System.out.println(result1);
    }
}
