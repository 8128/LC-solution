package com.contest.jan11;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-11 22:30
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution4 {

    char[] cs;
    public int minimumDistance(String word) {
        this.cs = word.toCharArray();
        return dfs(0, null, null, 0);
    }

    public int[] pos (char c) {
        int i = c - 'A';
        return new int[]{i/6, i%6};
    }

    public int dis (int[] a, int[] b) {
        if (a == null || b == null) {
            return 0;
        }
        return Math.abs(a[0]-b[0]) + Math.abs(a[1] - b[1]);
    }

    public int dfs (int index, int[] left, int[] right, int curCost) {
        if (index == cs.length) return curCost;
        char c = cs[index];
        int[] pos = pos(c);
        int toleft = dfs(index + 1, pos, right, curCost + dis(pos, left));
        int toright = dfs(index + 1, left, pos, curCost + dis(pos, right));
        return curCost + Math.min(toleft, toright);
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().minimumDistance("HAPPY"));
    }
}
