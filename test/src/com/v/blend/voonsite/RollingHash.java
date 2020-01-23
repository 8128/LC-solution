package com.v.blend.voonsite;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-23 01:53
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class RollingHash {

    int prime1 = 29;
    int prime2 = 257;

    public int rollingHash (String haystack, String needle) {
        int len = needle.length();
        if (haystack.length() < len) return -1;
        if (needle.length() == 0) return 0;
        if (haystack.length() == len) return haystack.equals(needle) ? 0 : -1;
        int hashNeedle = hash(needle.toCharArray(), 0, needle.length());
        char[] cs = haystack.toCharArray();
        int hashHaystack = hash(cs, 0, needle.length());
        int mf = 1;
        for ( int i = 1; i < needle.length(); i++ ) { mf = ( mf * prime1 ) % prime2; }

        for (int i = needle.length(); i < haystack.length(); i++) {
            System.out.println(hashHaystack + "    " + hashNeedle);
            if (hashHaystack == hashNeedle && haystack.substring(i - needle.length(),i).equals(needle)) {
                return i - needle.length();
            } else {
                int last = (cs[i - needle.length()] * mf)%prime2;
                hashHaystack = ((hashHaystack + prime2 - last) * prime1 + cs[i])%prime2;
            }
        }
        System.out.println(hash(cs, 1, 1 + needle.length()));
        return -1;
    }

    public int hash (char[] cs, int start, int end) {
        int res = 0;
        int k = end - start - 1;
        for (int i = start; i < end; i++) {
            res = (res + cs[i] * (int)(Math.pow(prime1, k--)))%prime2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RollingHash().rollingHash("missipmississippi","issip"));
    }
}
