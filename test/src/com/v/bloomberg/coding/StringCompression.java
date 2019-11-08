package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 16:40
 * @leetcode :  https://leetcode.com/problems/string-compression/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class StringCompression {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }

    public char[] decompress(char[] chars) {
        if (chars.length == 0) {
            return chars;
        }
        StringBuilder sb = new StringBuilder();
        char lastChar = '?';
        for (int i = 0; i < chars.length; i++) {
            StringBuilder temp = new StringBuilder();
            while (i < chars.length && Character.isDigit(chars[i])) {
                temp.append(chars[i]);
                i++;
            }
            if (temp.length() != 0) {
                int k = Integer.valueOf(temp.toString());
                while(k != 0) {
                    sb.append(lastChar);
                    k--;
                }
            }
            if (i < chars.length && !Character.isDigit(chars[i])) {
                lastChar = chars[i];
            }
        }
        return sb.toString().toCharArray();
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.decompress(new char[]{'a','1','0','b','4'}));
    }
}
