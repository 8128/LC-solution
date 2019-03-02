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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length,(a,b)->(a.end-b.end));
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval temp = pq.poll();
            if(intervals[i].start>=temp.end){
                temp.end=intervals[i].end;
            }else{
                pq.offer(intervals[i]);
            }
            pq.offer(temp);
        }
        return pq.size();
    }
}