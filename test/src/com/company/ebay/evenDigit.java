package com.company.ebay;

// how many numbers have even digit in a list.
//Ex.
//        Input: A = [12, 3, 5, 3456]
//        Output: 2
public class evenDigit {
    public static void main(String[] args) {
        int[] array = {12, 3, 5, 3456};
        System.out.println(evenDigit(array));
    }
    public static int evenDigit(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (Integer.toString(array[i]).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
