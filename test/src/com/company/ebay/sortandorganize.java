package com.company.ebay;

import java.util.*;

public class sortandorganize {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4}, {1,4,3,6}, {2,5,7,3}, {2,3,1,8}};
        int[][] res = sortandorganize(grid);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] sortandorganize(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        TreeSet<Integer>[] bucket = new TreeSet[m * n + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new TreeSet<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> store = new ArrayList<>();
        for (int pos = 0; pos < bucket.length; pos++) {
            if (bucket[pos] != null) {
                for (int val : bucket[pos]) {
                    for (int i = 0; i < pos; i++) {
                        store.add(val);
                    }
                }
            }
        }
        int index = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            int row = i;
            int col = 0;
            while (row >= 0 && col < n) {
                res[row][col] = store.get(index);
                col++;
                row--;
                index++;
            }
        }

        for (int i = 1 ; i < n; i++) {
            int row = m - 1;
            int col = i;
            while (row >= 0 && col < n) {
                res[row][col] = store.get(index);
                col++;
                row--;
                index++;
            }
        }
        return res;
    }
}
