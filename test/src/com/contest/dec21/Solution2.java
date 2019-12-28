package com.contest.dec21;
import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-21 21:39
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Solution2 {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        int m = 0;
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 0) {
                continue;
            }
            while (map.get(list.get(i)) != 0) {
                for (int j = 0; j < k; j++) {
                    if (!map.containsKey(list.get(i) + j)) return false;
                    int newValue = map.get(list.get(i) + j) - 1;
                    if (newValue < 0) return false;
                    map.put(list.get(i) + j, newValue);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
    }
}
