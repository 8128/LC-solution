class Solution {
    public:
        int maximalRectangle(vector<vector<char> > &matrix) {
            if(matrix.empty()) return 0;
            const int m = matrix.size();
            const int n = matrix[0].size();
            int left[n], right[n], height[n];
            fill_n(left,n,0); fill_n(right,n,n); fill_n(height,n,0);
            int maxA = 0;
            for(int i=0; i<m; i++) {
                int cur_left=0, cur_right=n; 
                for(int j=0; j<n; j++) { // compute height (can do this from either side)
                    if(matrix[i][j]=='1') height[j]++; 
                    else height[j]=0;
                }
                for(int j=0; j<n; j++) { // compute left (from left to right)
                    if(matrix[i][j]=='1') left[j]=max(left[j],cur_left);
                    else {left[j]=0; cur_left=j+1;}
                }
                // compute right (from right to left)
                for(int j=n-1; j>=0; j--) {
                    if(matrix[i][j]=='1') right[j]=min(right[j],cur_right);
                    else {right[j]=n; cur_right=j;}    
                }
                // compute the area of rectangle (can do this from either side)
                for(int j=0; j<n; j++)
                    maxA = max(maxA,(right[j]-left[j])*height[j]);
            }
            return maxA;
        }
    };



// trash solution
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        if(matrix[0].length==0) return 0;
        int ans=0;
        int[] line = new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            line[i] = matrix[0][i]-'0';
        }  
        ans = helper(line);
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==matrix[i-1][j]&&matrix[i][j]!='0'){
                    line[j]++;
                }else if(matrix[i][j]=='0'){
                    line[j]=0;
                }else{
                    line[j]=1;
                }
            }
            int temp = helper(line);
            ans = Math.max(ans,temp);
        }
        return ans;
    }
    
    public int helper(int[] line){
        int large=0;
        for(int i=0;i<line.length;i++){
            for(int j=i;j<line.length;j++){
                int m=i;
                int min = Integer.MAX_VALUE;
                while(m!=j+1){
                    min=Math.min(line[m],min);
                    m++;
                }
                large = Math.max(large,min*(j-i+1));
            }
        }
        return large;
    }
}