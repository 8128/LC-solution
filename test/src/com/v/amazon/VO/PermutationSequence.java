package com.v.amazon.VO;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-12 17:26
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> all = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            all.addLast(i);
        }
        while (all.size() != 0) {
            int round = factorial(all.size() - 1);
            int need = k/round;
            k = k % round;
            if (k == 0 && need > 0) {
                need -= 1;
                k = round;
            }
            sb.append(all.get(need));
            all.remove(need);
        }
        return sb.toString();
    }

    public int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3,3));
    }
}
