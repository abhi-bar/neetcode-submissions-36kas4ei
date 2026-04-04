class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

Arrays.fill(dp, amount+1);
        dp[0]=0;

//        Lets assume coin is sorted
//        Arrays.sort(coins);

        for (int i = 1; i <=amount; i++) {
            for(Integer c: coins){
                if(c<=i){
                    dp[i]= Math.min(1 + dp[i-c], dp[i]);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
