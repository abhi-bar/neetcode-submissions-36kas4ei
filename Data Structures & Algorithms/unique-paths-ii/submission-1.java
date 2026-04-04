class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        
        int[][] dp = new int[r+1][c+1];
        dp[0][0]=1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(j>0 && obstacleGrid[i][j-1]!=1){
                    dp[i][j] += dp[i][j-1];
                }
                if(i>0 && obstacleGrid[i-1][j]!=1){
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        return dp[r-1][c-1];
    }
}