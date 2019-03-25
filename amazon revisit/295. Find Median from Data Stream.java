class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        large=new PriorityQueue<>();
        small=new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(large.size()>small.size()){
            small.offer(num);
        }else{
            large.offer(num);
        }
        if(small.size()==0) return;
        while(large.peek()<small.peek()){
            int temp = small.poll();
            large.offer(temp);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size()==large.size()) return (double)(small.peek()+large.peek())/2;
        else return large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */