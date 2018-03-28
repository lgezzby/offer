package com.zjgsu.offer.CopyComplexList;

public class CopyComplexList {
    static class ComplexListNode {
        int m_nValue;
        ComplexListNode m_pNext;
        ComplexListNode m_pSibling;
    }

    //复制节点,设置next
    public static void CloneNodes(ComplexListNode pHead) {
        if (pHead == null) {
            return;
        }
        ComplexListNode pNode = pHead;
        //复制一遍节点,紧跟在node后面,sibling为空
        while (pNode != null) {
            ComplexListNode pCloned = new ComplexListNode();
            pCloned.m_nValue = pNode.m_nValue;
            pCloned.m_pNext = pNode.m_pNext;
            pCloned.m_pSibling = null;

            pNode.m_pNext = pCloned;
            pNode = pCloned.m_pNext;
        }
    }

    //设置sibling
    public static void ConnectSiblingNodes(ComplexListNode pHead) {
        if (pHead == null) {
            return;
        }
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = pNode.m_pNext;
            if (pNode.m_pSibling != null) {
                pCloned.m_pSibling = pNode.m_pSibling.m_pNext;
            }
            pNode = pCloned.m_pNext;
        }
    }

    //分开成两个链表
    public static ComplexListNode DisconnectNodes(ComplexListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;
        ComplexListNode pNode = pHead;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.m_pNext;
            pNode.m_pNext = pClonedNode.m_pNext;
            pNode = pNode.m_pNext;
        }

        while (pNode != null) {
            pClonedNode.m_pNext = pNode.m_pNext;
            pClonedNode = pClonedHead.m_pNext;
            pNode.m_pNext = pClonedNode.m_pNext;
            pNode = pNode.m_pNext;
        }
        return pClonedHead;
    }

    public static void main(String[] args) {
        CloneNodes(null);
        ConnectSiblingNodes(null);
        DisconnectNodes(null);
    }
}
