package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 03:14
 * @leetcode :  https://leetcode.com/problems/insert-interval/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] i : intervals) {
            if (newInterval == null || i[1] < newInterval[0]) {
                result.add(i);
            } else if (i[0] > newInterval[1]) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } // other case is that there should be a merge
            else {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        int[][] ans = new int[result.size()][2];
        int i = 0;
        for (int[] temp : result) {
            ans[i] = temp;
            i++;
        }
        return ans;
    }
}
