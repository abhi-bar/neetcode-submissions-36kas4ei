class Solution {
    int max = 0;
    int x =0;

    public int maxAreaOfIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    calculate(grid,i,j,1,visited);
                    x = 0;
                }
            }
        }

        return max;
    }

    private void calculate(int[][] grid, int i, int j, int islands, boolean[][] visited){
        if(i<0 || j<0 || i> grid.length-1 || j> grid[0].length-1 || visited[i][j] || grid[i][j]==0){
            return ;
        }

        visited[i][j] = true;
        x++;
        max = Math.max(max, x);
        calculate(grid, i+1, j, islands+1, visited);
        calculate(grid, i-1, j, islands+1, visited);
        calculate(grid, i, j+1, islands+1, visited);
        calculate(grid, i, j-1, islands+1, visited);
    }
}
