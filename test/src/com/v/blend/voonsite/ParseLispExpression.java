package com.v.blend.voonsite;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 03:13
 * @leetcode :  https://leetcode.com/problems/parse-lisp-expression/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class ParseLispExpression {

    public int evaluate(String expression) {
        return eval(expression);
    }

    private int eval(String exp) {
        if (exp.charAt(0) != '(') {
            // just a number or a symbol, even no brackets
            return Integer.parseInt(exp);
        }
        //This is to skip the most outter parentheses
        // and the protected keyword like add,let,multi. We can do it alternatively:
        List<String> tokens = parse(exp.substring(exp.indexOf(" ")+1, exp.length()-1));
        // add
        if (exp.startsWith("(a")) {
            return eval(tokens.get(0)) + eval(tokens.get(1));
        }// mult
        else if (exp.startsWith("(s")){
            return eval(tokens.get(0)) - eval(tokens.get(1));
        } else if (exp.startsWith("(m")) {
            return eval(tokens.get(0)) * eval(tokens.get(1));
        } else {
            return eval(tokens.get(0)) / eval(tokens.get(1));
        }
//        else { // let
//            for (int i = 0; i < tokens.size() - 2; i += 2) {
//                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
//            }
//            return eval(tokens.get(tokens.size() - 1), map);
//        }
    }
    private List<String> parse(String str) {
        // seperate the values between two parentheses
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            if (c == '(') par++;
            if (c == ')') par--;
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            res.add(new String(sb));
        }
        return res;
    }

    public static void main(String[] args) {
        ParseLispExpression parseLispExpression = new ParseLispExpression();
        System.out.println(parseLispExpression.evaluate("(div 2 (sub 2 4) )"));
    }
}
