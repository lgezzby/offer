package com.zjgsu.offer.BalancedBinaryTree;

/**
 * 树的深度
 */
public class BalancedBinaryTree {
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
        System.out.println(checkBlancedTree(node1));
    }

    private static boolean checkBlancedTree(BinaryTreeNode root) {
        if(root == null){
            return false;
        }
        if (isBalancedTree(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private static int isBalancedTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        //后序遍历,如果该节点的左右节点都是平衡树
        int left = isBalancedTree(root.m_pLeft);
        int right = isBalancedTree(root.m_pRight);
        int depth;
        if (left != -1 && right != -1) {
            int diff = left - right;
            //该节点也是平衡的
            if (diff >= -1 && diff <= 1) {
                depth = 1 + (left > right ? left : right);
                return depth;
            }
        }

        return -1;
    }
}
