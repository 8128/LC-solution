package com.company.blend;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-27 18:07
 */
import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        print(10,10);
    }

    public static void print(int width, int height) {
        if (width == 0 || height == 0) System.out.print("");
        if (height == 1)  {
            for (int i = 0; i < width; i++) {
                System.out.print("1");
            }
        }
        if (width == 1) {
            for (int i = 0; i < height; i++) {
                System.out.print("1");
            }
        }

        String[][] result = new String[height][width];
        for (String[] res : result) {
            Arrays.fill(res, "0");
        }
        int left = 0, right = width - 1, top = 0, bottom = height - 1;
        while (true) {
            for (int i = right; i >= left; i--) result[top][i] = "1";
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) result[i][left] = "1";
            left++;
            if (right < width - 1) {
                right--;
            }
            if (left > right || top > bottom) break;

            for (int i = left; i <= right; i++) result[bottom][i] = "1";
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top + 1; i--) result[i][right] = "1";
            right--;
            if(left > right || top > bottom) break;

            left++;
            top++;
            bottom--;

        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
