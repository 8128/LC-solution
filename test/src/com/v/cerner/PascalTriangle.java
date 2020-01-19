package com.v.cerner;

import java.util.Date;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-16 14:12
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PascalTriangle {

    public void drawTriangle(int k) {
        if (k == 0) System.out.println("");
        StringBuilder sb = new StringBuilder();
        int[] tmp = new int[]{1};
        int level = 0;
        while (level < k) {
            int[] newTmp = new int[level + 2];
            newTmp[0] = 1;
            newTmp[level + 1] = 1;
            for (int i = 0; i < tmp.length; i++) {
                sb.append(" ");
                sb.append(tmp[i]);
            }
            for (int i = 1; i < newTmp.length - 1; i++) {
                newTmp[i] = tmp[i - 1] + tmp[i];
            }
            tmp = newTmp;
            level++;
        }
        System.out.println(sb);
    }



    public static void main(String[] args) {
        new PascalTriangle().drawTriangle(3);
    }
}
