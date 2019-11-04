package com.company.blend.voonsite;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-03 23:37
 */
public class SubarraySumEqualsK {
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
