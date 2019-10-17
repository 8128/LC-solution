class TicTacToe {
    int[] player1;
    int[] player2;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        player1 = new int[2*n+2];
        player2 = new int[2*n+2];
        Arrays.fill(player1,n);
        Arrays.fill(player2,n);
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player==1){
            player1[row]--;
            player1[n+col]--;
            if(col==row) player1[2*n]--;
            if(col+row==n-1) player1[2*n+1]--;
            if(player1[row]==0 || player1[n+col]==0 || player1[2*n]==0 || player1[2*n+1]==0) return 1;
        }else{
            player2[row]--;
            player2[n+col]--;
            if(col==row) player2[2*n]--;
            if(col+row==n-1) player2[2*n+1]--;
            if(player2[row]==0 || player2[n+col]==0 || player2[2*n]==0 || player2[2*n+1]==0) return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */