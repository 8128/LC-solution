import java.util.*;

class Solution {
    int[] direc1 = new int[]{0,1,0,-1};
    int[] direc2 = new int[]{1,0,-1,0};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        if(m==0) return ans;
        int n = matrix[0].length;
        //if(m==0 || n==0) return new ArrayList<>();
        int[][] access = new int[m][n];
        int direct = 0;
        int x=0,y=0;
        for(int i=0;i<m*n;i++){
            //System.out.println("adding "+x+" "+y);
            ans.add(matrix[x][y]);
            access[x][y] = 1;
            //System.out.println("direction"+direct);
            if((x+direc1[direct])==-1 || (y+direc2[direct])==-1 || (x+direc1[direct])==m || (y+direc2[direct])==n || access[x+direc1[direct]][y+direc2[direct]]==1){
                direct = direction(direct);
            } 
            x = x+direc1[direct];
            y = y+direc2[direct];
        }
        return ans;
    }
    
    public int direction(int i){
        switch(i){
            case 0: 
                return 1;
            case 1: 
                return 2;
            case 2: 
                return 3;
            case 3:
                return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution mSolution = new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(mSolution.spiralOrder(matrix));
    }
}