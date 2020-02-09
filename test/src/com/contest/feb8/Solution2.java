package com.contest.feb8;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2/8/20 9:25 PM
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution2 {

    public int minSteps(String s, String t) {
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        int add = 0;
        int minus = 0;
        for (char c : s.toCharArray()) {
            t1[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            t2[c - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (t1[i] > t2[i]) {
                add += (t1[i] - t2[i]);
            }
            if (t1[i] < t2[i]) {
                minus += (t2[i] - t1[i]);
            }
        }
        return Math.max(add, minus);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minSteps( "friend", "family"));
    }
}
