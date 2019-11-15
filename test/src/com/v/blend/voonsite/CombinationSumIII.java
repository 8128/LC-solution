package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 15:37
 * @leetcode :  https://leetcode.com/problems/combination-sum-iii/
 * @timeComplexity :
 * @spaceComplexity :
 */


// backtracking
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> cur, int k,  int start, int n) {
        if (cur.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(cur);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            combination(ans, cur, k, i+1, n-i);
            cur.remove(cur.size() - 1);
        }
    }
}
