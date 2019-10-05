package com.company.wealthfront;

import java.util.HashSet;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-05 00:14
 * @modified By：
 */
public class Dice {

    private int[] all = new int[]{1,2,3,4,5,6};


    int dice (int[] d) {
        int ans = Integer.MAX_VALUE;
        for (int i : all) {
            ans = Math.min(ans, check(d, i));
        }
        return ans;
    }

    int check (int[] d, int target) {
        int rotate = 0;
        for (int i : d) {
            if (i == target) {
                continue;
            } else if ( i + target == 7) {
                rotate += 2;
            } else {
                rotate++;
            }
        }
        return rotate;
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.dice(new int[]{1,1,3,5,2,4}));
    }
}
