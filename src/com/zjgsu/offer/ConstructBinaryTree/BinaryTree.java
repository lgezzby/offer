package com.zjgsu.offer.ConstructBinaryTree;

import java.util.Arrays;

public class BinaryTree {
    public static BinaryTreeNode construct(int[] preorder, int[] inorder, int length) throws Exception {
        if (preorder == null || inorder == null || length <= 0) {
            return null;
        }
        return constructCore(preorder, inorder);
    }

    public static BinaryTreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
        //判断异常情况
        if (preorder.length != inorder.length) {
            System.out.println("input error.");
            throw new Exception("字符串输入有误");
        }
        if (preorder == null && inorder == null || preorder.length == 0 && inorder.length == 0) {
            //叶子节点
            return null;
        }
        int rootValue = preorder[0];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.m_pLeft = null;
        root.m_pRight = null;
        boolean flag = false;
        //判断是否是根节点
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                flag = true;
                System.out.println(inorder[i]);
                //左子树
                root.m_pLeft = constructCore(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                //右子树
                root.m_pRight = constructCore(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
            }
            if (i == inorder.length - 1 && flag == false) {
                System.out.println("input error.");
                throw new Exception("字符串输入有误");
            }
        }

        return root;

    }

    public static void main(String[] args) throws Exception {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        //异常样例
//        int[] preorder = {1,2,3,4,5,6};
//        int[] inorder = {1,6,5,2,3,4};
        BinaryTreeNode root = construct(preorder, inorder, 8);
    }
}

class BinaryTreeNode {
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;

    public BinaryTreeNode(int m_nValue) {
        this.m_nValue = m_nValue;
    }
}
