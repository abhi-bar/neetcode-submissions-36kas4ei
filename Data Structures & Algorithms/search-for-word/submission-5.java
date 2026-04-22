class Solution {
    public boolean exist(char[][] board, String word) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(pp(board,new boolean[board.length][board[0].length], i,j,word,new StringBuilder())){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean pp(char[][] board, boolean[][] visited, int i, int j, String word, StringBuilder sb){
        if(sb.toString().equals(word)){
            return true;
        }

        if(sb.length()>word.length() || i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || visited[i][j]){

            return false;
        }

        visited[i][j] = true;
        sb.append(board[i][j]);



        if(pp(board,visited,i-1,j,word,sb) ||
                pp(board,visited,i+1,j,word,sb) ||
                pp(board,visited,i,j-1,word,sb) ||
                pp(board,visited,i,j+1,word,sb)) return true;

        visited[i][j]=false;
        sb.deleteCharAt(sb.length()-1);

        return false;
    }
}
