package com;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-23 22:15
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
class Contest {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,6,8,3,5,2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);
    }



}