/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        HashSet hs = new HashSet();
        ListNode curA = headA;
        ListNode curB = headB;
        hs.add(curA);
        if(!hs.add(curB)){
            return curA;
        }
        while(curA.next!=null){
            if(!hs.add(curA.next)){
                return curA.next;
            }
            curA = curA.next;
        }
        while(curB.next!=null){
            if(!hs.add(curB.next)){
                return curB.next;
            }
            curB = curB.next;
        }
        return null;
    }
}