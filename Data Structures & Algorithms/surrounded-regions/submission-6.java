class Solution {
    public void solve(char[][] board) {
        
        int r = board.length;
        int c = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < c; i++) {
//            qAtl.add(new int[]{0, i});
//            qPtl.add(new int[]{r-1, i});
            if(board[0][i]=='O'){
                queue.add(new int[]{0,i});
            }
            if(board[r-1][i]=='O'){
                queue.add(new int[]{r-1,i});
            }
        }

        for (int i = 0; i < r; i++) {
//            qAtl.add(new int[]{i,0});
//            qPtl.add(new int[]{i,c-1});
            if(board[i][0]=='O'){
                queue.add(new int[]{i,0});
            }
            if(board[i][c-1]=='O'){
                queue.add(new int[]{i,c-1});
            }
        }
        
        makeI(board,queue, r, c);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if (board[i][j]=='I'){
                    board[i][j]='O';
                }
            }
        }
    }
    
    private void makeI(char[][] board, Queue<int[]> queue, int r, int c){
        
        while (!queue.isEmpty()){
            
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];

                board[row][col] = 'I';
                
                if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                    queue.add(new int[]{row - 1, col});
                }
                if (row + 1 <r && board[row + 1][col] == 'O') {
                    queue.add(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && board[row][col-1] == 'O') {
                    queue.add(new int[]{row, col-1});
                }
                if (col + 1 < c && board[row][col+1] == 'O') {
                    queue.add(new int[]{row, col+1});
                }
            }
        }
    }
}
