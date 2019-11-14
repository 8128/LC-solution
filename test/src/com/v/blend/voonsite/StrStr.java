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
}
