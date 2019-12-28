package com.contest.dec21;

import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-21 21:52
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Solution3 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chars = s.toCharArray();
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int r = i; r < chars.length; r++) {
                hs.add(chars[r]);
                if (hs.size() > maxLetters) break;
                int len = r - i + 1;
                if (len <= maxSize && len >= minSize) {
                    String str = s.substring(i,r+1);
                    int freq = hm.getOrDefault(str, 0) + 1;
                    if (freq > max) {
                        max = freq;
                    }
                    hm.put(str, freq);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxFreq("abcde",   2,   3,   3));
    }
}
