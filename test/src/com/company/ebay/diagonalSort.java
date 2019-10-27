package com.company.ebay;

import java.util.*;
public class diagonalSort {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{4, 2, 1, 3}, {5, 7, 6, 8}, {3, 0, 5, 7}, {1, 2, 3, 4}};
        //res = diagonalSort(grid);
        grid = diagonalSort(grid);
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] diagonalSort(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        List<List<Integer>> diagonalList = new ArrayList<>();
        for (int k = 0; k < col * 2 - 1; k++) {     //k代表有多少行输出，由col决定
            int diff = col - k - 1;                 //同一行的元素，行下标和列下标的差相等
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                int i = j - diff;
                if (isValidIndex(i, row) && isValidIndex(j, col)) {
                    tmp.add(grid[i][j]);
                }
            }
            Collections.sort(tmp);
            diagonalList.add(tmp);
        }
        for (int i = 0; i < diagonalList.size(); i++) {
            List<Integer> tmp = diagonalList.get(i);
            if (i < row) {
                int c = row - i - 1;
                for (int j = 0; j < tmp.size(); j++) {
                    res[j][c] = tmp.get(j);
                    c++;
                }
            }
            if (i >= row) {
                int r = i - row + 1;
                for (int j = 0; j < tmp.size(); j++) {
                    res[r][j] = tmp.get(j);
                    r++;
                }
            }
        }
        return res;
    }
    private static boolean isValidIndex(int i, int n) {
        return i >= 0 && i < n;
    }

}
