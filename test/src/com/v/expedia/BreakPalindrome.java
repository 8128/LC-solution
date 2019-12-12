package com.v.expedia;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-12 08:12
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class BreakPalindrome {
    public String breakPalindrome(String string){
        char[] chars = string.toCharArray();
        if (chars.length == 0) {
            return "IMPOSSIBLE";
        }
        int mid = chars.length % 2 == 0 ? chars.length / 2 - 1 : (chars.length + 1)/2 - 1;
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i <= mid; i++) {
            if (!pq.isEmpty() && pq.peek() > chars[i]) {
                char c = pq.poll();
                change(chars, string.indexOf(c), i);
                return tostring(chars);
            }
            pq.offer(chars[i]);
        }
        return "IMPOSSIBLE";
    }

    public void change(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public String tostring(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c:chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BreakPalindrome breakPalindrome = new BreakPalindrome();
        System.out.println(breakPalindrome.breakPalindrome("bacdkkmsmkkdcab"));
    }
}
