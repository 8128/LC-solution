package com.v.blend.voonsite;

import java.util.Arrays;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-22 11:30
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PrintMatrix {
    public void printMatrix (int m, int n) {
        int[][] matrix = new int[m][n];
        int m1 = 0, m2 = m - 1, n1 = 0, n2 = n  -1;
        while (m2 > m1 && n2 > n1) {
            for (int i = n2; i >= n1; i--) {
                matrix[m1][i] = 1;
            }
            for (int i = m1 + 1; i <= m2; i++) {
                matrix[i][n1] = 1;
            }
            for (int i = n1 + 1; i <= n2 && m2 > m1 + 1; i++) {
                matrix[m2][i] = 1;
            }
            for (int i = m2; i >= m1 + 2 && n2 > n1 + 1; i--) {
                matrix[i][n2] = 1;
            }

            if (m1 + 2 < m2 - 1 && n2 - 1 > n1 + 1) {
                matrix[m1 + 2][n2 - 1] = 1;
            }
            n2-=2;
            n1+=2;
            m1+=2;
            m2-=2;
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        new PrintMatrix().printMatrix(6,8);
    }
}
