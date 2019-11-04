package com.v.wealthfront;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-04 21:09
 * @modified By：
 */
public class Anagram {
    public int anagram (String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int ans = 0;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        for (char c : charsA) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
            seen.add(c);
        }
        for (char c : charsB) {
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
            seen.add(c);
        }
        for (char c : seen) {
            ans += Math.abs(hm1.get(c) - hm2.get(c));
        }
        return ans;
    }
}
