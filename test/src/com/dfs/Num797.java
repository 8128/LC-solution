package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-01 02:25
 * @modified By：
 */
class Num797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] seen = new boolean[graph.length];
        for (int node : graph[0]){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(node);
            boolean[] tempSeen = seen.clone();
            tempSeen[node] = true;
            dfs(node, temp, tempSeen, graph, ans);
        }
        return ans;
    }

    public void dfs (int pos, List<Integer> curList, boolean[] seen, int[][] graph, List<List<Integer>> ans) {
        if (pos == graph.length-1) {
            ans.add(curList);
            return;
        }
        for (int node : graph[pos]) {
            if (!seen[node]) {
                boolean[] tempSeen = seen.clone();
                tempSeen[node] = true;
                List<Integer> temp = new ArrayList<>(curList);
                temp.add(node);
                dfs(node, temp, tempSeen, graph, ans);
            }
        }
    }
}
