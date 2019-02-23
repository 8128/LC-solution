/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2=l2, pre = new ListNode(-1), cur=pre;
        while(cur1!=null && cur2!=null){
            if(cur1.val > cur2.val){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }else{
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        if(cur1!=null){
            cur.next = cur1;
        }
        if(cur2!=null){
            cur.next=cur2;
        }
        return pre.next;
    }
}