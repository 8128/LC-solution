package com.contest.jan11;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-11 22:14
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution3 {
    HashMap<Integer, List<Integer>> hm;

    public int makeConnected(int n, int[][] connections) {
        this.hm = new HashMap<>();
        for (int[] tmp : connections) {
            hm.putIfAbsent(tmp[0], new ArrayList<>());
            hm.get(tmp[0]).add(tmp[1]);
            hm.putIfAbsent(tmp[1], new ArrayList<>());
            hm.get(tmp[1]).add(tmp[0]);
        }
        Set<Integer> keySet = hm.keySet();
        HashSet<Integer> seen = new HashSet<>();
        int island = 0;
        for (int i : keySet) {
            if (seen.contains(i)) {
                continue;
            } else {
                dfs(i, seen);
                island++;
            }
        }
        int necessary = n - 1;
        int weHave = connections.length;
        if (weHave < necessary) {
            return -1;
        }
        int ans = island - 1 - hm.size() + n;
        return ans;
    }

    public void dfs (int start, HashSet<Integer> seen) {
        List<Integer> list = hm.get(start);
        for (int next : list) {
            if (seen.contains(next)) continue;
            else {
                seen.add(next);
                dfs(next, seen);
            }
        }
    }

    public static void main(String[] args) {
    }
}
