import java.util.*;

class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode prev = fake;
        ListNode first = head;
        for(int i=0;i<m-1;i++){
            prev = prev.next;
            first = first.next;
        }
        //System.out.println(prev.val);
        ListNode oldnext = first;
        ListNode newnext = oldnext.next;
        for(int j=0;j<(n-m);j++){
            System.out.println("exe");
            System.out.println(newnext);
            System.out.println(oldnext);
            prev.next = newnext;
            newnext = newnext.next;
            prev.next.next = oldnext;
            oldnext = prev.next;
        }
        first.next = newnext;
        return fake.next;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        Solution.ListNode a1 = mSolution.new ListNode(1);
        Solution.ListNode a2 = mSolution.new ListNode(2);
        Solution.ListNode a3 = mSolution.new ListNode(3);
        Solution.ListNode a4 = mSolution.new ListNode(4);
        Solution.ListNode a5 = mSolution.new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        Solution.ListNode ans = mSolution.reverseBetween(a1, 2, 4);
        while(ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}