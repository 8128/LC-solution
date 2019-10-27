package com.company.ebay;

import java.util.HashMap;
import java.util.Map;

class longestEqualSubarray {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        System.out.println(maxLen(arr));
    }

    public static int maxLen(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }
}

