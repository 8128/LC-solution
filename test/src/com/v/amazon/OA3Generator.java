package com.v.amazon;

import java.util.Scanner;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-16 15:43
 */
public class OA3Generator {

    public static void main(String[] args) {
        String string1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String string2 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26";
        String[] str1 = string1.split("");
        String[] str2 = string2.split(" ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            StringBuilder sb = new StringBuilder();
            if (returnIndex(split[0], str1) != -1) {
                for (int i = 0; i < split.length; i++) {
                    if (returnIndex(split[i], str1) == -1) {
                        System.out.println("Wrong Input AS CHAR");
                        continue;
                    }
                    sb.append(str2[returnIndex(split[i], str1)]).append(" ");
                }
                System.out.println(sb.toString());
            } else if (returnIndex(split[0], str2) != -1) {
                for (int i = 0; i < split.length; i++) {
                    if (returnIndex(split[i], str2) == -1) {
                        System.out.println("Wrong Input AS NUM");
                        continue;
                    }
                    sb.append(str1[returnIndex(split[i], str2)]).append(" ");
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("FUCKING DUMBASS, WRONG INPUT");
            }
        }
    }

    public static int returnIndex (String s, String[] str) {
        for (int i = 0; i < str.length; i++) {
            if (s.equals(str[i])) {
                return i;
            }
        }
        return -1;
    }
}
