package com;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-23 22:15
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Contest {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int len = searchWord.length();
        char[] sead = searchWord.toCharArray();
        HashMap<Integer, List<String>> hm = new HashMap<>();
        for (String str : products) {
            int count = 0;
            char[] cs = str.toCharArray();
            for (int i = 0; i < len && i < cs.length; i++) {
                if (cs[i] == sead[i]) {
                    count++;
                }else {
                    break;
                }
            }
            List<String> temp = hm.getOrDefault(count, new ArrayList<>());
            temp.add(str);
            hm.put(count, temp);
        }
        LinkedList<List<String>> ans = new LinkedList<>();
        for (int i = 1; i <= len; i++) {
            LinkedList<String> temp = new LinkedList<>();
            int k = i;
            while (k <= len) {
                temp.addAll(hm.getOrDefault(k, new ArrayList<>()));
                k++;
            }
            Collections.sort(temp);
            if (temp.size()>3) {
                List<String> list = temp.subList(0,3);
                ans.addLast(list);
            } else {
                ans.addLast(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] products = new String[]{"havana"};
        String search = "tatiana";
        Contest contest = new Contest();
        System.out.println(contest.suggestedProducts(products, search));
    }

}