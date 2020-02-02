package com.contest.feb1;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-02-01 21:36
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Solution1 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] tmp = new int[mat.length];
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int[] temp = mat[i];
            li.add(i);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != 1) {
                    tmp[i] = j;
                    break;
                }
                if (j == temp.length - 1) {
                    tmp[i] = j + 1;
                }
            }
        }
        //System.out.println(Arrays.toString(tmp));
        Collections.sort(li, Comparator.comparingInt(o -> tmp[o]));
        int[] ans = new int[k];
        for (int i = 0; i<k; i++) {
            ans[i] = li.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
