package com.company.ebay;

// 反转连续的两个字符, "abcdef" => "badcfe"
public class rotateTwoChar {
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(rotateTwoChar(s));
    }
    public static String rotateTwoChar(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2) {
            reverse(ch, i, i + 1);
        }
        return String.valueOf(ch);
    }

    private static void reverse(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}
