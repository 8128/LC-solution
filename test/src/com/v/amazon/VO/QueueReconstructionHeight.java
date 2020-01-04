package com.v.amazon.VO;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-03 21:57
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare (int[] i1, int[] i2) {
                if (Integer.compare(i1[0],i2[0]) == 0) {
                    return Integer.compare(i1[1],i2[1]);
                }
                return Integer.compare(i1[0],i2[0]);
            }
        });
        //System.out.println(Arrays.deepToString(people));
        int[][] ans = new int[people.length][2];
        // first zero
        int p = 0;
        int[] before = new int[2];
        for (int[] person : people) {
            int height = person[0];
            int k = person[1];
            if (before[0] == height) {
                k -= before[1];
            }
            int ansP = p + k;
            while (ans[ansP][0] != 0) {
                ansP++;
            }
            ans[ansP] = person;
            if (k == 0 && p != ans.length - 1) {
                while (ans[p][0] != 0) {
                    p++;
                }
            }
            if (before[0] != height) {
                before[0] = height;
                before[1] = 1;
            } else {
                before[1]++;
            }
        }
        return ans;
    }
    
}
