package com.contest.nov30;

import java.util.Arrays;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-30 21:59
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Solution {

    int[][] all = new int[][]{{0,0,0},{0,0,0},{0,0,0}};

    public String tictactoe(int[][] moves) {

        int i = 0;
        for (int[] move : moves) {
            System.out.println(Arrays.deepToString(all));
            if (i%2 == 0) {
                all[move[0]][move[1]] = 1;
                if (all[move[0]][0] != 0 && all[move[0]][0] == all[move[0]][1] && all[move[0]][1] == all[move[0]][2]){
                    return all[move[0]][0] == 1 ? "A" : "B";
                }
                if (all[0][move[1]] != 0 && all[0][move[1]] == all[1][move[1]] && all[0][move[1]] == all[2][move[1]]){
                    return all[0][move[1]] == 1 ? "A" : "B";
                }
                if (move[0] == move[1] || move[0] + move[1] == 2) {
                    if (all[0][0] != 0 && all[0][0] == all[1][1] && all[1][1] == all[2][2]){
                        return all[1][1] == 1 ? "A" : "B";
                    }
                    if (all[0][2] != 0 && all[0][2] == all[1][1] && all[1][1] == all[2][0]){
                        return all[1][1] == 1 ? "A" : "B";
                    }
                }
            }else{
                all[move[0]][move[1]] = -1;
                if (all[move[0]][0] != 0 && all[move[0]][0] == all[move[0]][1] && all[move[0]][1] == all[move[0]][2]){
                    return all[move[0]][0] == 1 ? "A" : "B";
                }
                if (all[0][move[1]] != 0 && all[0][move[1]] == all[1][move[1]] && all[0][move[1]] == all[2][move[1]]){
                    return all[0][move[1]] == 1 ? "A" : "B";
                }
                if (move[0] == move[1] || move[0] + move[1] == 2) {
                    if (all[0][0] != 0 && all[0][0] == all[1][1] && all[1][1] == all[2][2]){
                        return all[1][1] == 1 ? "A" : "B";
                    }
                    if (all[0][2] != 0 && all[0][2] == all[1][1] && all[1][1] == all[2][0]){
                        return all[1][1] == 1 ? "A" : "B";
                    }
                }
            }
            i++;
        }
        if (i == 9) {
            return "Draw";
        }
        return "Pending";
    }

    public int countSquares(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && j - 1 >= 0 && matrix[i][j - 1] > 0) {
                    matrix[i][j] = matrix[i][j - 1] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > 0) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    if (matrix[i][j] == 1) {
                        ans++;
                        continue;
                    }
                    if (matrix[i][j] > 1) {
                        ans++;
                    }
                    for (int m = 1; m < matrix[i][j]; m++) {
                        int temp = m + 1;
                        boolean bl = true;
                        for (int n = 1; n <= m; n++) {
                            if (i - n < 0 || matrix[i - n][j] < temp) {
                                bl = false;
                            }
                        }
                        if (bl) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }
}
