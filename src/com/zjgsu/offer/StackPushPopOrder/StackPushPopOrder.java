package com.zjgsu.offer.StackPushPopOrder;

import java.util.Stack;

public class StackPushPopOrder {
    public static void main(String[] args) {
        int[] popOrder = {4,5,3,2,1};
        //{4,3,5,1,2}
        int[] pushOrder = {1,2,3,4,5};
        System.out.println(isPopOrder(pushOrder,popOrder));
    }

    public static boolean isPopOrder(int[] pushOrder,int[] popOrder) {
        boolean flag = false;
        //判断特殊情况
        if (pushOrder != null && popOrder != null && pushOrder.length == popOrder.length) {
            Stack<Integer> stack = new Stack<>();
            int count = 0;
            for (int i = 0; i < popOrder.length; ) {
                //栈为空或者内容对应不上
                if (stack.size() == 0 || stack.peek() != popOrder[i]) {
                    if (count >= popOrder.length){
                        flag = false;
                        return flag;
                    }
                    stack.push(pushOrder[count++]);
                } else if (stack.peek() == popOrder[i]){
                    stack.pop();
                    i++;
                }
            }
            flag = true;
        }
        return flag;
    }
}
