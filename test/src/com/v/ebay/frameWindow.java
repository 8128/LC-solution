package com.v.ebay;

public class frameWindow {
    public static void main(String[] args) {
        printWindow(8);
    }

    public static void printWindow(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println("");
        for (int row = 1; row < n - 1; row++) {
            System.out.print("*");
            for (int col = 1; col < n - 1; col++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < n ; i++) {
            System.out.print("*");
        }
    }

}
