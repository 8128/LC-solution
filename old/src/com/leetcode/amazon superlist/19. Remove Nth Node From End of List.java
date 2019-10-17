/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode ans = head;
        if(head.next==null) return null;
        for(int i=0;i<n-1;i++){
            cur=cur.next;
        }
        if(cur.next==null) return head.next;
        cur=cur.next;
        while(cur.next!=null){
            cur=cur.next;
            ans=ans.next;
        }
        ListNode temp = ans.next;
        ans.next = ans.next.next;
        temp.next=null;
        return head;
    }
}