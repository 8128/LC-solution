package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 21:36
 * @leetcode : https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int streak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int i = num;
                int temp = 1;

                while (set.contains(i + 1)) {
                    i += 1;
                    temp += 1;
                }

                streak = Math.max(streak, temp);
            }
        }
        return streak;
    }
}
