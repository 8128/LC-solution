// still dont know where is wrong with my code


import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int INF=Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int round=1;
        int size_x = rooms.length;
        int size_y = rooms[0].length;
        for(int x=0;x<size_x-2;x++){
            for(int y=0;y<size_y-2;y++){
                if(rooms[x][y]==INF){
                    helper(rooms, x, y, size_x, size_y, round);
                }
                round=1;
            }
        }
    }
    
    // the problem is the cursor may move between two positions forever
    public void helper(int[][] rooms, int x, int y, int size_x, int size_y, int round){
        Queue<int[]> q = new LinkedList<int[]>();
        int[] mlist = new int[] {x,y};
        q.offer(mlist);
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                int[] mlist2 = q.poll();
                int a = mlist2[0];
                int b = mlist2[1];
                if((a!=size_x && rooms[a+1][b]==0)||(b!=size_y && rooms[a][b+1]==0)||(a!=0 && rooms[a-1][b]==0)||(b!=0 && rooms[a][b-1]==0)){
                    rooms[a][b]=round;
                    break;
                } 
                if(a<size_x-2 && rooms[a+1][b]!=0 && rooms[a+1][b]!=-1){
                    int[] down = new int[] {a+1,b};   
                    q.offer(down);
                }
                if(b<size_y-2 && rooms[a][b+1]!=0 && rooms[a][b+1]!=-1){
                    int[] right = new int[] {a,b+1};   
                    q.offer(right);
                }
                if(a>0 && rooms[a+1][b]!=0 && rooms[a-1][b]!=-1){
                    int[] up = new int[] {a-1,b}; 
                    q.offer(up);
                }
                if(b>0 && rooms[a][b-1]!=0 && rooms[a][b-1]!=-1){
                    int[] left = new int[] {a,b-1};
                    q.offer(left);
                }
            }
            round++;        
        }
    }

}

public class Solution286 {
    public static void main(String[] args) {
        int[][] rooms = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        new Solution286().wallsAndGates(rooms);
    }
}


class Solution_official {
    
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    ); 
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}