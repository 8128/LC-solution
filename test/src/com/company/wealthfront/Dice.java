package com.company.wealthfront;

import java.util.HashSet;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-05 00:14
 * @modified By：
 */
public class Dice {

    int[] dic1 = new int[]{1,6};
    int[] dic2 = new int[]{2,5};
    int[] dic3 = new int[]{3,4};
    int[] all = new int[]{1,2,3,4,5,6};


    public int dice (int[] d) {
        int ans = Integer.MAX_VALUE;
        for (int i : all) {
            ans = Math.min(ans, check(d, i));
        }
        return ans;
    }

    public int check (int[] d, int target) {
        int rotate = 0;
        for (int i : d) {
            if (i == target) {
                continue;
            } else if ( (has(dic1, target) && has(dic1, i)) || (has(dic2, target) && has(dic2, i)) || (has(dic3, target) && has(dic3, i))) {
                rotate += 2;
            } else {
                rotate++;
            }
        }
        return rotate;
    }

    public boolean has (int[] d, int target) {
        for (int i : d) {
            if (target == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.dice(new int[]{1,1,3,5,2,4}));
    }
}
