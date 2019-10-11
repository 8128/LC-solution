package com.company;

import java.text.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("abc", 1);
        hm.put("kfc", 9);
        hm.put("z", 7);
        Set<String> set = hm.keySet();
        List<String> list = new ArrayList<>(set);
        Set<Map.Entry<String, Integer>> mE = hm.entrySet();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer a = hm.get(o1);
                Integer b = hm.get(o2);
                return a.compareTo(b);
            }
        });
        System.out.println(list);
    }
}
