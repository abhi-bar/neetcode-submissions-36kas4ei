class Solution {
    public int maxSubArray(int[] nums) {
        int gmax = Integer.MIN_VALUE;
        int lmax = gmax;

        lmax = nums[0];
        gmax = nums[0];

        for(int i=1;i<nums.length;i++){
            lmax = Math.max(nums[i], lmax+nums[i]);
            gmax = Math.max(gmax, lmax);
        }

        // gmax = Math.max(gmax, lmax);

        return gmax;
    }
}
