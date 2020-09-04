package com.tinytongtong.leetcodetest.targetoffer.question08;

/**
 * @Description: 剑指 Offer 08. 二叉树的下一个节点
 * 题目：给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * @Author tinytongtong
 * @Date 2020/9/4 4:05 PM
 * @Version
 */
public class NextNodeInBinaryTree {
    private static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(char val) {
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
     * 给定一个结点，查找中序遍历序列的下一个结点值
     *
     * @param pNode
     * @return
     */
    private static TreeNode findNextNodeInOrder(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果节点有右子节点，那么下一个节点就是它的右子树中的最左子节点
        // 如果结点没有右子节点，那么就需要从当前节点开始，沿着父节点依次向上遍历：
        // ——如果有父节点、并且当前节点是父节点的左子节点，那么这个父节点就是要找的节点。
        TreeNode pNext = null;
        if (pNode.right != null) {
            pNext = pNode.right;
            while (pNext.left != null) {
                pNext = pNext.left;
            }
        } else if (pNode.parent != null) {
            TreeNode pCurrent = pNode;
            TreeNode pParent = pNode.parent;
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }

    public static void main(String[] args) {
        // abc
        TreeNode aNode = new TreeNode('a');
        TreeNode bNode = new TreeNode('b');
        TreeNode cNode = new TreeNode('c');
        aNode.left = bNode;
        aNode.right = cNode;
        bNode.parent = aNode;
        cNode.parent = aNode;

        // de
        TreeNode dNode = new TreeNode('d');
        TreeNode eNode = new TreeNode('e');
        bNode.left = dNode;
        bNode.right = eNode;
        dNode.parent = bNode;
        eNode.parent = bNode;

        // fg
        TreeNode fNode = new TreeNode('f');
        TreeNode gNode = new TreeNode('g');
        cNode.left = fNode;
        cNode.right = gNode;
        fNode.parent = cNode;
        gNode.parent = cNode;

        // hi
        TreeNode hNode = new TreeNode('h');
        TreeNode iNode = new TreeNode('i');
        eNode.left = hNode;
        eNode.right = iNode;
        hNode.parent = eNode;
        iNode.parent = eNode;

        System.out.println(aNode);

        TreeNode aResult = findNextNodeInOrder(aNode);
        System.out.println("aNode next node: " + (aResult != null ? aResult.val : null));

        TreeNode bResult = findNextNodeInOrder(bNode);
        System.out.println("bNode next node: " + (bResult != null ? bResult.val : null));

        TreeNode cResult = findNextNodeInOrder(cNode);
        System.out.println("cNode next node: " + (cResult != null ? cResult.val : null));

        TreeNode dResult = findNextNodeInOrder(dNode);
        System.out.println("dNode next node: " + (dResult != null ? dResult.val : null));

        TreeNode eResult = findNextNodeInOrder(eNode);
        System.out.println("eNode next node: " + (eResult != null ? eResult.val : null));

        TreeNode fResult = findNextNodeInOrder(fNode);
        System.out.println("fNode next node: " + (fResult != null ? fResult.val : null));

        TreeNode gResult = findNextNodeInOrder(gNode);
        System.out.println("gNode next node: " + (gResult != null ? gResult.val : null));

        TreeNode hResult = findNextNodeInOrder(hNode);
        System.out.println("hNode next node: " + (hResult != null ? hResult.val : null));

        TreeNode iResult = findNextNodeInOrder(iNode);
        System.out.println("iNode next node: " + (iResult != null ? iResult.val : null));
    }
}
