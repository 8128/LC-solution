package com.v.amazon.VO;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-10 03:27
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PartitiontoKEqualSumSubsets {
    int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int all = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            all += i;
            hs.add(i);
        }
        this.target = all/k;
        if (all % k != 0) {
            return false;
        }
        return dfs(hs, k, 0);
    }

    public boolean dfs (HashSet<Integer> hs, int m, int sum) {
        boolean bl = false;
        if (m == 0 && hs.isEmpty()) return true;
        for (int i : hs) {
            if (i + sum < target) {
                HashSet<Integer> temp = new HashSet<Integer>(hs);
                temp.remove(i);
                bl = bl || dfs(temp, m, sum + i);
            } else if (i + sum == target) {
                HashSet<Integer> temp = new HashSet<Integer>(hs);
                temp.remove(i);
                bl = bl || dfs(temp, m - 1, 0);
            } else {
                continue;
            }
        }
        return bl;
    }

    public static void main(String[] args) {
        PartitiontoKEqualSumSubsets partitiontoKEqualSumSubsets = new PartitiontoKEqualSumSubsets();
        System.out.println(partitiontoKEqualSumSubsets.canPartitionKSubsets(new int[]{10,10}, 2));
    }
}
