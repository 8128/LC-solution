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


class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    public int eval (String expression, HashMap<String, Integer> hm) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.valueOf(expression);
            }
            return hm.get(expression);
        }
        String sub = expression.substring(0,2);
        HashMap<String, Integer> cur = new HashMap<>(hm);
        List<String> tokens = parse(expression.substring(expression.indexOf(' ') + 1 , expression.length() - 1));
        if (sub.equals("(m")) {
            return eval(tokens.get(0), cur) * eval(tokens.get(1), cur);
        } else if (sub.equals("(a")) {
            return eval(tokens.get(0), cur) + eval(tokens.get(1), cur);
        } else {
            for (int i = 0; i < tokens.size(); i+=2) {
                cur.put(tokens.get(i), eval(tokens.get(i + 1), hm));
            }
            return eval(tokens.get(tokens.size() - 1), cur);
        }
    }

    public List<String> parse (String all) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        List<String> tokens = new ArrayList<>();
        for (char c : all.toCharArray()) {
            if (c == '(') cnt++;
            if (c == ')') cnt--;
            if (c == ' ' && cnt == 0) {
                tokens.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            tokens.add(sb.toString());
        }
        return tokens;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evaluate("(add 1 2)"));
    }
}