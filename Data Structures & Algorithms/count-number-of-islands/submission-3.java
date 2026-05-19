class Solution {
    public int numIslands(char[][] grid) {
        
        int num = 0;
        
        int r = grid.length;
        int c = grid[0].length;
        
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]=='1' && !visited[i][j]){
//                    explore
                    bfsTraversal(grid, visited, i, j, r, c);
                    num++;
                }
            }
        }
        
        return num;
    }
    
    private void bfsTraversal(char[][] grid, boolean[][] visited, int i, int j, int r, int c){
        if(i<0 || j<0 || i>=r || j>=c || visited[i][j] || grid[i][j]=='0'){
            return;
        }
        
        visited[i][j]= true;
        
        bfsTraversal(grid, visited, i+1, j, r, c);
        bfsTraversal(grid, visited, i-1, j, r, c);
        bfsTraversal(grid, visited, i, j-1, r, c);
        bfsTraversal(grid, visited, i, j+1, r, c);
    }
}
