package com.v.mathwork;

import java.util.Stack;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-29 18:04
 * @leetcode : https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 */
public class MctFromLeafValues {
    public int mctFromLeafValues(int[] A) {
        int res = 0, n = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
