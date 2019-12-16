package com.contest.Dec14;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-14 21:47
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = Arrays.asList(12, 23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,345678,456789,1234567,2345678,3456789,12345678,23456789,123456789);
        int l = Collections.binarySearch(list, low);
        int r = Collections.binarySearch(list, high);
        if (r > 0) {
            r++;
        }
        if (l < 0) {
            l = -l - 1;
        }
        if (r < 0) {
            r = -r - 1;
        }
        return list.subList(l, r);
    }

    public static void main(String[] args) {
        System.out.println(new SequentialDigits().sequentialDigits(123,300));
    }
}
