package com.v.bloomberg.coding;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 20:19
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }
}
