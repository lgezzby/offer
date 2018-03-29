package com.zjgsu.offer.StackWithMin;

import java.util.Stack;

/**
 * push pop min
 */
public class StackWithMin {
    private static Stack<Integer> m_data = new Stack<>();
    private static Stack<Integer> m_min = new Stack<>();

    public static void push(Integer value) {
        //栈为空时,直接塞进辅助栈
        m_data.push(value);
        if (m_min.size() == 0 || value < m_min.peek()) {
            m_min.push(value);
        } else {
            m_min.push(m_min.peek());
        }
    }

    public static void pop() throws Exception {
        if (m_data.size() == 0) {
            throw new Exception("stack is empty.");
        }
        m_data.pop();
        m_min.pop();
    }

    public static Integer min() throws Exception {
        if (m_data.size() == 0) {
            throw new Exception("stack is empty.");
        }
        return m_min.peek();
    }

    public static void main(String[] args) throws Exception {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(1);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());
    }
}
