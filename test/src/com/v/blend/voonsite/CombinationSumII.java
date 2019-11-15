package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 15:35
 * @leetcode :  https://leetcode.com/problems/combination-sum-ii/
 * @timeComplexity :
 * @spaceComplexity :
 */

// if we can only use one integer once
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combination(int[] candidates, int target, int start,
                             List<Integer> cur, List<List<Integer>> result) {
        for (int i = start; i < candidates.length; i++) {
            //the one that needed to be added remove duplicates.
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] == target) {
                //recursion exit.
                ArrayList<Integer> ans = new ArrayList<>(cur);
                ans.add(candidates[i]);
                result.add(ans);
            } else if (candidates[i] < target) {
                //continue to look for the rest.
                cur.add(candidates[i]);
                combination(candidates, target - candidates[i], i + 1, cur, result);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
}
