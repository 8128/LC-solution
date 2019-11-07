package com.v.bloomberg.coding;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 16:48
 * @leetcode : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    // recursion
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    private Node helper(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child == null) {
            if (head.next == null) {
                return head;
            }
            return helper(head.next);
        }
        else {
            Node child = head.child;
            head.child = null;
            Node next = head.next;
            Node childtail = helper(child);
            head.next = child;
            child.prev = head;
            if (next != null) {
                childtail.next = next;
                next.prev = childtail;
                return helper(next);
            }
            return childtail;
        }
    }

    // it went through the whole tree, first combine one level, and then go to the child and combine another
    public Node flatten1(Node head) {
        if( head == null) {
            return head;
        }
        // Pointer
        Node p = head;
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null ) {
                temp = temp.next;
            }
            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if( p.next != null ) {
                p.next.prev = temp;
            }
            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
