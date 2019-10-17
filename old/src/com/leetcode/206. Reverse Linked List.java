/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(null,head);
    }
    
    public ListNode helper(ListNode first,ListNode second){
        if(second==null){
            return first;
        }
        ListNode next = second.next;
        second.next = first;
        return helper(second,next);
    }
}