package com.v.clutter;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-06 17:37
 * @modified By：
 */
public class LastAndSecondLast {
    public String lastAndSecondLast (String string) {
        int len = string.length();
        char last = string.charAt(len - 1);
        if (len == 1) {
            return String.valueOf(last);
        }
        char first = string.charAt(len - 2);
        return last + " " + first;
    }

    public static void main(String[] args) {
        LastAndSecondLast lastAndSecondLast = new LastAndSecondLast();
        System.out.println(lastAndSecondLast.lastAndSecondLast("APPLE"));
        System.out.println(lastAndSecondLast.lastAndSecondLast("E"));
    }
}
