package com.tinytongtong.leetcodetest.targetoffer.question54;

/**
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * @Author tinytongtong
 * @Date 2020/9/15 9:05 AM
 * @Version
 */
public class kthLargestNode {
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
     * 中序遍历，就是从小到大排序
     * 反向中序遍历，就是从大到小排序
     *
     * @param root
     * @param k
     * @return
     */
    private static int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        int[] result = new int[1];
        int[] index = new int[1];
        index[0] = 1;
        kthLargestCore(root, k, result, index);
        return result[0];
    }

    private static void kthLargestCore(TreeNode root, int k, int[] result, int[] index) {
        if (root == null) {
            return;
        }
        kthLargestCore(root.right, k, result, index);
        if (index[0] == k) {
            result[0] = root.val;
        }
        index[0]++;
        kthLargestCore(root.left, k, result, index);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(4);
        root.left = node11;
        root.right = node12;
        TreeNode node21 = new TreeNode(2);
        node11.right = node21;

        System.out.println(root);

        System.out.println(kthLargest(root, 1));
    }
}
