package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 15:35
 * @leetcode :  https://leetcode.com/problems/combination-sum-ii/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates); // need sort to make this work.
        combination(candidates, target, 0, comb, ans);
        return ans;
    }

    private void combination(int[] candi, int target, int start,
                             List<Integer> comb, List<List<Integer>> ans) {
        for (int i = start; i < candi.length; i++) {
            if (i > start && candi[i] == candi[i - 1]) //remove duplicates.
                continue;
            if (candi[i] == target) {
                //recursion exit.
                List<Integer> newComb = new ArrayList<>(comb);
                newComb.add(candi[i]);
                ans.add(newComb);
            } else if (candi[i] < target) {
                //continue to look for the rest.
                List<Integer> newComb = new ArrayList<>(comb);
                newComb.add(candi[i]);
                combination(candi, target - candi[i], i + 1, newComb, ans);
            } else
                break; //invalid path, return nothing.
        }
    }
}
