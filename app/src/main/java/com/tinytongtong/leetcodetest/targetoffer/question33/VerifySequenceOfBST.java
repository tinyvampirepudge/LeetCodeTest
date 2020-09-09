package com.tinytongtong.leetcodetest.targetoffer.question33;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @Author tinytongtong
 * @Date 2020/9/9 3:33 PM
 * @Version
 */
public class VerifySequenceOfBST {
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

    private static boolean verify(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return verifyCore(postorder, 0, postorder.length - 1);
    }

    private static boolean verifyCore(int[] postorder, int start, int end) {
        if (start == end) {
            return true;
        }
        // 确定左子树的范围
        int leftCount = 0;
        for (int i = start; i <= end - 1; i++) {
            if (postorder[i] > postorder[end]) {
                break;
            }
            leftCount++;
        }
        int leftStart = start;
        int leftEnd = start + leftCount - 1;
        int rightStart = start + leftCount;
        int rightEnd = end - 1;

        // 验证右子树数据
        if (rightEnd > rightStart) {
            for (int i = rightStart; i <= rightEnd; i++) {
                if (postorder[i] < postorder[end]) {
                    return false;
                }
            }
        }
        boolean leftResult = true;
        if (leftEnd > leftStart) {
            leftResult = verifyCore(postorder, leftStart, leftEnd);
        }
        boolean rightResult = true;
        if (rightStart < rightEnd) {
            rightResult = verifyCore(postorder, rightStart, rightEnd);
        }
        return leftResult && rightResult;
    }

    public static void main(String[] args) {
//        int[] postorder = new int[]{1, 2, 3, 6, 5};
//        int[] postorder = new int[]{1, 6, 3, 2, 5};
        int[] postorder = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        boolean result = verify(postorder);
        System.out.println(result);
    }
}
