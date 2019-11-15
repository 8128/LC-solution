package com.v.blend.voonsite;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 01:41
 * @leetcode : https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    // Function to implement KMP algorithm
    public static void KMP(String X, String Y)
    {
        // Base Case 1: Y is null or empty
        if (Y == null || Y.length() == 0)
        {
            System.out.println("Pattern occurs with shift 0");
            return;
        }

        // Base Case 2: X is null or X's length is less than that of Y's
        if (X == null || Y.length() > X.length())
        {
            System.out.println("Pattern not found");
            return;
        }

        char[] chars = Y.toCharArray();

        // next[i] stores the index of next best partial match
        int[] next = new int[Y.length() + 1];
        for (int i = 1; i < Y.length(); i++)
        {
            int j = next[i + 1];

            while (j > 0 && chars[j] != chars[i])
                j = next[j];

            if (j > 0 || chars[j] == chars[i])
                next[i + 1] = j + 1;
        }

        for (int i = 0, j = 0; i < X.length(); i++)
        {
            if (j < Y.length() && X.charAt(i) == Y.charAt(j))
            {
                if (++j == Y.length())
                {
                    System.out.println("Pattern occurs with shift " +
                            (i - j + 1));
                }
            }
            else if (j > 0)
            {
                j = next[j];
                i--;	// since i will be incremented in next iteration
            }
        }
    }

    // Program to implement KMP Algorithm in Java
    public static void main(String[] args)
    {
        String text = "ABCABAABCABAC";
        String pattern = "CAB";

        KMP(text, pattern);
    }

}
