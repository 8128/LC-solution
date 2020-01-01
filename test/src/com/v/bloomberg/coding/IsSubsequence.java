package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-31 23:22
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        int index = 0;
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            for (int j = index; j < tc.length; j++) {
                if (c == tc[j]) {
                    if (i == sc.length - 1) return true;
                    index = j + 1;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }
}
