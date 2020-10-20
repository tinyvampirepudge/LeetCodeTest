package com.tinytongtong.leetcodetest.targetoffer.question68;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 剑指offer 68 变种1：树中的节点有指向父节点的指针
 * @Author tinytongtong
 * @Date 2020/10/20 2:58 PM
 * @Version
 */
public class LowestCommonAncestorTreeWithParentPointer {

    private static class TreeNode {
        String val;
        TreeNode left;
        TreeNode mid;
        TreeNode right;
        TreeNode parent;

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val='" + val + '\'' +
                    ", left=" + left +
                    ", mid=" + mid +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 如果树中的每个节点（除根节点外）都有一个指向父节点的指针，那么这个问题可以转换成求两个链表的第一个公共节点。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        // 先通过后序遍历，找到所有的子节点
        ArrayList<TreeNode> childs = new ArrayList<>();
        postOrder(root, childs);
        // 在子节点的链表中查找目标元素，如果查找到了，就记录下这个节点。最终会找到两个对应的链表
        TreeNode pNode = null, qNode = null;
        for (int i = 0; i < childs.size(); i++) {
            TreeNode head = childs.get(i);
            while (head != null && (pNode == null || qNode == null)) {
                if (pNode == null && head.val.equals(p.val)) {
                    pNode = head;
                    continue;
                }
                if (qNode == null && head.val.equals(q.val)) {
                    qNode = head;
                    continue;
                }
                head = head.parent;
            }
            if (pNode != null && qNode != null) {
                break;
            }
        }
        // 找着两个链表的公共子节点，包含p、q自身
        if (pNode != null && qNode != null) {
            // 用栈将链存储起来，反转链表
            Stack<TreeNode> stackP = new Stack<>();
            Stack<TreeNode> stackQ = new Stack<>();
            while (pNode != null) {
                stackP.push(pNode);
                pNode = pNode.parent;
            }
            while (qNode != null) {
                stackQ.push(qNode);
                qNode = qNode.parent;
            }
            // 查找公共节点
            while (!stackP.isEmpty() && !stackQ.isEmpty()) {
                TreeNode tempP = stackP.pop();
                TreeNode tempQ = stackQ.pop();
                if (tempP == tempQ) {
                    if (stackP.isEmpty() || stackQ.isEmpty()) {
                        return tempP;
                    }
                    if (stackP.peek() != stackQ.peek()) {
                        return tempP;
                    }
                }
            }
        }
        return null;
    }

    public void postOrder(TreeNode root, ArrayList<TreeNode> childs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.mid == null && root.right == null) {
            childs.add(root);
        }
        if (root.left != null) {
            postOrder(root.left, childs);
        }
        if (root.mid != null) {
            postOrder(root.mid, childs);
        }
        if (root.right != null) {
            postOrder(root.right, childs);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorTreeWithParentPointer lca = new LowestCommonAncestorTreeWithParentPointer();
        TreeNode root = new TreeNode("A");
        TreeNode node11 = new TreeNode("B");
        TreeNode node12 = new TreeNode("C");
        root.left = node11;
        root.right = node12;
        node11.parent = root;
        node12.parent = root;

        TreeNode node21 = new TreeNode("D");
        TreeNode node22 = new TreeNode("E");
        node11.left = node21;
        node11.right = node22;
        node21.parent = node11;
        node22.parent = node11;

        TreeNode node31 = new TreeNode("F");
        TreeNode node32 = new TreeNode("G");
        node21.left = node31;
        node21.right = node32;
        node31.parent = node21;
        node32.parent = node21;

        TreeNode node33 = new TreeNode("H");
        TreeNode node34 = new TreeNode("I");
        TreeNode node35 = new TreeNode("J");
        node22.left = node33;
        node22.mid = node34;
        node22.right = node35;
        node33.parent = node22;
        node34.parent = node22;
        node35.parent = node22;

        TreeNode p = new TreeNode("F");
        TreeNode q = new TreeNode("A");
        System.out.println(root);
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println(result != null ? result.toString() : "null");
    }
}
