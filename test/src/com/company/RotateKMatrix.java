package com.company;

import java.util.Arrays;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-26 21:23
 * @modified By：
 */
public class RotateKMatrix {
    public int[][] rotateKMatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        k %= 4;
        for(int i = 0; i < k; i++){
            matrix = rotateMatrixBy90DegreeClockwise(matrix);
        }
        return matrix;
    }

    private int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {

        int[][] rotatedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j || i + j + 1 == matrix.length) {
                    rotatedMatrix[i][j] = matrix[i][j];
                }else {
                    rotatedMatrix[j][ (matrix.length-1)- i] = matrix[i][j];
                }
            }
        }
        return rotatedMatrix;
    }

    public static void main(String[] args) {
        RotateKMatrix rotateKMatrix = new RotateKMatrix();
        int[][] testcase = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(Arrays.deepToString(rotateKMatrix.rotateKMatrix(testcase,2)));
    }
}
