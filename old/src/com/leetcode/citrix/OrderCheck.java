package com.leetcode.citrix;

import java.util.*;


public class OrderCheck{
    public int orderCheck(List<Integer> list){
        List<Integer> temp = new ArrayList(list);
        Collections.sort(temp);
        int len = list.size();
        int ans = 0;
        for (int i = 0; i < len; i++){
            if (temp.get(i) != list.get(i)){
                ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        OrderCheck orderCheck = new OrderCheck();
        List<Integer> mlist = new LinkedList<>();
        System.out.println(orderCheck.orderCheck(mlist));
    }
}