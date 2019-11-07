package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 02:24
 * @leetcode :  https://leetcode.com/problems/move-zeroes/
 * @timeComplexity : n
 * @spaceComplexity : 1
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
