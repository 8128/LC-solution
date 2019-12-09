package com;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-23 22:15
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Contest {
    public int minFlips(int[][] mat) {
        HashSet<String> hs = new HashSet<>();
        int[][] dest = new int[mat.length][mat[0].length];
        String des = Arrays.deepToString(dest);
        hs.add(Arrays.deepToString(mat));
        Queue<int[][]> q = new LinkedList<>();
        q.add(mat);
        if (hs.contains(des)) {
            return 0;
        }
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            if (level > 9) {
                return -1;
            }
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[][] queout = q.poll();
                for (int m = 0; m < mat.length; m++) {
                    for (int n = 0; n < mat[0].length; n++) {
                        int[][] temp = deepcopy(queout);
                        if (m + 1 < mat.length) {
                            temp[m+1][n] = temp[m+1][n] == 1 ? 0 : 1;
                        }
                        if (m - 1 >= 0) {
                            temp[m-1][n] = temp[m-1][n] == 1 ? 0 : 1;
                        }
                        if (n + 1 < mat[0].length) {
                            temp[m][n + 1] = temp[m][n + 1] == 1 ? 0 : 1;
                        }
                        if (n - 1 >= 0) {
                            temp[m][n - 1] = temp[m][n - 1] == 1 ? 0 : 1;
                        }
                        temp[m][n] = temp[m][n] == 1 ? 0 : 1;
                        String str = Arrays.deepToString(temp);
                        if (hs.contains(str)) {
                            continue;
                        }
                        q.offer(temp);
                        hs.add(str);
                        if (hs.contains(des)) {
                            return level;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int[][] deepcopy (int[][] input) {
        int[][] ans = new int[input.length][input[0].length];
        int i = 0;
        for (int[] temp : input) {
            ans[i] = temp.clone();
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Contest contest = new Contest();
        System.out.println(contest.minFlips(new int[][]{{0,0},{0,1}}));
    }



}