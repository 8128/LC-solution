package com.company;

import java.text.*;
import java.util.*;

public class Main {

    public int maximumSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        if (arr.length == 0){
            return 0;
        }
        int[][] dp = new int[arr.length][2];
        int min = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            Arrays.fill(ints, min);
        }
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            if(temp>=0){
                if(dp[i-1][0]<0){
                    dp[i][0] = Math.max(dp[i][1],0);
                }
                if(dp[i-1][1]<0){
                    dp[i][1] = 0;
                }
                dp[i][0] += temp;
                dp[i][1] += temp;
            }else{
                dp[i][0] = temp;
                dp[i][1] = Math.max(dp[i-1][0] + temp, temp);
            }
            max = Math.max(dp[i][0],dp[i][1]);
        }
        return max;
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        System.out.println(main.maximumSum(new int[]{1,-2,0,3}));
    //
    }
}
