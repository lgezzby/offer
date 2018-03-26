package com.zjgsu.offer.StackWithTwoQueues;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列组合成栈
 */
public class StackWithTwoQueues {
    private static Queue<Character> queue1 = new ArrayDeque<Character>();
    private static Queue<Character> queue2 = new ArrayDeque<Character>();

    //入栈
    public static void appendTail(Character value) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(value);
        } else if (!queue1.isEmpty()){
            queue1.add(value);
        } else{
            queue2.add(value);
        }
    }
    //出栈
    public static Character deleteTail() throws Exception {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            System.out.println("堆栈为空");
            throw new Exception("stack is empty.");
        } else if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            Character value = queue2.poll();
            return value;
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            Character value = queue1.poll();
            return value;
        }
    }

    public static void main(String[] args) throws Exception {
        appendTail('a');
        appendTail('b');
        appendTail('c');
        System.out.println(deleteTail());
        System.out.println(deleteTail());
        appendTail('d');
        System.out.println(deleteTail());
        System.out.println(deleteTail());
        System.out.println(deleteTail());
    }
}
