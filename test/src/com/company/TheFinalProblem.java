package com.company;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-09-11 13:57
 * @modified By：
 */
class TheFinalProblem {
    private int theFinalProblem(String s) {
        int len = s.length();
        if (len==0) {
            return 0;
        }
        int ans = 0;
        int[] integers = new int[len];
        char[] chars = s.toCharArray();
        for (int i=0; i < len; i++) {
            integers[i] = chars[i] - '0';
        }
        if (len == 1){
            return integers[0] == 1 ? 1 : 0;
        }
        int j = len - 1;
        while (integers[j] == 0){
            j--;
        }
        if (integers[0] == 1) {
            ans++;
        }
        for (int i=1; i<=j; i++){
            if(integers[i-1] != integers[i]){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TheFinalProblem solution = new TheFinalProblem();
        System.out.println(solution.theFinalProblem("101011"));
    }
}
