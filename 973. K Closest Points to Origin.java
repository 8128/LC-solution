class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        if(K==0 || points.length==0) return ans;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(points.length, (a,b)->(a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]));
        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
        }
        for(int i=0;i<K;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}