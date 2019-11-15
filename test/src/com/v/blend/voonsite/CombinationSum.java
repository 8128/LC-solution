package com.v.blend.voonsite;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 02:05
 * @leetcode :  https://leetcode.com/problems/combination-sum/
 * @timeComplexity :
 * @spaceComplexity :
 */

//use the backtracking to solve this problem
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // send in the result, the current list, the candidates numbers and the pivot
        // so we can use the pivot to check whether this number has been used before
        // eg.[2,2,3] [2,3,2]
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                if (candidates[i] > target) {
                    break;
                }
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }else if(target == 0 ){
            result.add(new ArrayList<>(cur));
        }
    }
}
