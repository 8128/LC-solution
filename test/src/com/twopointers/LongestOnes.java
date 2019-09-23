package com.twopointers;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-23 04:23
 * @modified By：
 */
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int zeros = 0;
        int max = 0;
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if(A[i] == 0){
                    zeros--;
                }
                i++;
            }
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
