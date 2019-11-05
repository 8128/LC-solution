package com.v.blend.voonsite;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-04 17:46
 */
public class IntervalCounter {

    public int[][] intervalCounter (int[][] input) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Arrays.sort(input, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(input[0]);
        treeMap.put(input[0][0], 1);
        for (int i = 1; i < input.length; i++) {
            int[] temp = pq.poll();
            if (temp[1] < temp[])
        }
    }
}
