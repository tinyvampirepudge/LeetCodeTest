package com.tinytongtong.leetcodetest.targetoffer.question68;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description: 剑指offer 68 变种2：普通的树
 * @Author tinytongtong
 * @Date 2020/10/20 4:43 PM
 * @Version
 */
public class LowestCommonAncestorTree {
    private static class TreeNode {
        String val;
        ArrayList<TreeNode> children = new ArrayList<>();

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val='" + val + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

    /**
     * 不是目标结点，
     * ——没有子节点，则从链中移除
     * ——子节点中都不包含目标结点，则从链中移除该节点
     * 是目标结点，则添加到链中，返回即可。
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
        // 获取到对应的链
        LinkedList<TreeNode> listP = new LinkedList<>();
        LinkedList<TreeNode> listQ = new LinkedList<>();
        getNodePath(root, p, listP);
        getNodePath(root, q, listQ);
        // 寻找最小的公共子节点
        return getLastCommonNode(listP, listQ);
    }

    /**
     * 寻找最小的公共子节点，包含自身
     *
     * @param listP
     * @param listQ
     * @return
     */
    public TreeNode getLastCommonNode(LinkedList<TreeNode> listP, LinkedList<TreeNode> listQ) {
        TreeNode pLast = null;
        while (!listP.isEmpty() && !listQ.isEmpty()) {
            TreeNode node = listP.removeFirst();
            if (node.val.equals(listQ.removeFirst().val)) {
                pLast = node;
            }
        }
        return new TreeNode(pLast != null ? pLast.val : null);
    }

    /**
     * 公共父节点，包括自身
     *
     * @param root
     * @param targetNode
     * @param list
     * @return
     */
    public boolean getNodePath(TreeNode root, TreeNode targetNode, LinkedList<TreeNode> list) {
        list.addLast(root);
        if (root.val.equals(targetNode.val)) {
            return true;
        }
        boolean found = false;
        if (root.children != null && !root.children.isEmpty()) {
            Iterator<TreeNode> iterator = root.children.iterator();
            while (!found && iterator.hasNext()) {
                found = getNodePath(iterator.next(), targetNode, list);
            }
        }
        if (!found) {
            list.removeLast();
        }
        return found;
    }

    public static void main(String[] args) {
        LowestCommonAncestorTree lca = new LowestCommonAncestorTree();
        TreeNode root = new TreeNode("A");
        TreeNode node11 = new TreeNode("B");
        TreeNode node12 = new TreeNode("C");
        root.children.add(node11);
        root.children.add(node12);

        TreeNode node21 = new TreeNode("D");
        TreeNode node22 = new TreeNode("E");
        node11.children.add(node21);
        node11.children.add(node22);

        TreeNode node31 = new TreeNode("F");
        TreeNode node32 = new TreeNode("G");
        node21.children.add(node31);
        node21.children.add(node32);

        TreeNode node33 = new TreeNode("H");
        TreeNode node34 = new TreeNode("I");
        TreeNode node35 = new TreeNode("J");
        node22.children.add(node33);
        node22.children.add(node34);
        node22.children.add(node35);

        TreeNode p = new TreeNode("F");
        TreeNode q = new TreeNode("A");
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println(result != null ? result.toString() : "null");
    }
}
