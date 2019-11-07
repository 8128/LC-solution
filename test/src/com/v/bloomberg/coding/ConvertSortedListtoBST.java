package com.v.bloomberg.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-07 01:42
 * @leetcode : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * @timeComplexity : NlogN
 * @spaceComplexity : logN
 */
public class ConvertSortedListtoBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    public TreeNode sortedListToBST(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }






    //  O(n)
    public TreeNode sortedListToBST1(ListNode head) {

        List<Integer> values = new ArrayList<Integer>();

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        // Convert the array to
        return convertListToBST(0, values.size() - 1, values);
    }

    private TreeNode convertListToBST(int left, int right, List<Integer> values) {
        // Invalid case
        if (left > right) {
            return null;
        }

        // Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        // Base case for when there is only one element left in the array
        if (left == right) {
            return node;
        }

        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid - 1, values);
        node.right = convertListToBST(mid + 1, right, values);
        return node;
    }
}
