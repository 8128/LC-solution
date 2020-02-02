package com.contest.feb1;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-02-01 21:44
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution2 {
    public int minSetSize(int[] arr) {
        int[] map = new int[100000];
        for (int i : arr) {
            map[i - 1] += 1;
        }
        Arrays.sort(map);
        int size = arr.length / 2;
        int cur = 0;
        int counter = 0;
        for (int i = map.length - 1; i >= 0; i--) {
            counter++;
            cur += map[i];
            if (cur >= size) {
                return counter;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
