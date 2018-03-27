package com.zjgsu.offer.SubstructureInTree;


public class SubstructureInTree {
    class BinaryTreeNode {
        int m_nValue;
        BinaryTreeNode m_pLeft;
        BinaryTreeNode m_pRight;
    }

    public static boolean hasSubTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        boolean result = false;
        //如果有空树
        if (!(pRoot1 == null) && !(pRoot2 == null)) {
            //如果值相等,开始比较子树
            if (pRoot1.m_nValue == pRoot2.m_nValue) {
                result = doseTree1HaveTree2(pRoot1,pRoot2);
            }
            //不相等,继续遍历
            if (!result) {
                result = hasSubTree(pRoot1.m_pLeft,pRoot2);
            }
            if (!result) {
                result = hasSubTree(pRoot1.m_pRight,pRoot2);
            }
        }
        return result;
    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        //特殊情况
        if (pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null) {
            return false;
        }
        if (pRoot1.m_nValue != pRoot2.m_nValue) {
            return false;
        }
        return doseTree1HaveTree2(pRoot1.m_pLeft,pRoot2.m_pLeft) &&
                doseTree1HaveTree2(pRoot1.m_pRight,pRoot2.m_pRight);
    }

    public static void main(String[] args) {

    }
}
