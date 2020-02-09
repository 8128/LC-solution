package com.contest.feb8;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2/8/20 9:25 PM
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Solution1 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet();
        for (int i : arr) {
            if (hs.contains(2  * i)) {
                return true;
            }
            if (i%2 == 0 && hs.contains(i/2)) {
                return true;
            }
            hs.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().checkIfExist(new int[]{3,1,7,11}));;
    }
}
