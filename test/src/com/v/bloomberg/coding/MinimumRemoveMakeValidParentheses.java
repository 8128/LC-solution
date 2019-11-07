package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 02:53
 * @leetcode :  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/
 * @timeComplexity :    O(N)
 * @spaceComplexity :   O(N)
 */
public class MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i + 1);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else st.add(-(i + 1));
            }
        }
        while (!st.empty())
            sb.deleteCharAt(Math.abs(st.pop()) - 1);
        return sb.toString();
    }

    //O(1)
    public String minRemoveToMakeValid1(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length();
        int balance = 0;
        for (int j = sb.length() - 1; j >= 0; j--) {
            if (sb.charAt(j) == ')') balance++;
            else if (sb.charAt(j) == '(') {
                if (balance == 0) continue;
                balance--;
            }
            sb.setCharAt(--i, sb.charAt(j));
        }
        int len = 0;
        balance = 0;
        for (; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') balance++;
            else if (sb.charAt(i) == ')') {
                if (balance == 0) continue;
                balance--;
            }
            sb.setCharAt(len++, sb.charAt(i));
        }
        return sb.substring(0, len);
    }
}
