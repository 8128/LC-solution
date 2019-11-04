package com.v.ebay;

import java.util.*;

public class countOnSubarrays {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,1},{2,4,2},{0,3,1}};
        int[] array = {1, 1, 2, 3, 2};
        System.out.println(targetTotal(matrix, array));
    }

    static class Pair{
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static int targetTotal(int[][] matrix,int[] array) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0 ; i < matrix.length; i++) {
            int left = matrix[i][0];
            int right = matrix[i][1];
            int target = matrix[i][2];
            map.putIfAbsent(target, new ArrayList<>());
            Pair interval = new Pair(left, right);
            map.get(target).add(interval);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (map.containsKey(val)) {
                for (Pair interval : map.get(val)) {
                    if (i >= interval.left && i <= interval.right) count++;
                }
            }
        }

        return count;
    }
}
