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
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        // the first to store the remainder, the second to store the position
        // if there are two remainders are of the same value,
        // it means the number sum inside of these loop are actually a mutiply of k
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                // when there is only one zero
                // size at least 2
                // if there is no size limitation it can not be written
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
