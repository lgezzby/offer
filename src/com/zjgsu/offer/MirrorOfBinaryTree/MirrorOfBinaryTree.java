package com.zjgsu.offer.MirrorOfBinaryTree;

public class MirrorOfBinaryTree {
    public static class BinaryTreeNode {
        int m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }

    public static BinaryTreeNode mirroRecursively(BinaryTreeNode root) {
        //空指针情况
        if (root == null) {
            return null;
        }
        //镜像
        BinaryTreeNode tmp = root.m_pLeft;
        root.m_pLeft = root.m_pRight;
        root.m_pRight = tmp;

        root.m_pLeft = mirroRecursively(root.m_pLeft);
        root.m_pRight = mirroRecursively(root.m_pRight);

        return root;
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
        BinaryTreeNode root = mirroRecursively(node1);
    }
}
