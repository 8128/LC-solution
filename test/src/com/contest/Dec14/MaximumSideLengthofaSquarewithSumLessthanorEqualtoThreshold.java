package com.contest.Dec14;

import java.util.Arrays;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-14 21:57
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        int cur = 2;
        int k = Math.min(m,n);
        boolean bl = false;
        System.out.println(Arrays.deepToString(mat));
        OUTER:
        while (cur <= k) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (i + cur - 1 == m) break;
                for (int j = 0; j < n; j++) {
                    if (j + cur - 1 == n) break;
                    System.out.println("11111");
                    int temp = 0;
                    for (int z = 0; z < cur; z++) {
                        if (j > 0) {
                            temp += (mat[i + z][j + cur - 1] - mat[i + z][j - 1]);
                        }else {
                            temp += mat[i + z][j + cur - 1];
                        }
                    }
                    min = Math.min(min, temp);
                    if (temp <= threshold) {
                        bl = true;
                        cur++;
                        continue OUTER;
                    }
                }
            }
            if (min > threshold) {
                break OUTER;
            }
        }
        if (!bl) return 0;
        return cur - 1;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold().maxSideLength(new int[][]{{18,70},{61,1},{25,85},{14,40},{11,96},{97,96},{63,45}}, 40184));
    }
}
