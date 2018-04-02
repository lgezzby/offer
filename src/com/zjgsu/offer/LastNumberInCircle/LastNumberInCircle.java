package com.zjgsu.offer.LastNumberInCircle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 环中最后一个数字
 */
public class LastNumberInCircle {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
//        int result = lastRemainingNumber(n,m);
        int result = lastRemainingNumberByFormation(n,m);
        System.out.println(result);
    }

    /**
     * 数学原理
     */
    private static int lastRemainingNumberByFormation(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * 利用环形链表的性质,List模拟
     * O(mn)
     */
    private static int lastRemainingNumber(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        //一直进行删除操作
        Iterator iterator = list.iterator();
        while (list.size() > 1) {
            int step = 0;
            while (step++ != m) {
                //到尾节点重新获取迭代器
                if (!iterator.hasNext()) {
                    iterator = list.iterator();
                }
                iterator.next();
            }
            //remove会删除最后一个返回的值
            iterator.remove();
        }

        return list.get(0);
    }
}
