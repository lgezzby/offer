package com.zjgsu.offer.DeleteDuplicatedListNode;

/**
 * 删除链表中重复节点(数值)
 */
public class DeleteDuplicatedListNode {
    static class ListNode {
        int m_nValue;
        ListNode m_pNext;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        deleteDuplication(node);
    }

    private static void deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return;
        }

        ListNode pPreNode = null;
        ListNode pNode = pHead;

        while (pNode != null) {
            ListNode pNext = pNode.m_pNext;
            boolean needDelete = false;
            if (pNext != null && pNext.m_nValue == pNext.m_nValue) {
                needDelete = true;
            }

            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.m_pNext;
            }
            else {
                int value = pNode.m_nValue;
                ListNode pToBeDel = pNode;
                //删除重复节点
                while (pToBeDel != null && pToBeDel.m_nValue == value) {
                    pNext = pToBeDel.m_pNext;
                    pToBeDel = pNext;
                }
                if (pPreNode == null) {
                    pHead = pNext;
                }
                else {
                    pPreNode.m_pNext = pNext;
                }
                pNode = pNext;
            }

        }
    }
}
