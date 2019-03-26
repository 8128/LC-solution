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
              dfs(tempi,tempj,grid);
          }
      }
  }
}