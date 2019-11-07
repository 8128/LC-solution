package com.v.bloomberg.coding;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 17:28
 * @leetcode : https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
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
