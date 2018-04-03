package com.zjgsu.offer.PrintTreeInLine;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印二叉树
 * (队列实现层次遍历)
 */
public class PrintTreeInline {
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

        printTrees(node1);
    }

    //打印
    private static void printTrees(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        //Queue --> LinkedList实现
        //ArrayDeque 双向链表
        Queue queue = new LinkedList();
//        ArrayDeque deque = new ArrayDeque();
        queue.offer(root);
        int curLine = 1;
        int nextLine = 0;
        //队列不为空,则输出并放入下一层
        while (!queue.isEmpty()) {
            BinaryTreeNode node = (BinaryTreeNode) queue.remove();
            curLine--;
            System.out.print(node.m_nValue + " ");

            if (node.m_pLeft != null) {
                queue.offer(node.m_pLeft);
                nextLine++;
            }
            if (node.m_pRight != null) {
                queue.offer(node.m_pRight);
                nextLine++;
            }

            //如果当前层已经输出完毕
            if (curLine == 0) {
                System.out.println();
                curLine = nextLine;
                nextLine = 0;
            }
        }
    }
}
