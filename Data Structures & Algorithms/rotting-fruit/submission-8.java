class Solution {
    public int orangesRotting(int[][] grid) {
        int results = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int min = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];


                if(row>0 && grid[row-1][col]==1){
                    grid[row-1][col] = 2;
                    queue.add(new int[]{row-1,col});
                }
                if(row<grid.length-1 && grid[row+1][col]==1){
                    grid[row+1][col] = 2;
                    queue.add(new int[]{row+1,col});
                }
                if(col>0 && grid[row][col-1]==1){
                    grid[row][col-1] = 2;
                    queue.add(new int[]{row,col-1});
                }
                if(col<grid[0].length-1 && grid[row][col+1]==1){
                    grid[row][col+1] = 2;
                    queue.add(new int[]{row,col+1});
                }

            }
            if(!queue.isEmpty()) min++;
        }

        int m = grid[0].length;


        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return min;

    }
}
