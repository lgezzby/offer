package com.zjgsu.offer.FindKthToTail;

public class FindKthToTail {
    static class ListNode {
        private int m_pValue;
        private ListNode m_pNext;
    }

    public static ListNode findKthToTail(ListNode head,int k) {
        //不为空
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pNode = head;
        ListNode kthNode = head;

        for (int i = 0; i < k-1; i++) {
            if (pNode.m_pNext != null) {
                pNode = pNode.m_pNext;
            } else {
                return null;
            }
        }

        while (pNode.m_pNext != null) {
            pNode = pNode.m_pNext;
            kthNode = kthNode.m_pNext;
        }
        return kthNode;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode();
        node5.m_pValue = 5;
        node5.m_pNext = null;
        ListNode node4 = new ListNode();
        node4.m_pValue = 4;
        node4.m_pNext = node5;
        ListNode node3 = new ListNode();
        node3.m_pValue = 3;
        node3.m_pNext = node4;
        ListNode node2 = new ListNode();
        node2.m_pValue = 2;
        node2.m_pNext = node3;
        ListNode node1 = new ListNode();
        node1.m_pValue = 1;
        node1.m_pNext = node2;
        System.out.println(findKthToTail(node1,3).m_pValue);
    }
}
