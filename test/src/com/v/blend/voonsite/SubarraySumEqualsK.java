package com.v.blend.voonsite;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-03 23:37
 * @leetcode : https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {


    public int subarraySum1(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap <Integer, Integer> map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // n2
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int l = 0; l < len; l++) {
            for (int r = l + 1; r <= len; r++) {
                if (sum[r] - sum[l] == k) {
                    count++;
                }
            }
        }
        return count;
    }




}
