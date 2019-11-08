package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 11/8/2019 2:54 AM
 * @leetcode :  https://leetcode.com/problems/kill-process/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class KillProcess {
    public List <Integer> killProcess(List <Integer> pid, List <Integer> ppid, int kill) {

        //store id and their subones
        HashMap <Integer, List <Integer>> map = new HashMap();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List <Integer> l = map.getOrDefault(ppid.get(i), new ArrayList <Integer>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        Queue <Integer> queue = new LinkedList();
        List <Integer> ans = new ArrayList();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int r = queue.remove();
            ans.add(r);
            if (map.containsKey(r))
                for (int id: map.get(r))
                    queue.add(id);
        }
        return ans;
    }
}
