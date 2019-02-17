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



public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}