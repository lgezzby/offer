package com.zjgsu.offer.TreeDepth;

/**
 * 树的深度
 */
public class TreeDepth {
    static class BinaryTreeNode {
        int m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }
    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.m_nValue = 4;
        node4.m_pLeft = null;
        node4.m_pRight = null;
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.m_nValue = 5;
        node5.m_pLeft = null;
        node5.m_pRight = null;
        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.m_nValue = 2;
        node2.m_pLeft = node4;
        node2.m_pRight = node5;
        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.m_nValue = 3;
        node3.m_pLeft = null;
        node3.m_pRight = null;
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.m_nValue = 1;
        node1.m_pLeft = node2;
        node1.m_pRight = node3;
        System.out.println(getTreeDepth(node1));
    }

    private static int getTreeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = getTreeDepth(root.m_pLeft);
        int nRight = getTreeDepth(root.m_pRight);
        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }
}
