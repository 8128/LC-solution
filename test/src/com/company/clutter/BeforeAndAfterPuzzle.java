package com.company.clutter;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-06 17:59
 * @modified By：
 */
public class BeforeAndAfterPuzzle {
    public List<String> beforeAndAfterPuzzle (String[] inputs) {
        HashMap<String, List<String>> heads = new HashMap<>();
        HashMap<String, List<String>> tails = new HashMap<>();
        for (String input : inputs) {
            String[] strings = input.split(" ");
            List<String> sameHead = heads.getOrDefault(strings[0], new ArrayList<>());
            List<String> sameTail = tails.getOrDefault(strings[strings.length - 1], new ArrayList<>());
            sameHead.add(input);
            sameTail.add(input);
            heads.put(strings[0], sameHead);
            tails.put(strings[strings.length - 1], sameTail);
        }
        List<String> ans = new ArrayList<>();
        for (String tail : tails.keySet()) {
            if (!heads.containsKey(tail)) {
                continue;
            }
            List<String> sameHead = heads.get(tail);
            List<String> sameTail = tails.get(tail);
            int len = tail.length();
            for (String tempTail : sameTail) {
                for (String tempHead : sameHead) {
                    ans.add(tempTail.substring(0, tempTail.length() - len) + tempHead);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BeforeAndAfterPuzzle beforeAndAfterPuzzle = new BeforeAndAfterPuzzle();
        System.out.println(beforeAndAfterPuzzle.beforeAndAfterPuzzle(new String[]{"mission statement", "a quick bite to eat", "a chip off the old block", "chocolate bar", "mission impossible", "a man on a mission", "block party", "eat my words", "bar of soap"}));
    }
}
