package com.v;

import java.util.*;

public class Main {

    public static int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            int re0 = j%3;
            int re1 = (j + 1)%3;
            int re2 = (j + 2)%3;
            int temp0 = Math.max(hm.getOrDefault(re0, 0), hm.getOrDefault(0, 0) + j);
            int temp1 = Math.max(hm.getOrDefault(re1, 0), hm.getOrDefault(1, 0) + j);
            int temp2 = Math.max(hm.getOrDefault(re2, 0), hm.getOrDefault(2, 0) + j);
            if (hm.containsKey(1)) {
                hm.put(re1, temp1);
            }
            if (hm.containsKey(2)) {
                hm.put(re2, temp2);
            }
            hm.put(re0, temp0);
            System.out.print(hm);
        }
        return hm.get(0);
    }


    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{4,1,5,3,1}));
    }
}
