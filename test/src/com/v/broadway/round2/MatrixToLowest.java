package com.v.broadway.round2;

import java.util.Arrays;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-08 15:14
 */
public class MatrixToLowest {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] smallestEndpoint(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[][]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = dfs(matrix, dp, i, j);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int min = matrix[i][j];
        for(int[] direction: directions) {
            int x = i + direction[0], y = j + direction[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] > matrix[i][j]) {
                continue;
            }
            min = Math.min(dfs(matrix, dp, x, y), min);
        }
        dp[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        MatrixToLowest matrixToLowest = new MatrixToLowest();
        int[][] arr = new int[][] {{4, 3, 2, 3, 5},{3, 2, 5, 4, 0},{2, 3, 1, 5, 3}};
        int[][] ans = matrixToLowest.smallestEndpoint(arr);
        System.out.println(Arrays.deepToString(ans));
    }

}
