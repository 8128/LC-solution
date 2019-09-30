package com.company;

import java.text.*;
import java.util.*;

public class Main {

    public void maximumSum(int[] arr) {
        arr[1] = 1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = new int[]{1,-2,0,3};
        main.maximumSum(arr);
        System.out.println(Arrays.toString(arr));

    }
}
