package com.tinytongtong.leetcodetest.targetoffer.question37;


/**
 * @Description: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * 剑指 Offer 37. 序列化二叉树
 * @Author tinytongtong
 * @Date 2020/9/10 9:26 AM
 * @Version
 */
public class SerializeTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeTreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        serializeCore(root, sb);
        String result = sb.toString();
        if (result.length() > 1 && result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private static void serializeCore(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$,");
            return;
        }
        sb.append(root.val).append(",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    private static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        if (strs == null || strs.length == 0) {
            return null;
        }
        int[] index = new int[1];
        TreeNode dummy = new TreeNode(0);
        dummy.right = deserializeCore(strs, index);
        return dummy.right;
    }

    private static TreeNode deserializeCore(String[] strs, int[] index) {
        String s = strs[index[0]++];
        if ("$".equals(s)) {
            return null;
        } else {
            int val = Integer.valueOf(s);
            TreeNode root = new TreeNode(val);
            root.left = deserializeCore(strs, index);
            root.right = deserializeCore(strs, index);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode TreeNode11 = new TreeNode(2);
        TreeNode TreeNode12 = new TreeNode(3);
        root.left = TreeNode11;
        root.right = TreeNode12;
        TreeNode TreeNode21 = new TreeNode(4);
//        TreeNode TreeNode22 = new TreeNode(5);
        TreeNode11.left = TreeNode21;
//        TreeNode11.right = TreeNode22;
        TreeNode TreeNode23 = new TreeNode(5);
        TreeNode TreeNode24 = new TreeNode(6);
        TreeNode12.left = TreeNode23;
        TreeNode12.right = TreeNode24;

        System.out.println(root);
        String data = serialize(null);
        System.out.println(data);

        TreeNode pRoot = deserialize(data);
        System.out.println(pRoot);
    }
}
