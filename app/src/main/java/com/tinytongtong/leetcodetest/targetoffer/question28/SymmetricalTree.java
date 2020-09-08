package com.tinytongtong.leetcodetest.targetoffer.question28;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 剑指 Offer 28. 对称的二叉树
 * @Author tinytongtong
 * @Date 2020/9/8 5:48 PM
 * @Version
 */
public class SymmetricalTree {
    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer val) {
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
     *
     * @param pRoot
     * @return
     */
    private static boolean isSymmetricalByRecursive(TreeNode pRoot) {
        return isSymmetricalCore(pRoot, pRoot);
    }

    private static boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        return isSymmetricalCore(pRoot1.left, pRoot2.right) && isSymmetricalCore(pRoot1.right, pRoot2.left);
    }

    /**
     * 迭代解法
     * 对称前序遍历 和 前序遍历 的结果进行对比，包括子节点null。
     *
     * @param pRoot
     * @return
     */
    private static boolean isSymmetricalByIteration(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        // 前序遍历
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.push(pRoot);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            arrayList.add(node.val);
            if (node != null && node.val != null) {
                if (node.left == null) {
                    node.left = new TreeNode(null);
                }
                stack.push(node.left);
                if (node.right == null) {
                    node.right = new TreeNode(null);
                }
                stack.push(node.right);
            }
        }
        // 对称前序遍历，根右左
        Stack<TreeNode> stack1 = new Stack<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            arrayList1.add(node.val);
            if (node != null && node.val != null) {
                // 先添加右节点，再添加左节点
                if (node.right == null) {
                    node.right = new TreeNode(null);
                }
                stack1.push(node.right);
                if (node.left == null) {
                    node.left = new TreeNode(null);
                }
                stack1.push(node.left);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null && arrayList1.get(i) == null) {
                continue;
            }
            if (arrayList.get(i) == null || arrayList1.get(i) == null) {
                return false;
            }
            if (!arrayList.get(i).equals(arrayList1.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode pRoot1 = new TreeNode(8);
        TreeNode pNode11 = new TreeNode(6);
        TreeNode pRoot12 = new TreeNode(9);
        pRoot1.left = pNode11;
        pRoot1.right = pRoot12;

        TreeNode pNode21 = new TreeNode(5);
        TreeNode pRoot22 = new TreeNode(7);
        pNode11.left = pNode21;
        pNode11.right = pRoot22;

        TreeNode pNode23 = new TreeNode(7);
        TreeNode pRoot24 = new TreeNode(5);
        pRoot12.left = pNode23;
        pRoot12.right = pRoot24;

        System.out.println(pRoot1);
        // 递归
        System.out.println(isSymmetricalByRecursive(pRoot1));
        // 迭代
        System.out.println(isSymmetricalByIteration(pRoot1));
    }
}
