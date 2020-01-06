package com.contest.jan4;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-04 22:44
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution4 {
    HashMap<String, Integer> hm;
    int ans = Integer.MAX_VALUE;

    public int minInsertions(String s) {
        hm = new HashMap<>();
        insert(0, s);
        return ans;
    }

    public void insert(int curStep, String curStr){
        if (curStep > ans) return;
        if (hm.containsKey(curStr) && hm.get(curStr) <= curStep) return;
        hm.put(curStr, curStep);
        int l = 0;
        int r = curStr.length() - 1;
        while (l < r) {
            if (curStr.charAt(l) != curStr.charAt(r)) {
                curStr = curStr.substring(l,r+1);
                StringBuilder sb1 = new StringBuilder(curStr);
                sb1.insert(curStr.length(), curStr.charAt(0));
                StringBuilder sb2 = new StringBuilder(curStr);
                sb2.insert(0, curStr.charAt(curStr.length() - 1));
                //System.out.println(curStr + "  "+sb1 + "   "+ sb2 + "   "+curStep);
                insert(curStep + 1, sb1.toString());
                insert(curStep + 1, sb2.toString());
                return;
            }
            l++;
            r--;
        }
        //System.out.println(curStep);
        ans = Math.min(ans, curStep);
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.minInsertions("bypqsvqpzruzlagimzxuejvxjrrzcsjakirmlsyqehmndhqgzqsogrtvzpnqbpmavcqtmmfesbfpnoyzrekvtwphdgwxoovpsxusfbxbofvzenivkududlgeiqjllvuavqcjupcdztdensvntciozyjfcxsqawbajtzjbkyoadjluayyaluscgopqnkzidyzwokryhcsjlhvyyxzghdrcjjfxyjdpfe"));
    }
}
