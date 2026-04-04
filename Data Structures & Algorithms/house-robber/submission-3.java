class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        // if(nums.len)
        int n= nums.length;
        int[] dp = new int[n];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max((nums[i]+dp[i-2]),dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));

        return dp[n-1];
    }
}
