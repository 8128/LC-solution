package com.contest.feb8;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2/8/20 9:25 PM
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution4 {

    char[][] seats;
    int[][] dire = new int[][]{{0,1},{0,-1},{-1, -1},{-1, 1}};

//    public int maxStudents(char[][] seats) {
//        this.seats = seats;
//        int ans = 0;
//        for (int i = 0; i < seats.length; i++) {
//            for (int j = 0; j < seats[0].length; j++) {
//                if (seats[i][j] == '.') continue;
//                dire[i][j] = '.';
//                HashSet<List<Integer>> notUse = new HashSet<>();
//                for (int[] di : dire) {
//                    int tempX = i + di[0];
//                    int tempY = j + di[1];
//                    if (tempX >= 0 && tempX < seats.length && tempY >= 0 && tempY < seats[0].length) {
//                        notUse.add(Arrays.asList(tempX, tempY));
//                    }
//                }
//                int temp = Math.max(dfs(notUse, Arrays.asList(i, j), 0), dfs(new HashSet<>(), Arrays.asList(i, j), 1));
//
//            }
//        }
//    }
//
//    public int dfs (HashSet<List<Integer>> cannotUse, List<Integer> pos, int cur) {
//
//    }
}
