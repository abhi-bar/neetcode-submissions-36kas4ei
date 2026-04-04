class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        boolean visited[][] = new boolean[row][col];
        int islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && grid[i][j]=='1'){
                    findUsingDfs(grid,i,j,visited,row,col);
                    islands++;
                }
            }
        }
        return islands;
        
    }
    
    private void findUsingDfs(char[][] graph, int i, int j, boolean[][] visited, int limitR, int limitC){
        if(i<0 || i>limitR-1 || j<0 || j>limitC-1 || visited[i][j] || graph[i][j]=='0'){
            return;
        }

        visited[i][j] = true;
        findUsingDfs(graph, i+1, j, visited, limitR, limitC);
        findUsingDfs(graph, i-1, j, visited, limitR, limitC);
        findUsingDfs(graph, i, j+1, visited, limitR, limitC);
        findUsingDfs(graph,i,j-1,visited,limitR,limitC);
    }
}
