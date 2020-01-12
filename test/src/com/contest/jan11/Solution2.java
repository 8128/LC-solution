package com.contest.jan11;

import java.util.*;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-11 21:40
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution2 {
    public int minFlips(int a, int b, int c) {
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        String s3 = Integer.toBinaryString(c);
        int len =Math.max(s1.length(), Math.max(s2.length(), s3.length()));
        char[] c1 = reverseAndAppend(s1, len).toCharArray();
        char[] c2 = reverseAndAppend(s2, len).toCharArray();
        char[] c3 = reverseAndAppend(s3, len).toCharArray();
        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));
        System.out.println(Arrays.toString(c3));
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (c1[i] == '1' && c2[i] == '1') {
                if (c3[i] == '0') count +=2;
            } else if (c1[i] == '1' || c2[i] == '1') {
                if (c3[i] == '0') count++;
            } else {
                if (c3[i] == '1') count++;
            }
        }
        return count;
    }

    public String reverseAndAppend(String s, int len) {
        StringBuilder sb = new StringBuilder(s);
        int size = sb.length();
        sb = sb.reverse();
        for (int i = 0; i < len - size; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minFlips(1,2,3));
    }
}
