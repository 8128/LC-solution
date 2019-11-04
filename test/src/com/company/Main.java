package com.company;

import java.text.*;
import java.util.*;

public class Main {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        HashMap<Integer, Character> pos = new HashMap<>();
        Stack<Integer> stack = new Stack();
        Set<Integer> toRemove = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')' && stack.isEmpty()) {
                toRemove.add(i);
                continue;
            }
            if (chars[i] == '(') {
                stack.push(i);
                pos.put(i, chars[i]);
            }
            if (chars[i] == ')') {
                Integer m = stack.pop();
                pos.remove(m);
            }
        }
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }
        System.out.println(toRemove);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (toRemove.contains(chars[i])) {
                continue;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
