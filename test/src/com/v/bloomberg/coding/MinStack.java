package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 20:09
 * @leetcode :  https://leetcode.com/problems/min-stack/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class MinStack {

    int min;
    Stack<Integer> stack;

    public MinStack(){
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min)
            min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
