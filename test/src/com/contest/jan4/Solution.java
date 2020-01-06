package com.contest.jan4;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-04 21:57
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            if (query[0] == 0) ans[i] = dp[query[1]];
            else ans[i] = dp[query[1]] ^ dp[query[0] - 1];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
}
