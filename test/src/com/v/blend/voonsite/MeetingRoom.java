package com.v.blend.voonsite;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-04 18:22
 */
public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1], b[1]);
            }
        });
        int ans=1;
        if(intervals.length==0) {
            return 0;
        }
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] temp = pq.poll();
            if(intervals[i][0] >= temp[1]){
                temp[1] = intervals[i][1];
            }else{
                pq.add(intervals[i]);
            }
            pq.add(temp);
        }
        return pq.size();
    }
}
