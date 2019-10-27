package com.company.blend;

import java.util.Arrays;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-27 17:54
 */
public class SpiralMatrix {

    int[][] direction = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int[][] spiralMatrix(int m, int n){
        int[][] ans = new int[m][n];
        int x = 0;
        int y = n - 1;
        int dire = 0;
        while (true) {
            ans[x][y] = 1;
            if (checkBoundary(x, y, dire, m, n, ans) || checkForward(x, y, dire, m, n, ans)) {
                dire = nextDirection(dire);
                if (checkBoundary(x, y, dire, m, n, ans) || checkForward(x, y, dire, m, n, ans)) {
                    break;
                }
            }
            x += direction[dire][0];
            y += direction[dire][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        for (int[] temp : spiralMatrix.spiralMatrix(7,7)) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public int nextDirection(int i) {
        if (i == 3) {
            return 0;
        } else {
            return i + 1;
        }
    }

    public boolean checkBoundary(int x, int y, int dire, int m, int n, int[][] ans) {
        int tempX = x + direction[dire][0];
        int tempY = y + direction[dire][1];
        if (tempX >= m || tempX < 0 || tempY >= n || tempY < 0) {
            return true;
        }
        return ans[tempX][tempY] == 1;
    }

    public boolean checkForward(int x, int y, int dire, int m, int n, int[][] ans) {
        int i = x + direction[dire][0];
        int j = y + direction[dire][1];
        for (int k = 0; k < 4; k++) {
            int tempX = i + direction[k][0];
            int tempY = j + direction[k][1];
            if (tempX == x && tempY == y) {
                continue;
            }
            if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && ans[tempX][tempY] == 1) {
                return true;
            }
        }
        return false;
    }
}
