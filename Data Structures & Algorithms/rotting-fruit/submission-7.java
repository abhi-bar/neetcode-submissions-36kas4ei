class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int minutes = 0;

        while (!queue.isEmpty()){
            int s = queue.size();
            

            for (int i = 0; i < s; i++) {
                int[] poll = queue.poll();

                int row = poll[0];
                int col = poll[1];

                if(col-1>=0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    queue.add(new int[]{row,col-1});
                }
                
                if(col+1<m && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    queue.add(new int[]{row,col+1});
                }

                if(row+1<n && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    queue.add(new int[]{row+1,col});
                }

                if(row-1>=0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    queue.add(new int[]{row-1,col});
                }
                
                
            }

            if(queue.size()>0) minutes++;
           
        }

        System.out.println(minutes);


        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        
        return minutes;
        
    }
}
