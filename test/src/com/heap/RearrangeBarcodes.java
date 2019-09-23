package com.heap;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-19 17:28
 * @modified By：
 */
public class RearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes == null || barcodes.length == 0)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: barcodes)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a,b)->b.getValue()-a.getValue() == 0?a.getKey() - b.getKey(): b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry:map.entrySet())
            pq.offer(entry);
        int[] res = new int[barcodes.length];
        int i = 0;
        while(!pq.isEmpty()) {
            int k = 2;
            List<Map.Entry> tempList = new ArrayList<Map.Entry>();
            while(k > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> head = pq.poll();
                head.setValue(head.getValue() - 1);
                res[i++] = head.getKey();
                tempList.add(head);
                k--;
            }
            for(Map.Entry<Integer, Integer> e: tempList) {
                if(e.getValue() > 0)
                    pq.add(e);
            }
            if(pq.isEmpty())
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        RearrangeBarcodes rearrangeBarcodes = new RearrangeBarcodes();
        System.out.println(Arrays.toString(rearrangeBarcodes.rearrangeBarcodes(new int[]{7,7,7,8,5,7,5,5,5,8})));
    }
}
