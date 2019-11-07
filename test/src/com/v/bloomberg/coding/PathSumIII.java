package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 14:35
 * @leetcode :  https://leetcode.com/problems/path-sum-iii/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PathSumIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        //Default sum = 0 has one count
        map.put(0, 1);
        return backtrack(root, 0, sum, map);
    }
    // BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        //See if there is a subarray sum equals to target
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        //Remove the current node so it wont affect other path
        map.put(sum, map.get(sum)-1);
        return res;
    }
}
