/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0) return true;
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length,(a,b)->(a.start-b.start));
        for(int i=0;i<intervals.length;i++){
            pq.offer(intervals[i]);
        }
        Interval first = pq.poll();
        boolean ans = true;
        while(!pq.isEmpty()){
            Interval temp = pq.poll();
            ans = ans&&helper(first,temp);
            first = temp;
        }
        return ans;
    }
    
    public boolean helper(Interval a, Interval b){
        if(a.start==b.start) return false;
        return (a.end<=b.start);
    }
}