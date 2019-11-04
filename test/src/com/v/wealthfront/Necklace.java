package com.v.wealthfront;

import java.util.HashSet;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-04 23:36
 * @modified By：
 */
public class Necklace {
    public int necklace (int[] a) {
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (hs.contains(a[i])) {
                continue;
            }
            int k = i;
            hs.add(k);
            int temp = 1;
            while (!hs.contains(a[k])) {
                hs.add(a[k]);
                k = a[k];
                temp++;
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Necklace necklace = new Necklace();
        System.out.println(necklace.necklace(new int[]{5,4,0,3,1,6,2}));
    }
}
