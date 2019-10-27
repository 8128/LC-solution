package com.company.ebay;// 给一个正方形的matrix，绕着中点顺时针旋转k*90°(k为给定)，对角线不变，输出旋转以后的matrix。
//input：1,2,3     k = 1;  output: 1,4,3
//       4,5,6                     8,5,2
//       7,8,9                     7,6,9

import java.util.Arrays;

public class rotateWithKTimes {
    public static void main(String[] args) {
        int[][] testcase = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(Arrays.deepToString(rotateKMatrix(testcase,2)));
    }
    public static int[][] rotateKMatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        k %= 4;
        for (int i = 0; i < k; i++) {
            matrix = rotateMatrixBy90DegreeClockwise(matrix);
        }
        return matrix;
    }

    private static int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j || i + j + 1 == matrix.length) {
                    rotatedMatrix[i][j] = matrix[i][j];
                } else {
                    rotatedMatrix[j][(matrix.length - 1) - i] = matrix[i][j];
                }
            }
        }
        return rotatedMatrix;
    }
}