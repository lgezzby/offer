package com.zjgsu.offer.MaxInSlidingWindow;

import java.util.*;

/**
 * 滑动窗口中的最大值
 */
public class MaxInSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,6,2,5,1};
        int k = 3;
        maxNumberInSlidingWindow(arr,k);
    }

    private static void maxNumberInSlidingWindow(int[] arr, int k) {
        if (arr.length == 0 || arr == null || k == 0 || k > arr.length) {
            return;
        }

        //队列保留最大窗口下标
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        //还没达到窗口规模,此时只在队尾保留最大值
        for (int i = 0; i < k; i++) {
            while (queue.size() != 0 && arr[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        Vector<Integer> maxInWindows = new Vector<Integer>();
        //达到窗口规模后,若当前数字比队尾大,就把队列情况存入当前数到队尾
        //反之,当前数可能是次小数,放入队列头
        //也要判断队尾是不是已经滑出
        for (int i = k; i < arr.length; i++) {
            maxInWindows.add(arr[queue.getFirst()]);
            //清空队列
            while (queue.size() != 0 && arr[i] >= arr[queue.getLast()]) {
                queue.removeLast();
            }
            if (queue.size() != 0 && queue.getFirst() <= (i - k)){
                queue.removeFirst();
            }

            queue.addLast(i);
        }
        maxInWindows.add(arr[queue.getFirst()]);

        System.out.println(maxInWindows.toArray().toString());
    }

}
