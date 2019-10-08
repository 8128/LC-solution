package com.company.broadway.round1;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-01 23:41
 * @modified By：
 */

public class TopK {
    public List<String> topK (String[] trades, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer a = hm.get(o1);
                Integer b = hm.get(o2);
                return b.compareTo(a);
            }
        });
        for (int i = 0; i < trades.length; i++) {
            String[] singleTrade = trades[i].split(" ");
            hm.put(singleTrade[0], hm.getOrDefault(singleTrade[0], 0) + 1);
            treeSet.add(singleTrade[0]);
        }
        List<String> ans = new ArrayList<>();
        Iterator<String> iterator = treeSet.iterator();
        for (int i = 0; i < k; i++) {
            ans.add(iterator.next());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] trades = new String[12];
        trades[0] = "absds 100000000";
        trades[1] = "absds 12231231";
        trades[2] = "kkkk 12231231";
        trades[3] = "csd 1111";
        trades[4] = "absds 122131231";
        trades[5] = "absds 122131231";
        trades[6] = "ksd 122131231";
        trades[7] = "s 122131231";
        trades[8] = "ksd 122131231";
        trades[9] = "ksd 122131231";
        trades[10] = "c 122131231";
        trades[11] = "absds 122131231";
        System.out.println(new TopK().topK(trades, 2));
    }
}
