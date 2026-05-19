class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int area = 0;

        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    area = Math.max(area, bfsTraversalArea(grid, visited, i, j, r, c));
                }
            }
        }
        return area;

    }


    private int bfsTraversalArea(int[][] grid, boolean[][] visited, int i, int j, int r, int c){
        if(i<0 || j<0 || i>=r || j>=c || visited[i][j] || grid[i][j]==0){
            return 0;
        }

        visited[i][j]= true;

        return 1 +  bfsTraversalArea(grid, visited, i+1, j, r, c) +
                bfsTraversalArea(grid, visited, i-1, j, r, c) +
                bfsTraversalArea(grid, visited, i, j-1, r, c) +
                bfsTraversalArea(grid, visited, i, j+1, r, c);

    }
}
