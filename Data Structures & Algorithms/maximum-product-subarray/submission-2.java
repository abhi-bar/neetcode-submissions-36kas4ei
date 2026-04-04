class Solution {
    public int maxProduct(int[] nums) {
        int curMin = 1;
        int curMax = 1;

        int res = nums[0];

        for(int num:nums){
            int temp = curMax * num;
            curMax = Math.max(Math.max(curMax*num, num*curMin), num);
            curMin = Math.min(num, Math.min(temp, num*curMin));
            res = Math.max(res,curMax);
        }
        return res;
    }
}
