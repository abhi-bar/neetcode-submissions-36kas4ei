class Solution {
    public int maxProduct(int[] nums) {
       int neg = 1;
        int pos = 1;

        int res = nums[0];

        for (int i = 0; i <nums.length ; i++) {
            int temp = pos*nums[i];

            pos = Math.max(pos*nums[i],Math.max(neg*nums[i],nums[i]));

            neg = Math.min(neg*nums[i],Math.min(temp, nums[i]));
            

            res = Math.max(res,pos);
        }
        
        return res;
    }
}
