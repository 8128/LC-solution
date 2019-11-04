package com.v.ebay;

public class ProductMinusSum {
    public static void main(String[] args) {

    }
    private static int productMinusSum(int x) {
        int product = 1;
        int sum = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}
