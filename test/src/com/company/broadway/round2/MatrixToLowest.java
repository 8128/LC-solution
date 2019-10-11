package com.company.broadway.round2;

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
        int[][] cache = new int[m][n];
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = dfs(matrix, i, j, cache);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        int min = matrix[i][j];
        for(int[] dir: directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] > matrix[i][j]) {
                continue;
            }
            min = Math.min(dfs(matrix, x, y, cache), min);
        }
        cache[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        MatrixToLowest matrixToLowest = new MatrixToLowest();
        int[][] arr = new int[][] {{4, 3, 2, 3, 5},{3, 2, 5, 4, 0},{2, 3, 1, 5, 3}};
        int[][] ans = matrixToLowest.smallestEndpoint(arr);
        System.out.println(Arrays.deepToString(ans));
    }

}
