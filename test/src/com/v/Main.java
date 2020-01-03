package com.v;

import java.util.*;

public class Main {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (; r < chars.length; r++) {
            hm.put(chars[r], hm.getOrDefault(chars[r], 0) + 1);
            while (hm.size() > k) {
                int freq = hm.get(chars[l]) - 1;
                if (freq == 0) {
                    hm.remove(chars[l]);
                } else {
                    hm.put(chars[l], freq);
                }
                l++;
            }
            if (hm.size() == k) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
