package com.v.amazon.VO;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-03 06:12
 * @leetcode :  https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * @timeComplexity :
 * @spaceComplexity :
 */
public class ConvertBSTtoSortedDoublyLinkedList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        LinkedList<Integer> ll = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ll.add(cur.val);
            cur = cur.right;
        }
        Node fake = new Node(-1);
        fake.right = new Node(ll.get(0));
        cur = fake.right;
        Node prev = cur;
        for (int i = 1; i < ll.size(); i++) {
            cur = new Node(ll.get(i));
            cur.left = prev;
            prev.right = cur;
            prev = cur;
        }
        prev.right = fake.right;
        fake.right.left = prev;
        fake.right = null;
        return prev.right;
    }

    public static void main(String[] args) {
        ConvertBSTtoSortedDoublyLinkedList convertBSTtoSortedDoublyLinkedList = new ConvertBSTtoSortedDoublyLinkedList();
        Node n1 = convertBSTtoSortedDoublyLinkedList.new Node(1);
        Node n2 = convertBSTtoSortedDoublyLinkedList.new Node(2);
        Node n3 = convertBSTtoSortedDoublyLinkedList.new Node(3);
        Node n4 = convertBSTtoSortedDoublyLinkedList.new Node(4);
        Node n5 = convertBSTtoSortedDoublyLinkedList.new Node(5);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        System.out.println(convertBSTtoSortedDoublyLinkedList.treeToDoublyList(n4));
    }
}
