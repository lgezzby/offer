package com.zjgsu.offer.PrintTreeInXZigzag;

import java.util.Stack;

/**
 * 之字形打印二叉树
 */
public class PrintTreeInXZigzag {
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

        printTreesInZigzag(node1);
    }

    //两个栈实现当前层和下一层
    private static void printTreesInZigzag(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        int flag = 0;
        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode>[] stacks = new Stack[]{stack1, stack2};
        stacks[flag].push(root);
        int curLine = 1;
        int nextLine = 0;

        while (!stacks[flag].empty() || !stacks[1-flag].empty()) {
            BinaryTreeNode node = (BinaryTreeNode) stacks[flag].pop();
            System.out.print(node.m_nValue + " ");
            curLine--;

            if (node.m_pLeft != null) {
                stacks[1-flag].push(node.m_pLeft);
                nextLine++;
            }
            if (node.m_pRight != null) {
                stacks[1-flag].push(node.m_pRight);
                nextLine++;
            }

            //当前层打印结束
            if (curLine == 0) {
                curLine = nextLine;
                nextLine = 0;
                System.out.println();
                flag = 1 - flag;
            }
        }
    }
}
