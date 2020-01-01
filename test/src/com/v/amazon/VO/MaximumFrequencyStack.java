package com.v.amazon.VO;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-01 00:01
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public MaximumFrequencyStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack maximumFrequencyStack = new MaximumFrequencyStack();
        maximumFrequencyStack.push(5);
        maximumFrequencyStack.push(7);
        maximumFrequencyStack.push(5);
        maximumFrequencyStack.push(7);
        maximumFrequencyStack.push(4);
        maximumFrequencyStack.push(5);
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
        System.out.println(maximumFrequencyStack.pop());
    }
}
