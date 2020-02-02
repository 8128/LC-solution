package com.contest.feb1;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-02-01 22:13
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution4 {

    HashMap<Integer, Integer> seen = new HashMap<>();
    HashMap<Integer, List<Integer>> hm = new HashMap();

    public int maxJumps(int[] arr, int d) {
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = 1; j <= d; j++) {
                int index = i + j;
                if (index < arr.length) {
                    if (arr[index] >= cur) {
                        break;
                    }
                    hm.putIfAbsent(i, new ArrayList<>());
                    hm.get(i).add(index);
                } else {
                    break;
                }
            }
            for (int j = -1; j >= -d; j--) {
                int index = i + j;
                if (index >= 0) {
                    if (arr[index] >= cur) {
                        break;
                    }
                    hm.putIfAbsent(i, new ArrayList<>());
                    hm.get(i).add(index);
                } else {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }


    public int dfs (int cur) {
        if (seen.containsKey(cur)) return seen.get(cur);
        if (!hm.containsKey(cur)) return 1;
        List<Integer> canJump = hm.get(cur);
        int max = Integer.MIN_VALUE;
        for (int i : canJump) {
            max = Math.max(dfs(i), max);
        }
        seen.put(cur, max + 1);
        return max + 1;
    }
}
