// class Solution {
//   void dfs(char[][] grid, int r, int c) {
//     int nr = grid.length;
//     int nc = grid[0].length;

//     if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
//       return;
//     }

//     grid[r][c] = '0';
//     dfs(grid, r - 1, c);
//     dfs(grid, r + 1, c);
//     dfs(grid, r, c - 1);
//     dfs(grid, r, c + 1);
//   }

//   public int numIslands(char[][] grid) {
//     if (grid == null || grid.length == 0) {
//       return 0;
//     }

//     int nr = grid.length;
//     int nc = grid[0].length;
//     int num_islands = 0;
//     for (int r = 0; r < nr; ++r) {
//       for (int c = 0; c < nc; ++c) {
//         if (grid[r][c] == '1') {
//           ++num_islands;
//           dfs(grid, r, c);
//         }
//       }
//     }

//     return num_islands;
//   }
// }

import java.util.Arrays;

class Solution {

  int[] direction1 = new int[]{0,1,-1,0};
  int[] direction2 = new int[]{1,0,0,-1};
  boolean[][] color;

  public int numIslands(char[][] grid) {
      if(grid.length==0 || grid[0].length==0) return 0;
      color = new boolean[grid.length][grid[0].length];
      for(boolean temp[]: color){
          Arrays.fill(temp,false);
      }
      int count=0;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              System.out.println(color[i][j]);
              if(color[i][j]==false && grid[i][j]=='1'){
                  count++;
                  dfs(i,j,grid);
              }
          }
      }
      return count;
  }
  
  public void dfs(int i,int j, char[][] grid){
      for(int k=0;k<4;k++){
          int tempi = i+direction1[k];
          int tempj = j+direction2[k];
          if(tempi<0 || tempi>=grid.length || tempj<0 || tempj>=grid[0].length) continue;
          if(color[tempi][tempj]==false && grid[tempi][tempj]=='1'){
              color[tempi][tempj]=true;
              System.out.println(tempi+" "+tempj+" "+color[tempi][tempj]);
              dfs(tempi,tempj,grid);
          }
      }
  }

  public static void main(String[] args) {
    Solution mSolution = new Solution();
    char[][] temp = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    System.out.println(mSolution.numIslands(temp));
  }
}