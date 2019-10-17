// i dont know whats wrong with my ans time exceed



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        HashMap<Integer, List<ListNode>> hm = new HashMap<Integer, List<ListNode>>();
        for (ListNode a:lists){
            ListNode cur = a;
            while(cur!=null){
                if(!hm.containsKey(cur.val)){
                    List<ListNode> mList = new LinkedList<ListNode>();
                    mList.add(cur);
                    hm.put(cur.val,mList);
                }else{
                    hm.get(cur.val).add(cur);
                }
                cur = cur.next;
            }
        }
        Iterator iterator = hm.keySet().iterator();    
        int[] keylist = new int[hm.size()];
        int j = 0;
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            keylist[j]=temp;
            j++;
        }
        Arrays.sort(keylist);
        ListNode last=null;
        for(int a:keylist){
            List<ListNode> tempList = hm.get(a);
            int len = tempList.size();
            for(int i=0;i<len;i++){
                if(i==0 && a!=keylist[0]){
                    last.next = tempList.get(0);
                }
                if(i!=0){
                    tempList.get(--i).next = tempList.get(i);
                }
                if(i==len-1){
                    last = tempList.get(i);
                }
            }
        }
        return hm.get(keylist[0]).get(0);
    }
}



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(lists.length); 
        
        for(ListNode node : lists) {
            ListNode curr = node; 
            while(curr != null) {
                pq.offer(curr.val); 
                curr = curr.next; 
            }
        }
        
        ListNode head = new ListNode(-1); 
        ListNode curr = head; 
        while(!pq.isEmpty()) {
            curr.next = new ListNode(pq.poll()); 
            curr = curr.next; 
        }
        
        return head.next; 
    }
}