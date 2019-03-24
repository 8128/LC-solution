class Solution {
    int[] direction1 = new int[]{1,0,0,-1};
    int[] direction2 = new int[]{0,1,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length==0 && image[0].length==0) return image;
        if(newColor == image[sr][sc]) return image;
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,newColor,oldColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        image[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            int tempsr=sr+direction1[i];
            int tempsc=sc+direction2[i];
            if(tempsr>=0 && tempsc>=0 && tempsr<image.length && tempsc<image[0].length && image[tempsr][tempsc]==oldColor){
                dfs(image,tempsr,tempsc,newColor,oldColor);
            }
        }
    }
}