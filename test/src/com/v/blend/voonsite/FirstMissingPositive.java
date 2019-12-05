package com.v.blend.voonsite;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-03 21:56
 * @leetcode : https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    // On space complexity
    public int firstMissingPositive(int[] nums) {
        // use a hashset to store all the values that accessed before
        HashSet<Integer> hs = new HashSet<>();
        int ans=1;
        for (int num : nums) {
            hs.add(num);
            while (hs.contains(ans)) {
                ans++;
            }
        }
        return ans;
    }

    // O1 space complexity
    public int firstMissingPositive1(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                // nums[i]-1 has already changed
                nums[temp-1] = temp;
            }else{
                i++;
            }
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1) {
            i++;
        }
        return i+1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1

        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) {
                // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }
}
