package com.tinytongtong.leetcodetest.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度
 * @Author tinytongtong
 * @Date 2020/9/2 11:36 AM
 * @Version
 */
public class MaximumDepthOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归 DFS
     * 时间复杂度：O(n)，其中 nn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代 BFS
     *
     * @param root
     * @return
     */
    private static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        // 循环拿出本层所有的节点
        while (!queue.isEmpty()) {
            // 把每层所有节点都加入到队列中
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(9);
        root.left = node11;
        TreeNode node12 = new TreeNode(20);
        root.right = node12;
        TreeNode node21 = new TreeNode(15);
        TreeNode node22 = new TreeNode(7);
        node12.left = node21;
        node12.right = node22;

        int result = maxDepth(root);
        System.out.println(result);

        int result1 = maxDepthBFS(root);
        System.out.println(result1);
    }
}
