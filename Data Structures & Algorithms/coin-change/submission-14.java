class Solution {
    public int coinChange(int[] coins, int amount) {
        int l = coins.length;

        int[][] dp = new int[l+1][amount+1];

        for (int i = 1; i <=amount ; i++) {
            dp[0][i] = 9999;
        }

        for (int i = 1; i <=l ; i++) {
            for (int j = 1; j <=amount ; j++) {

                dp[i][j] = dp[i-1][j];

                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        return dp[l][amount]>=9999?-1:dp[l][amount];  
    }
}
