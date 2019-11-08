package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 19:58
 * @leetcode :  https://leetcode.com/problems/word-break-ii/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class WordBreakII {
    HashMap<Integer, List<String>> map = new HashMap<>();


    public List<String> wordBreak(String s, List<String> dic) {
        Set<String> wordDict = new HashSet<>(dic);
        return word_Break(s, wordDict, 0);
    }


    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start == s.length()) {
            // it means that it reaches the end of the string
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
