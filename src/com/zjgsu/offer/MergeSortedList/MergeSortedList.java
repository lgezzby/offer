package com.zjgsu.offer.MergeSortedList;

public class MergeSortedList {
    static class ListNode {
        private int m_pValue;
        private ListNode m_pNext;
    }

    /**
     * 递归实现
     * @return
     */
    public static ListNode mergeListRecursively(ListNode head1,ListNode head2) {
        //如果有空链表
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode mergeHead = null;
        //小值取出放到新链表里
        if (head1.m_pValue < head2.m_pValue) {
            mergeHead = head1;
            mergeHead.m_pNext = mergeListRecursively(head1.m_pNext,head2);
        } else {
            mergeHead = head2;
            mergeHead.m_pNext = mergeListRecursively(head1,head2.m_pNext);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode();
        node5.m_pValue = 9;
        node5.m_pNext = null;
        ListNode node4 = new ListNode();
        node4.m_pValue = 7;
        node4.m_pNext = node5;
        ListNode node3 = new ListNode();
        node3.m_pValue = 5;
        node3.m_pNext = node4;
        ListNode node2 = new ListNode();
        node2.m_pValue = 3;
        node2.m_pNext = node3;
        ListNode node1 = new ListNode();
        node1.m_pValue = 1;
        node1.m_pNext = node2;

        ListNode node10 = new ListNode();
        node10.m_pValue = 10;
        node10.m_pNext = null;
        ListNode node9 = new ListNode();
        node9.m_pValue = 8;
        node9.m_pNext = node10;
        ListNode node8 = new ListNode();
        node8.m_pValue = 6;
        node8.m_pNext = node9;
        ListNode node7 = new ListNode();
        node7.m_pValue = 4;
        node7.m_pNext = node8;
        ListNode node6 = new ListNode();
        node6.m_pValue = 2;
        node6.m_pNext = node7;

        ListNode mergeList = mergeListRecursively(node1,node6);
    }
}
