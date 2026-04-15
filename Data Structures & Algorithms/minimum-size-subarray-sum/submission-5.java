class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=0;

        int sum=nums[l];
        int size = Integer.MAX_VALUE;

        while (l != nums.length ) {

            if (sum >= target) {
                size = Math.min(size, r - l +1 );
                sum -= nums[l];
                l++;
            } else {
                if (r < nums.length - 1) {
                    r++;
                    sum += nums[r];
                }else {
                    break;
                }
            }

        }
        return size==Integer.MAX_VALUE?0:size;
    }
}