class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n= nums.length;
        return Math.max(helper(Arrays.copyOfRange(nums,0,n-1)), helper(Arrays.copyOfRange(nums,1,n)));
    }

    private int helper(int[] nums){
        int n = nums.length;
        if (n <= 2) {
            if(n==1) return nums[0];
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[0] + nums[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-3], dp[i-2])+nums[i];
        }

        return Math.max(dp[n-1],dp[n-2]);
    }
}
