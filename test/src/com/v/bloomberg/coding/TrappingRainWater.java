package com.v.bloomberg.coding;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 17:28
 * @leetcode : https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    //O(N) O(N)
    public int trap1(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    //O(n) O(1)
    public int trap(int[] height) {
        int a = 0;
        int b = height.length-1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(a <= b){
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if(leftmax < rightmax){
                // leftmax is smaller than rightmax, so the (leftmax-height[a]) water can be stored
                max += (leftmax - height[a]);
                a++;
            }
            else{
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }
}
