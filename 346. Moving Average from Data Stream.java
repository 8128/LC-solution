class MovingAverage {
    Queue<Integer> q = new LinkedList<Integer>();
    int msize, sum=0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        msize=size;
    }
    
    public double next(int val) {
        if (q.size()<msize){
            q.offer(val);
            sum+=val;
        }else{
            sum-=q.poll();
            q.offer(val);
            sum+=val;
        }
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
