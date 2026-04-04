class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] dp = new int[r][c];
//        dp[0][0] = grid[][]

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = grid[i][j];
                if(i==0 && j==0)continue;
                int left = Integer.MAX_VALUE;
                if(i>0){
                    left = dp[i-1][j];
                }
                int right = Integer.MAX_VALUE;
                if(j>0){
                    right = dp[i][j-1];
                }
                dp[i][j] += Math.min(right, left);
            }
        }
        return dp[r-1][c-1];    
    }
}