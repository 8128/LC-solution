package com.contest.dec28;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-28 22:16
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Solution {
    String[] words;
    String result;
    HashSet<Character> cannotBeZero;
    List<Character> chs;


    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        this.cannotBeZero = new HashSet<>();
        HashSet<Character> hs = new HashSet<>();
        for (String str : words) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) {
                    cannotBeZero.add(chars[i]);
                }
                hs.add(chars[i]);
            }
        }
        char[] cs = result.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i == 0) {
                cannotBeZero.add(cs[i]);
            }
            hs.add(cs[i]);
        }
        this.chs = new ArrayList<>(hs);
        return dfs(0, new HashSet<>(), new HashMap<>());
    }

    public boolean dfs (int pivot, HashSet<Integer> used, HashMap<Character, Integer> hm) {
        for (int i = 0; i <= 9; i++) {
            if (used.contains(i)) continue;
            if (i == 0 && this.cannotBeZero.contains(chs.get(pivot))) continue;
            HashMap<Character, Integer> tempHashMap = new HashMap<>(hm);
            tempHashMap.put(chs.get(pivot), i);
            HashSet<Integer> tempUsed = new HashSet<>(used);
            tempUsed.add(i);
            if (tempHashMap.size() == chs.size()) {
                int left = 0;
                for (String str : this.words) {
                    left += translator(tempHashMap, str);
                }
                int right = translator(tempHashMap, this.result);
                if (right == left){
                    return true;
                }
            }else {
                if (dfs(pivot + 1, tempUsed, tempHashMap)) return true;
            }
        }
        return false;
    }

    public int translator (HashMap<Character,Integer> hm, String word) {
        int ans = 0;
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            ans *= 10;
            ans += hm.get(cs[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSolvable(new String[]{"SEND","MORE"}, "MONEY"));
    }
}
