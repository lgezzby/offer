package com.zjgsu.offer.ReverseList;

public class ReverseList {
    static class ListNode {
        private int m_pValue;
        private ListNode m_pNext;
    }

    /**
     * 循环实现
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //不为空
        if (head == null) {
            return null;
        }
        ListNode pPrev = null;
        ListNode pNode = head;
        ListNode pReverseHead = null;

        //遍历
        while (pNode != null) {
            ListNode pNext = pNode.m_pNext;
            //尾结点
            if (pNext == null) {
                pReverseHead = pNode;
            }
            //反转

            pNode.m_pNext = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode reverseListRecursively(ListNode head) {
        ListNode newHead;
        if (head == null || head.m_pNext == null) {
            return head;
        }
        newHead = reverseListRecursively(head.m_pNext);
        head.m_pNext.m_pNext = head;
        head.m_pNext = null;
        return newHead;
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
        System.out.println(reverseListRecursively(node1).m_pValue);
    }
}
