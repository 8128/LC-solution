package com.v.expedia;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-12 12:36
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class CityAttractions {

    static int[] beaut;
    static HashMap<Integer, HashMap<Integer, Integer>> hm;
    public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v, List<Integer> t){
        hm = new HashMap<>();
        beaut = new int[beauty.size()];
        for (int i = 0; i < beauty.size(); i++) {
            beaut[i] = beauty.get(i);
        }
        for (int i = 0; i < u.size(); i++) {
            HashMap<Integer, Integer> tempMap = hm.getOrDefault(u.get(i), new HashMap<>());
            tempMap.put(v.get(i), t.get(i));
            hm.put(u.get(i), tempMap);
            tempMap = hm.getOrDefault(v.get(i), new HashMap<>());
            tempMap.put(u.get(i), t.get(i));
            hm.put(v.get(i), tempMap);
        }
        return recursive(0, max_t);
    }

    public static int recursive (int index, int remain){
        Map<Integer, Integer> map = hm.get(index);
        int max = beaut[index];
        beaut[index] = 0;
        int temp = 0;
        for (int key : map.keySet()) {
            if (remain > map.get(key)) {
                temp = Math.max(temp, recursive(key, remain - map.get(key)));
            }
        }
        if (temp < 0) {
            return max;
        }
        return max+temp;
    }

    public static void main(String[] args) {
        System.out.println(findBestPath(4, 3, 30, Arrays.asList(5, 10, 15, 20), Arrays.asList(0, 1, 1), Arrays.asList(1,2,3), Arrays.asList(6,7,10)));
    }
}
