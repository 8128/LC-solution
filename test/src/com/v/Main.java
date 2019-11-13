package com.v;

import java.util.*;

public class Main {

    public static String mix(String s1, String s2) {
        // your code
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        HashMap<Character, StringBuilder> hm1 = new HashMap<>();
        HashMap<Character, StringBuilder> hm2 = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        for (char c : c1) {
            if(c - 'a' >= 26 || c - 'a' < 0){
                continue;
            }
            StringBuilder sb = hm1.getOrDefault(c, new StringBuilder());
            sb.append(c);
            hm1.put(c, sb);
        }
        for (char c : c2) {
            if(c - 'a' >= 26 || c - 'a' < 0){
                continue;
            }
            StringBuilder sb = hm2.getOrDefault(c, new StringBuilder());
            sb.append(c);
            hm2.put(c, sb);
        }
        List<Character> key1 = new ArrayList<>(hm1.keySet());
        List<Character> key2 = new ArrayList<>(hm2.keySet());
        for (Character c : key1) {
            if (hm1.get(c).length() <= 1) {
                hm1.remove(c);
            }else if (hm2.containsKey(c) && hm2.get(c).length() > hm1.get(c).length()) {
                hm1.remove(c);
            }
        }
        for (Character c : key2) {
            if (hm2.get(c).length() <= 1) {
                hm2.remove(c);
            }else if (hm1.containsKey(c) && hm1.get(c).length() >= hm2.get(c).length()) {
                hm2.remove(c);
            }
        }
        key1 = new ArrayList<>(hm1.keySet());
        key2 = new ArrayList<>(hm2.keySet());
        key1.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (hm1.get(o2).length() == hm1.get(o1).length()){
                    return Integer.compare(o1, o2);
                }
                return hm1.get(o2).length() - hm1.get(o1).length();
            }
        });
        key2.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (hm2.get(o2).length() == hm2.get(o1).length()){
                    return Integer.compare(o1, o2);
                }
                return hm2.get(o2).length() - hm2.get(o1).length();
            }
        });
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while (i < key1.size() && j < key2.size()) {
            if (seen.contains(key1.get(i))) {
                i++;
                continue;
            }
            if (seen.contains(key2.get(j))) {
                j++;
                continue;
            }
            if (hm1.get(key1.get(i)).length() > hm2.get(key2.get(j)).length()){
                seen.add(key1.get(i));
                ans.append("1:").append(hm1.get(key1.get(i))).append("/");
                i++;
                while(i < s1.length() && hm1.get(key1.get(i)).length() == hm1.get(key1.get(i-1)).length()){
                    if (seen.contains(key1.get(i))) {
                        i++;
                        continue;
                    }
                    ans.append("1:").append(hm1.get(key1.get(i))).append("/");
                    seen.add(key1.get(i));
                    i++;
                }
            }else if (hm1.get(key1.get(i)).length() < hm2.get(key2.get(j)).length()){
                seen.add(key2.get(j));
                ans.append("2:").append(hm2.get(key2.get(j))).append("/");
                j++;
                while(j < s2.length() && hm2.get(key2.get(j)).length() == hm2.get(key2.get(j-1)).length()){
                    if (seen.contains(key2.get(j))) {
                        j++;
                        continue;
                    }
                    ans.append("2:").append(hm2.get(key2.get(j))).append("/");
                    seen.add(key2.get(j));
                    j++;
                }
            } else {
                if (key1.get(i) <= key2.get(j)) {
                    seen.add(key1.get(i));
                    ans.append("1:").append(hm1.get(key1.get(i))).append("/");
                    i++;
                    while(i < key1.size() && hm1.get(key1.get(i)).length() == hm1.get(key1.get(i-1)).length()){
                        if (seen.contains(key1.get(i))) {
                            i++;
                            continue;
                        }
                        ans.append("1:").append(hm1.get(key1.get(i))).append("/");
                        seen.add(key1.get(i));
                        i++;
                    }
                    ans.append("=:").append(hm2.get(key2.get(j))).append("/");
                    j++;
                    while(j < key2.size() && hm2.get(key2.get(j)).length() == hm2.get(key2.get(j-1)).length()){
                        if (seen.contains(key2.get(j))) {
                            j++;
                            continue;
                        }
                        ans.append("=:").append(hm2.get(key2.get(j))).append("/");
                        seen.add(key2.get(j));
                        j++;
                    }
                }else{
                    ans.append("2:").append(hm2.get(key2.get(j))).append("/");
                    seen.add(key2.get(j));
                    j++;
                    while(j < key2.size() && hm2.get(key2.get(j)).length() == hm2.get(key2.get(j-1)).length()){
                        if (seen.contains(key2.get(j))) {
                            j++;
                            continue;
                        }
                        ans.append("2:").append(hm2.get(key2.get(j))).append("/");
                        seen.add(key2.get(j));
                        j++;
                    }
                    ans.append("=:").append(hm1.get(key1.get(i))).append("/");
                    i++;
                    while(i < key1.size() && hm1.get(key1.get(i)).length() == hm1.get(key1.get(i-1)).length()){
                        if (seen.contains(key1.get(i))) {
                            i++;
                            continue;
                        }
                        ans.append("=:").append(hm1.get(key1.get(i))).append("/");
                        seen.add(key1.get(i));
                        i++;
                    }
                }
            }
        }
        if (i < key1.size()) {
            ans.append("1:").append(hm1.get(key1.get(i))).append("/");
            i++;
        }
        if (j < key2.size()) {
            ans.append("2:").append(hm2.get(key2.get(j))).append("/");
            j++;
        }
        if(ans.length()>0) {
            ans.deleteCharAt(ans.length()-1);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(mix("Are they here", "yes, they are here"));
    }
}
