class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    
                }
            }
        }
        calculate(queue, grid, r, c);

    }
    private void calculate(Queue<int[]> queue, int[][] grid, int r, int c){
        int distance = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            distance++;

            for (int i = 0; i < n; i++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];

//                queue.add
//                check current and calculated distance
//                check valid block
                // distance++;

                if(row-1>=0 && grid[row-1][col]>distance){
                    grid[row-1][col] = Math.min(grid[row-1][col], distance);
                    queue.add(new int[]{row-1,col});
                }
                if(row+1<r && grid[row+1][col]>distance){
                    grid[row+1][col] = Math.min(grid[row+1][col], distance);
                    queue.add(new int[]{row+1,col});
                }
                if(col-1>=0 && grid[row][col-1]>distance){
                    grid[row][col-1] = Math.min(grid[row][col-1], distance);
                    queue.add(new int[]{row,col-1});
                }
                if(col+1<c && grid[row][col+1]>distance){
                    grid[row][col+1] = Math.min(grid[row][col+1], distance);
                    queue.add(new int[]{row,col+1});
                }

            }
        }
    }
}
