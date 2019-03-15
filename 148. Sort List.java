/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode cur1=head;
        ListNode cur2=cur1.next;
        ListNode prev=null;
        while(cur2!=null){
            if(cur2.val<cur1.val){
                if(prev==null){
                    cur1.next = cur2.next;
                    cur2.next = cur1;
                    ListNode temp = cur1;
                    cur2 = temp;
                    cur1 = cur2;
                }else{
                    pre.next = cur2;
                    cur1.next = cur2.next;
                    cur2.next = cur1;
                }
            }
            cur2=cur2.next;
            cur1=cur1.next;
            prev = cur1;
        }
    }
}