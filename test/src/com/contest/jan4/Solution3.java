package com.contest.jan4;


import org.omg.CORBA.ARG_IN;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-04 22:02
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution3 {
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        HashSet<Integer> seen = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int l = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int me = q.poll();
                System.out.println(me);
                if (l == level) {
                    List<String> viewed = watchedVideos.get(me);
                    for (String str : viewed) {
                        hm.put(str, hm.getOrDefault(str, 0) + 1);
                    }
                }
                int[] myfriends = friends[me];
                for (int k : myfriends) {
                    if (seen.contains(k)) continue;
                    q.offer(k);
                    seen.add(k);
                }
            }
            l++;
            if (l > level) break;
        }
        List<String> ans = new ArrayList<>(hm.keySet());
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hm.get(o1) == hm.get(o2)) {
                    return o1.compareTo(o2);
                }
                return Integer.compare(hm.get(o1), hm.get(o2));
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        HashSet<StringBuilder> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder("ab");
        sb.insert(1,"a");
        System.out.println(sb);

    }
}
