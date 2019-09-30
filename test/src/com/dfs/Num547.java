package com.dfs;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-30 03:51
 * @modified By：
 */
public class Num547 {
    public int findCircleNum(int[][] M) {
        int[] seen = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (seen[i] == 0) {
                seen[i] = 1;
                dfs(M, i, seen);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int index, int[] seen) {
        for (int i = 0; i < M.length; i++) {
            if (M[index][i] == 1 && seen[i] == 0) {
                seen[index] = 1;
                dfs(M, i, seen);
            }
        }
    }
}
