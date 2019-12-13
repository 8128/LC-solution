package com.v.mapbox;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-12 21:16
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class OddEvenOperations {
    public static int oddEvenOperations(int[] in){
        int l = 0;
        int r = in.length - 1;
        int sum = 0;
        int ans = 0;
        int[] dp = new int[in.length + 1];
        for (int i : in) {
            sum += i;
        }
        dp[0] = sum;
        for (int i = 1; i <= in.length; i++) {
            if (i % 2 == 0) {
                if (in[l] > in[r]) {
                    ans = ans - (sum - in[l]);
                    l++;
                    sum -= in[l];
                } else {
                    ans = ans - (sum - in[r]);
                    r--;
                    sum -= in[r];
                }
            } else {
                if (in[l] > in[r]) {
                    ans = ans + (sum - in[r]);
                    r--;
                    sum -= in[r];
                } else {
                    ans = ans + (sum - in[l]);
                    l++;
                    sum -= in[l];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(oddEvenOperations(new int[]{1,2,3,4,2,6}));
    }
}
