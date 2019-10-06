package com.company.clutter;

import java.util.Stack;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-06 17:37
 * @modified By：
 */
public class LastAndSecondLast {
    public String lastAndSecondLast (String string) {
        int len = string.length();
        char last = string.charAt(len - 1);
        char first = string.charAt(len - 2);
        return first + " " + last;
    }

    public static void main(String[] args) {
        LastAndSecondLast lastAndSecondLast = new LastAndSecondLast();
        System.out.println(lastAndSecondLast.lastAndSecondLast("APPLE"));
    }
}
