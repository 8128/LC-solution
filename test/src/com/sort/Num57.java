package com.sort;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-28 02:57
 * @modified By：
 */
public class Num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList();
        for (int[] interval: intervals) {
            if ((interval[0] >= newInterval[0] && interval[0] <= newInterval[1]) ||
                    (interval[1] >= newInterval[0] && interval[1] <= newInterval[1]) ||
                    (interval[1] >= newInterval[1] && interval[0] <= newInterval[0]) ||
                    (newInterval[1] >= interval[1] && newInterval[0] <= interval[0])){
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                if(newInterval[0] < interval[0] && !list.contains(newInterval)){
                    list.offer(newInterval);
                    list.offer(interval);
                }else{
                    list.offer(interval);
                }
            }
        }
        if (!list.contains(newInterval)) {
            list.offer(newInterval);
        }
        int len = list.size();
        int[][] ans = new int[len][2];
        for (int i = 0; i < len; i++) {
            ans[i] = list.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,5},{6,7},{8,9}};
        Num57 num57 = new Num57();
        System.out.println(Arrays.deepToString(num57.insert(intervals, new int[]{0,1})));
    }
}
