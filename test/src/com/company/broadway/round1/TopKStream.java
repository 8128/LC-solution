package com.company.broadway.round1;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-02 00:44
 * @modified By：
 */
public class TopKStream {

    int k = 1;
    TreeSet<String> treeSet = null;
    HashMap<String, Integer> hm = null;


    public TopKStream (int k) {
        this.k = k;
        hm = new HashMap<>();
        treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer a = hm.get(o1);
                Integer b = hm.get(o2);
                return b.compareTo(a);
            }
        });
    }

    public List<String> topKStream (String trade) {
        String[] singleTrade = trade.split(" ");
        hm.put(singleTrade[0], hm.getOrDefault(singleTrade[0], 0) + 1);
        treeSet.remove(singleTrade[0]);
        treeSet.add(singleTrade[0]);
        List<String> ans = new ArrayList<>(k);
        Iterator<String> iterator = treeSet.iterator();
        int len = Math.min(k, treeSet.size());
        for (int i = 0; i < len; i++) {
            ans.add(iterator.next());
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TopKStream topKStream = new TopKStream(3);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(topKStream.topKStream(line));
        }
    }
}
