package com.company.blend.voonsite;

import java.util.*;
/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-03 21:56
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int j=1;
        for (int num : nums) {
            hs.add(num);
            while (hs.contains(j)) {
                j++;
            }
        }
        return j;
    }

    public int firstMissingPositive1(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] >= 1 && A[i] <= A.length && A[A[i]-1] != A[i]) {
                swap(A, i, A[i]-1);
            }else{
                i++;
            }
        }
        i = 0;
        while(i < A.length && A[i] == i+1) {
            i++;
        }
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
