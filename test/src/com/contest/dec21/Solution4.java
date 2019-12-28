package com.contest.dec21;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-12-21 22:15
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution4 {

    HashSet<Integer> seen = new HashSet<>();
    int[] status;
    int[] candies;
    int[][] keys;
    int[][] containedBoxes;
    int[] initialBoxes;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        this.status =  status;
        this.candies= candies;
        this.keys= keys;
        this.containedBoxes = containedBoxes;
        this.initialBoxes =  initialBoxes;
        int ans = 0;
        HashSet<Integer> reachable = new HashSet<>();
        for (int i : initialBoxes) {
            reachable.add(i);
        }
        boolean bl = true;
        while (bl){
            bl = findKey(reachable) || findBox(reachable);
        }
        for (int box : reachable) {
            if (status[box] == 1) {
                ans += candies[box];
            }
        }
        return ans;
    }

    public boolean findBox (HashSet<Integer> reachable) {
        boolean bl = false;
        for (int i : reachable) {
            if (seen.contains(i)) {
                continue;
            }
            bl = true;
            if (status[i] == 1) {
                for (int subBox : containedBoxes[i]) {
                    reachable.add(subBox);
                }
            }
        }
        return bl;
    }


    public boolean findKey (HashSet<Integer> reachable) {
        boolean bl = false;
        for (int i : reachable) {
            if (seen.contains(i)) {
                continue;
            }
            bl = true;
            for (int key : keys[i]) {
                status[key] = 1;
            }
            seen.add(i);
        }
        return bl;
    }
}
