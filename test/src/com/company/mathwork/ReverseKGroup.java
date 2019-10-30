package com.company.mathwork;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-30 14:23
 * @leetcode : https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {

    Queue<Integer> q  = new LinkedList<>();

    private final static Logger logger = Logger.getLogger(ReverseKGroup.class.getName());

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) {
            // if k+1 node is found
            curr = reverseKGroup(curr, k);
            // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) {
                // reverse current k-group:
                ListNode tmp = head.next;
                // tmp - next head in direct part
                head.next = curr;
                // preappending "direct" head to the reversed list
                curr = head;
                // move head of reversed part to a new node
                head = tmp;
                // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
