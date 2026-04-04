class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        // if(coins.length==1) {
        //     return amount>coins[0]&&amount%coins[0]==0?amount/coins[0]:-1;
        // }

        int[][] dp = new int[coins.length+1][amount+1];
        Arrays.fill(dp[0], amount+1);
        dp[0][0] = 0;

        for (int i = 1; i <=coins.length; i++) {
            for (int j = 0; j <=amount; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }

        return dp[coins.length][amount]==amount+1?-1:dp[coins.length][amount];   
    }
}
