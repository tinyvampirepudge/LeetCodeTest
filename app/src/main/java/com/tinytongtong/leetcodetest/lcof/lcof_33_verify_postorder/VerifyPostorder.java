package com.tinytongtong.leetcodetest.lcof.lcof_33_verify_postorder;

/**
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @Author wangjianzhou
 * @Date 2/23/22 10:19 PM
 * @Version
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        int[] postorder = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        boolean result = verifyPostorder.verifyPostorder(postorder);
        System.out.println(result);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return verifyCore(postorder, 0, postorder.length - 1);
    }

    public boolean verifyCore(int[] postorder, int start, int end) {
        // 只有一个元素，返回true
        if (start == end) {
            return true;
        }
        // 找到左子节点的个数
        int leftCount = 0;
        for (int i = start; i < end; i++) {
            if (postorder[i] > postorder[end]) {
                break;
            }
            leftCount++;
        }
        // 确定左右节点的范围
        int leftStart = start;
        int leftEnd = leftStart + leftCount - 1;
        int rightStart = leftEnd + 1;
        int rightEnd = end - 1;
        // 默认返回true，只有在有效范围内，且数据不合规，才返回false
        if (rightStart < rightEnd) {
            for (int i = rightStart; i <= rightEnd; i++) {
                if (postorder[i] < postorder[end]) {
                    return false;
                }
            }
        }
        // 左子树递归判断
        boolean leftValid = true;
        if (leftStart < leftEnd) {
            leftValid = verifyCore(postorder, leftStart, leftEnd);
        }
        // 右子树递归判断
        boolean rightValid = true;
        if (rightStart < rightEnd) {
            rightValid = verifyCore(postorder, rightStart, rightEnd);
        }
        return leftValid && rightValid;
    }
}
