package com.v.blend.voonsite;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-04 17:46
 */
public class IntervalCounter {

    public int[][] intervalCounter (int[][] input) {
        int[] start = new int[input.length];
        int[] end = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            start[i] = input[i][0];
            end[i] = input[i][1];
        }
        // if it is not sorted
        Arrays.sort(start);
        Arrays.sort(end);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int startPivot = 0;
        int endPivot = 0;
        int times = 0;
        while (startPivot < input.length) {
            if (start[startPivot] < end[endPivot]) {
                times++;
                treeMap.put(start[startPivot], times);
                startPivot++;
            } else {
                times--;
                treeMap.put(end[endPivot], times);
                endPivot++;
            }
        }
        while (endPivot < input.length) {
            times--;
            treeMap.put(end[endPivot], times);
            endPivot++;
        }
        int[][] ans = new int[treeMap.size()][2];
        int i = 0;
        for (int key : treeMap.keySet()) {
            ans[i][0] = key;
            ans[i][1] = treeMap.get(key);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        IntervalCounter intervalCounter = new IntervalCounter();
        System.out.println(Arrays.deepToString(intervalCounter.intervalCounter(new int[][]{{3,7},{5,7},{7,15},{8,12},{8,20},{14,20}})));
        System.out.println(Arrays.deepToString(intervalCounter.intervalCounter(new int[][]{{1,2},{5,6},{1,3},{4,10}})));
        System.out.println(Arrays.deepToString(intervalCounter.intervalCounter(new int[][]{{1,3},{6,7},{2,4},{2,5},{9,12}})));
    }
}
