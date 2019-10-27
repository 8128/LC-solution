package com.company.ebay;

import java.util.HashMap;
import java.util.Map;

// Give two String a and b find the is there any possible to repalce
// the same frequency character
public class constructorNames {
    public static void main(String[] args) {
        System.out.println(constructNames("babczzz","abbzccc"));
        System.out.println(constructNames("x","y"));
        System.out.println(constructNames("ii","i"));
    }
    public static boolean constructNames(String A, String B) {
        if (A.length() != B.length()) return false;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            mapA.put(A.charAt(i),mapA.getOrDefault(A.charAt(i),0) + 1);
            mapB.put(B.charAt(i),mapB.getOrDefault(B.charAt(i),0) + 1);
        }
        for (char keyA : mapA.keySet()) {
            for (char keyB : mapB.keySet()) {
                if (mapA.containsKey(keyB) && mapB.containsKey(keyA)) {
                    if (mapA.get(keyB) == mapB.get(keyA) && mapA.get(keyA) == mapB.get(keyB)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
