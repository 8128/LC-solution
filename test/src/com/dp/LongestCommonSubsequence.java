package com.dp;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-17 22:09
 * @modified By：
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] txt1 = text1.toCharArray();
        char[] txt2 = text2.toCharArray();
        int len1 = txt1.length, len2 = txt2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++){
                if (txt1[i - 1] == txt2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }
}
