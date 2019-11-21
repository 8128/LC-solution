package com.v.amazon.VO;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-20 16:50
 * @leetcode :  https://leetcode.com/problems/sort-colors/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class SortColors {
    int[] nums;
    public void sortColors(int[] nums) {
        this.nums = nums;
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i]==2 && i<second) {
                swap(i, second--);
            }
            while (nums[i]==0 && i>zero) {
                swap(i, zero++);
            }
        }
    }

    public void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
