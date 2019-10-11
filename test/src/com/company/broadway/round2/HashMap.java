package com.company.broadway.round2;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-08 03:41
 */
public class HashMap {

    ListNode[] nodes = new ListNode[10000];

    int index(int key) { return key % nodes.length;}

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(int key, int value) {
        int i = index(key);
        if (nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int i = index(key);
        if (nodes[i] == null) {
            return -1;
        }
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = index(key);
        if (nodes[i] == null) {
            return;
        }
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    ListNode find(ListNode node, int key) {
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
