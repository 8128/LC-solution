package com.v;

import java.util.*;

public class Main {

    public static String freqAlphabets(String s) {
        String[] strs = s.split("#");
        boolean bl = false;
        if (s.charAt(s.length() - 1) != '#') bl = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (bl && i == strs.length - 1) {
                char[] cs = str.toCharArray();
                for (char c : cs) {
                    sb.append((char)(c-'1'+'a'));
                }
                continue;
            }
            String firstStr = str.substring(0, str.length() - 2);
            String secondStr = str.substring(str.length() - 2, str.length());
            char[] cs = firstStr.toCharArray();
            for (char c : cs) {
                sb.append((char)(c-'1'+'a'));
            }
            int k = Integer.valueOf(secondStr);
            sb.append((char)(k + 'a' - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("ab");
        list.add("zhjs");
        list.add("jsod");
        Collections.sort(list);
        System.out.println(list);
    }
}
