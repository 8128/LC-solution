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

    static HashMap<Integer, HashMap<Integer, Integer>> hm;
    static List<Integer> ans;

    public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v, List<Integer> t){
        hm = new HashMap<>();
        int[] beaut = new int[beauty.size()];
        ans = new ArrayList<>();
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
        recursive(0, max_t,beaut, 0);
        Collections.sort(ans);
        return ans.get(ans.size() - 1);
    }

    public static void recursive (int index, int remain,int[] beaut, int b){
        if (index == 0) {
            ans.add(b);
        }
        Map<Integer, Integer> map = hm.get(index);
        int tmp = beaut[index];
        int[] tempArray = beaut.clone();
        tempArray[index] = 0;
        for (int key : map.keySet()) {
            if (remain >= map.get(key)) {
                recursive(key, remain - map.get(key),tempArray, b + tmp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findBestPath(4, 3, 30, Arrays.asList(5, 10, 15, 20), Arrays.asList(0, 1, 1), Arrays.asList(1,2,3), Arrays.asList(6,7,10)));
    }
}
