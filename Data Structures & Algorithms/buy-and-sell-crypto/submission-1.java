class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int eleLeft = 0;
        int profit  = 0;
        int profitG =0;

        while(left<prices.length-1){
            if(prices[eleLeft]>=prices[left+1]){
                eleLeft = left+1;
            }
            else if(prices[eleLeft]<prices[left+1]){
                profit = Math.max(profit, prices[left+1]-prices[eleLeft]);
            }

            left++;
        }

        return profit;
    }
}
