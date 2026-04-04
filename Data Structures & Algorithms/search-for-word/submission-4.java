class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length-1;
        int col = board[0].length-1;


//        This is the for loop normally used in Combination Backtracking type questions
        for (int r = 0; r <= row; r++) {
            for (int c = 0; c <= col; c++) {
                if (backtrack(board, word, new ArrayList<>(), r, c, row, col, new boolean[row+1][col+1])) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean backtrack(char[][] board, String word, List<Character> list, int r, int c, int row, int col, boolean[][] visited){
        if (r < 0 || c < 0 || r > row || c > col || visited[r][c])
            return false;

        list.add(board[r][c]);
        visited[r][c]=true;

        StringBuilder sb = new StringBuilder();
        for (char ch : list) sb.append(ch);
        String current = sb.toString();


        if (current.equals(word)) {
            System.out.println("Found: " + current);
            return true;
        }


            if(backtrack(board,word,list,r+1,c,row,col,visited)) return true;

            if(backtrack(board,word,list,r,c+1,row,col,visited)) return true;

            if(backtrack(board,word,list,r-1,c,row,col,visited)) return true;

            if(backtrack(board,word,list,r,c-1,row,col,visited)) return true;

            
        list.remove(list.size()-1);
        visited[r][c]=false;

        return false;
    }
}
