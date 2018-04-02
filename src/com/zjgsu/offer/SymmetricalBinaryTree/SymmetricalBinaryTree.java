package com.zjgsu.offer.SymmetricalBinaryTree;

/**
 * 对称树
 */
public class SymmetricalBinaryTree {
    static class BinaryTreeNode{
        int m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }

    public static void main(String[] args) {
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.m_nValue = 5;
        node5.m_pLeft = null;
        node5.m_pRight = null;
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.m_nValue = 5;
        node4.m_pLeft = null;
        node4.m_pRight = null;
        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.m_nValue = 3;
        node3.m_pLeft = node5;
        node3.m_pRight = null;
        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.m_nValue = 3;
        node2.m_pLeft = null;
        node2.m_pRight = node4;
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.m_nValue = 1;
        node1.m_pLeft = node3;
        node1.m_pRight = node2;
        System.out.println(isSymmetrical(node1,node1));
    }

    private static boolean isSymmetrical(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.m_nValue != pRoot2.m_nValue) {
            return false;
        }
        return isSymmetrical(pRoot1.m_pLeft, pRoot2.m_pRight) &&
                isSymmetrical(pRoot1.m_pRight, pRoot2.m_pLeft);
    }
}
