package com.company.broadway;

import java.util.LinkedList;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-01 22:03
 * @modified By：
 */
public class BaseInteger {

    char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/".toCharArray();

    // official api
    public String baseInteger(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    // DIY
    public String baseIntegerConverter (String str, int fromBase, int toBase) {
        return decimalNewBase(stringDecimal(str, fromBase), toBase);
    }

    public int stringDecimal (String str, int fromBase) {
        char[] ints = str.toCharArray();
        int ans = 0;
        int power = 0;
        for (int j = str.length() - 1; j >= 0; j--) {
            ans += findPos(ints[j]) * Math.pow(fromBase, power);
            power++;
        }
        return ans;
    }

    public int findPos (char c) {
        int i = 0;
        for (char ch : chars) {
            if (c == ch) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String decimalNewBase (int decimal, int newBase) {
        LinkedList<Character> list = new LinkedList<>();
        while (decimal != 0) {
            int temp = decimal % newBase;
            decimal = decimal/newBase;
            list.push(chars[temp]);
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            sb.append(list.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BaseInteger baseInteger = new BaseInteger();
        System.out.println(baseInteger.baseInteger("ggg", 32, 2));
        System.out.println(baseInteger.baseIntegerConverter("ggg", 32, 2));
    }
}
