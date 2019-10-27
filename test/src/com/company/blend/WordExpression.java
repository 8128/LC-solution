package com.company.blend;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-27 17:52
 */
public class WordExpression {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
