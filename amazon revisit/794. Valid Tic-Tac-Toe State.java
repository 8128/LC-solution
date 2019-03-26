class Solution {
    public boolean validTicTacToe(String[] board) {
        int n = board.length;
        int[] py1 = new int[2*n+2];
        int[] py2 = new int[2*n+2];   
        int py1count=0;
        int py2count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i].charAt(j)=='X'){
                    py1count++;
                    py1[i]++;
                    py1[n+j]++;
                    if(i==j) py1[2*n]++;
                    if(i+j+1==n) py1[2*n+1]++;
                }else if(board[i].charAt(j)=='O'){
                    py2count++;
                    py2[i]++;
                    py2[n+j]++;
                    if(i==j) py2[2*n]++;
                    if(i+j+1==n) py2[2*n+1]++;
                }
            }
        }
        int counter1=0,counter2=0;
        for(int i=0;i<2*n+2;i++){
            if(py1[i]==n) counter1++;
            if(py2[i]==n) counter2++;
        }
        if(counter1>0 && counter2>0) return false;
        if(counter1==1 && py1count!=py2count+1) return false;
        if(counter2==1 && py1count!=py2count) return false;
        if(py1count!=py2count && py1count!=py2count+1) return false;
        return true;
    }
}