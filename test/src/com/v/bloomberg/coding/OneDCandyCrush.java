package com.v.bloomberg.coding;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-05 22:35
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class OneDCandyCrush {
    public String c (String str) {
        StringBuilder sb = new StringBuilder(str);
        int sp = 0;
        int ep = 0;
        char prev = '#';
        for (int i = 0; i < str.length(); i++) {
            char c = sb.charAt(i);
            if (c == prev) {
                ep = i;
            } else {
                if (ep >= sp + 2) {
                    sb.delete(sp, ep + 1);
                    return c(sb.toString());
                }
                sp = i;
                ep = i;
                prev = c;
            }
        }
        if (ep >= sp + 2) {
            sb.delete(sp, ep+1);
            return sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new OneDCandyCrush().c("addd"));
    }
}
