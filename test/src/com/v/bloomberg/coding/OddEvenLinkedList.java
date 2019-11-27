package com.v.bloomberg.coding;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-26 21:52
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode oddLast = cur;
        ListNode evenFirst = cur.next;
        ListNode evenLast = evenFirst;
        if (evenLast == null) return head;
        cur = cur.next.next;
        int i = 1;
        while (cur != null) {
            if (i%2 == 0) {
                evenLast.next = cur;
                evenLast = evenLast.next;
            } else {
                oddLast.next = cur;
                oddLast = oddLast.next;
            }
            cur = cur.next;
            i++;
        }
        oddLast.next = evenFirst;
        evenLast.next = null;
        return head;
    }
}
