class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src]=0;

        while(k>=0){
            int[] tmp = Arrays.copyOf(prices,n);
            k--;
            for(int[] flight:flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                if(prices[s]==Integer.MAX_VALUE){
                    continue;
                }

                if(tmp[d]>prices[s]+p){
                    tmp[d]=prices[s]+p;
                }
            }
            prices= tmp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
