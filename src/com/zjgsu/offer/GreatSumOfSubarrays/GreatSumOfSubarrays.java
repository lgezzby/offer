package com.zjgsu.offer.GreatSumOfSubarrays;

/**
 * 连续子数组的最大和
 */
public class GreatSumOfSubarrays {
    public static void main(String[] args) throws Exception {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatSumOfSubarrays(arr));
    }

    /**
     * 分析数组规律
     */
    private static int findGreatSumOfSubarrays(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("error input.");
        }

        int resultSum = 0;
        int curSum = 0;
        for (int value : arr) {
            curSum += value;
            //加完当前数字后为负数,则要重新开始
            if (curSum <= 0) {
                curSum = 0;
            }
            //加完当前数字后,比存储的和要小,此时继续步骤但不更新resultSum
            else if (curSum <= resultSum) {
                continue;
            }
            //加完当前数字后,比存储的和大,更新
            else {
                resultSum = curSum;
            }
        }
        return resultSum;
    }


}
