package com.v.expedia;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-12 11:19
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class NodeDistance {

    public static List<Integer> nodeDistance (int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < gFrom.size(); i++) {
            List<Integer> temp = hm.getOrDefault(gFrom.get(i), new ArrayList<>());
            temp.add(gTo.get(i));
            hm.put(gFrom.get(i), temp);
            temp = hm.getOrDefault(gTo.get(i), new ArrayList<>());
            temp.add(gFrom.get(i));
            hm.put(gTo.get(i), temp);
        }
        HashSet<Integer> circle = new HashSet<>();
        for (int i = 1; i <= gNodes; i++) {
            HashSet<Integer> tempSet = checkLoop(i, i, new HashSet<>(), hm);
            if (!tempSet.isEmpty()) {
                circle = tempSet;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= gNodes; i++) {
            ans.add(bfsToTarget(i, circle, hm));
        }
        return ans;
    }

    public static HashSet<Integer> checkLoop(int target, int index, HashSet<Integer> seen, HashMap<Integer, List<Integer>> hm) {
        List<Integer> tempList = hm.getOrDefault(index, new ArrayList<>());
        for (int node : tempList) {
            if (node == target && seen.size() > 1) {
                seen.add(index);
                return seen;
            }
            if (!seen.contains(node)) {
                HashSet<Integer> tempSet = new HashSet<>(seen);
                tempSet.add(index);
                HashSet<Integer> tempAns = checkLoop(target, node, tempSet, hm);
                if(!tempAns.isEmpty()){
                    return tempAns;
                }
            }
        }
        return new HashSet<>();
    }

    public static int bfsToTarget(int index, HashSet<Integer> circle, HashMap<Integer, List<Integer>> hm) {
        int depth = 0;
        if (circle.contains(index)) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        seen.add(index);
        q.offer(index);
        depth++;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                List<Integer> tmpList = hm.get(tmp);
                for (int next : tmpList) {
                    if (circle.contains(next)) {
                        return depth;
                    }
                    if (!seen.contains(next)) {
                        q.offer(next);
                        seen.add(next);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> gFrom = new ArrayList<>();
        gFrom.addAll(Arrays.asList(1,2,1,3,1,2));
        List<Integer> gTo = new ArrayList<>();
        gTo.addAll(Arrays.asList(2,3,3,5,4,6));
        System.out.println(nodeDistance(6, gFrom, gTo));
    }
}
