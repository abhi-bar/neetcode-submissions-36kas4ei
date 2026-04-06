class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]=='1' && !visited[i][j]){
                    makeVisited(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void makeVisited(char[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 ||
                grid[i][j]=='0' || visited[i][j]){
            return;
        }
        
        visited[i][j] = true;
        makeVisited(grid,visited,i+1,j);
        makeVisited(grid,visited,i,j+1);
        makeVisited(grid,visited,i-1,j);
        makeVisited(grid,visited,i,j-1);
    }
}
