package com.v.ebay;

import java.util.*;
public class MaxArithmeticLength {
    public static void main(String[] args) {

    }
    public int maxArithmeticLength(int[] a, int[] b) {
        HashSet<Integer> hsA = new HashSet<>();
        HashSet<Integer> hsB = new HashSet<>();
        for (int temp : a) {
            hsA.add(temp);
        }
        for (int temp : b) {
            hsB.add(temp);
        }
        // a.length == 0
        if (a.length == 0) {
            return findMaxSeq(b, hsB);
        }
        // a.length == 1
        if (a.length == 1) {
            return findMaxSeqWithSingleNum(a[0], b, hsB);
        }
        int maxDivisor = a[1] - a[0];
        for (int i = 0; i < a.length - 1; i++) {
            int diff = a[i + 1] - a[i];
            maxDivisor = maxCommonDivisor(diff, maxDivisor);
        }
        int ans = -1;
        for (int i = 1; i <= maxDivisor; i++) {
            int count = 0;
            int cur = a[0];
            while (hsA.contains(cur) || hsB.contains(cur)) {
                count++;
                cur += i;
            }
            if (cur >= a[a.length - 1]) {
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }

    private int maxCommonDivisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        if (m % n == 0) {
            return n;
        } else {
            return maxCommonDivisor(n, m % n);
        }
    }

    private int findMaxSeq (int[] b, HashSet<Integer> hsB) {
        int ans = b.length == 0 ? 0 : 1;
        for (int i = 0; i < b.length - 1; i++) {
            int count = 2;
            int diff = b[i + 1] - b[i];
            int cur = b[i + 1];
            while (hsB.contains(cur + diff)) {
                count++;
                cur += diff;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    private int findMaxSeqWithSingleNum (int a, int[] b, HashSet<Integer> hsB) {
        int ans = 1;
        for (int value : b) {
            int count = 2;
            int diff = value > a ? value - a : a - value;
            int cur = value > a ? value : a;
            while (hsB.contains(cur + diff)) {
                count++;
                cur += diff;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
