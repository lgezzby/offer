package com.zjgsu.offer.QueueWithTwoStacks;

import java.util.Stack;

/**
 * 两个栈组合成队列
 */
public class QueueWithTwoStacks {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    //队列插入元素
    public static void appendTail(Integer value) {
        stack1.push(value);
    }
    //队列删除元素
    public static Integer deleteHead() throws Exception {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                Integer value = stack1.pop();
                stack2.push(value);
            }
        }
        if (stack2.empty()) {
            System.out.println("队列为空");
            throw new Exception("queue is empty.");
        }
        Integer head = stack2.pop();
        return  head;
    }

    public static void main(String[] args) throws Exception {
        appendTail(1);
        appendTail(2);
        appendTail(3);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        appendTail(4);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }
}
