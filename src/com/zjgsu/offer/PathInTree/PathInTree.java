package com.zjgsu.offer.PathInTree;

import java.util.Stack;

/**
 * 输出和为某个值的树路径
 */
public class PathInTree {
    static class BinaryTreeNode{
        int m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }

    public static void findPath(BinaryTreeNode root,int expectedValue,Stack<Integer> currentPath,int currentSum) {
        //为空返回
        if (root == null){
            return;
        }
        currentPath.push(root.m_nValue);
        currentSum += root.m_nValue;
        //如果值相等,输出路径(并且还是叶子节点)
        if (currentSum == expectedValue && root.m_pLeft == null && root.m_pRight == null) {
            for (int value : currentPath) {
                System.out.println(value);
            }
        }

        //如果不相等,继续遍历左右子树
        if (root.m_pLeft != null) {
            findPath(root.m_pLeft,expectedValue,currentPath,currentSum);
        }
        if (root.m_pRight != null) {
            findPath(root.m_pRight,expectedValue,currentPath,currentSum);
        }

        //当前结点遍历回来,删除路径,重新计算值
        currentPath.pop();
        currentSum -= root.m_nValue;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.m_nValue = 4;
        node4.m_pLeft = null;
        node4.m_pRight = null;
        BinaryTreeNode node7 = new BinaryTreeNode();
        node7.m_nValue = 7;
        node7.m_pLeft = null;
        node7.m_pRight = null;
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.m_nValue = 5;
        node5.m_pLeft = node4;
        node5.m_pRight = node7;
        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.m_nValue = 12;
        node12.m_pLeft = null;
        node12.m_pRight = null;
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.m_nValue = 10;
        node10.m_pLeft = node5;
        node10.m_pRight = node12;
        Stack<Integer> stack = new Stack<>();
        findPath(node10,22,stack,0);
    }
}
