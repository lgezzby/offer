package com.zjgsu.offer.NextNodeInBinaryTrees;

/**
 * 二叉树的下一个节点
 * (中序遍历的下一个节点,节点有左右节点的指针和父节点的指针)
 */
public class NextNodeInBinaryTrees {
    static class BinaryTree {
        int m_nValue;
        BinaryTree m_pLeft;
        BinaryTree m_pRight;
        BinaryTree m_pParent;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        BinaryTree next = getNext(root);
    }

    //三种情况
    //当前节点有右子树,则下一个节点是右子树的最左节点
    //当前节点没有右子树,若当前节点是父节点的左子树,则下一个节点是父节点
    //当前节点没有右子树,且当前节点是父节点的右子树,则下一个节点是父节点往上第一个为左子树的父节点
    private static BinaryTree getNext(BinaryTree root) {
        if (root == null) {
            return null;
        }

        BinaryTree pNext = null;
        if (root.m_pRight != null) {
            BinaryTree pRight = root.m_pRight;
            while (pRight.m_pLeft != null) {
                pRight = pRight.m_pLeft;
            }

            pNext = pRight;
        }
        else if (root.m_pParent != null) {
            BinaryTree pCurrent = root;
            BinaryTree pParent = pCurrent.m_pParent;
            while (pParent != null && pParent.m_pRight == pCurrent) {
                pCurrent = pParent;
                pParent = pParent.m_pParent;
            }

            pNext = pParent;
        }

        return pNext;
    }
}
