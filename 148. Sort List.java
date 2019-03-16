class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head.next==null){
          //System.out.println(head.val);
          return head;
        } 
        ListNode dummy = new ListNode(0);
        if(head.next.next==null){
            head.next.next = dummy;
        } 
        ListNode prev = head, middle = head, end = head;
        while(end.next.next!=null){
            prev = middle;
            end = end.next.next;
            middle = middle.next;
            if(end.next==null) break;
        }
        if(head.next.next==dummy) head.next.next=null;
        prev.next=null;
        return mergeSort(sortList(head),sortList(middle));
    }
    
    public ListNode mergeSort(ListNode first, ListNode second) {
        ListNode head;
        if(first.val>second.val){
            head = second;
            second = second.next;
        }else{
            head = first;
            first = first.next;
        }
        ListNode prev = head;
        while(first!=null && second!=null){
            if(first.val>second.val){
                prev.next = second;
                second = second.next;
                prev = prev.next;
            }else{
                prev.next = first;
                first = first.next;
                prev = prev.next;
            } 
        }
        while(first==null && second!=null){
            prev.next = second;
            second = second.next;
            prev = prev.next;
        }
        while(first!=null && second==null){
            prev.next = first;
            first = first.next;
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
      Solution mSolution = new Solution();
      Solution.ListNode one = mSolution.new ListNode(1);
      Solution.ListNode two = mSolution.new ListNode(2);
      Solution.ListNode three = mSolution.new ListNode(3);
      Solution.ListNode four = mSolution.new ListNode(4);
      // ListNode one = new ListNode(1);
      // ListNode one = new ListNode(1);
      // ListNode one = new ListNode(1);
      four.next = two;
      two.next = one;
      one.next = three;
      ListNode res = mSolution.sortList(four);
      while(res!=null){
        System.out.println(res.val);
        res = res.next;
      }
    }
}