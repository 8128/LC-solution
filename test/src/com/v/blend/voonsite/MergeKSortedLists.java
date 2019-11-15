package com.v.blend.voonsite;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-14 02:18
 * @leetcode : https://leetcode.com/problems/merge-k-sorted-lists/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists) {
            if (node!=null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }


    // divide and conquer
    public ListNode mergeKLists2(ListNode[] lists) {
        // Corner cases.
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        // Base cases.
        if (end < start) {
            return null;
        }
        if (end - start == 0) {
            return lists[start];
        }
        if (end - start == 1) {
            return mergeTwoLists(lists[start], lists[end]);
        }

        // Divide lists into 2 sublists and sort them as a whole recursively.
        int mid = start + ((end - start) >> 1);
        ListNode lower = mergeKLists(lists, start, mid);
        ListNode upper = mergeKLists(lists, mid + 1, end);

        return mergeTwoLists(lower, upper);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0), ptr = dummyHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                ptr.next = head1;
                head1 = head1.next;
            } else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }
        if (head1 != null) {
            ptr.next = head1;
        } else if (head2 != null) {
            ptr.next = head2;
        }
        return dummyHead.next;
    }
}
