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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null) return intervals;
        for(int i=0;i<intervals.size()-1;i++){
            System.out.println(i+"  "+ (intervals.size()-1));
            if(intervals.get(i).start>intervals.get(i+1).start ||(intervals.get(i).start==intervals.get(i+1).start)&&(intervals.get(i).end>intervals.get(i+1).end) ){
                    Interval temp = intervals.get(i);
                    intervals.set(i,intervals.get(i+1));
                    intervals.set(i+1,temp);
                    i--;
                    if(i>=0) i--;
            }else if(helper(intervals.get(i), intervals.get(i+1))!=null){
                    intervals.set(i,helper(intervals.get(i), intervals.get(i+1)));
                    intervals.remove(i+1);
                    i--;
                    if(i>=0) i--;
            }
        }
        return intervals;
    }
    
    public Interval helper(Interval a, Interval b){            
        if(a.end>=b.start){
            return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
        }else{
            return null;
        }
    }
}