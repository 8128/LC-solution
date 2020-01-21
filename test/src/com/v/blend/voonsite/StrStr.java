package com.v.blend.voonsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static int kmp(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int[] next = makeNext(n);
        int p1 = 0;
        int p2 = 0;
        while (p1 < h.length) {
            if (h[p1] == n[p2]) {
                p1++;
                p2++;
                if (p2 == n.length) {
                    return p1 - p2;
                }
            } else {
                if (p2 < 1) {
                    p1++;
                } else {
                    p2 = next[p2 - 1];
                }
            }
        }
        return -1;
    }

    public static int[] makeNext (char[] cs) {
        int[] ans = new int[cs.length];
        if (cs.length == 1) return ans;
        int len = 0;
        int i = 1;
        ans[0] = 0;
        while (i < cs.length) {
            if (cs[len] == cs[i]) {
                len++;
                ans[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = ans[len - 1];
                } else {
                    ans[i] = len;
                    i++;
                }
            }
        }
        return ans;
    }

    // Program to implement KMP Algorithm in Java
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(kmp("aabaaac".toCharArray())));
        //System.out.println(kmp("aabaaabaaac","aabaaac"));
        //System.out.println(Arrays.toString(computeLPSArray("aabaaac")));
    }

}
