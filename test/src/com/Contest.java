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
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(2);
        lhs.add(5);
        lhs.add(8);
        lhs.remove(2);
        lhs.add(8);
        Iterator iterator = lhs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }



}