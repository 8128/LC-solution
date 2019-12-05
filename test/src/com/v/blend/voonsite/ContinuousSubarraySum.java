package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 03:06
 * @leetcode :  https://leetcode.com/problems/continuous-subarray-sum/
 * @timeComplexity :
 * @spaceComplexity :
 */

public class ContinuousSubarraySum {
    public int[] checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        // the first to store the remainder, the second to store the position
        // if there are two remainders are of the same value,
        // it means the number sum inside of these loop are actually a mutiply of k
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
//                if (sum < 0) {
//                    sum = k - (-sum)%k;
//                }else {
                    sum = sum % k;
//                }
            }
            if (map.containsKey(sum)) {
                // when there is only one zero
                // size at least 2
                // if there is no size limitation it can not be written
                if (i - map.get(sum) > 1) {
                    return Arrays.copyOfRange(nums, map.get(sum) + 1, i + 1);
                }
            } else {
                map.put(sum, i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        double db1 = 1.333;
        double db2 = 1.334;
        System.out.println(Arrays.toString("1->2->3".split("->")));
        System.out.println(Double.compare(db1, db2));
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        System.out.println(Arrays.toString(continuousSubarraySum.checkSubarraySum(new int[]{1, -3, 4, 8, 2, -14, 3}, 9)));
    }
}
