class Solution {
    public int[] productExceptSelf(int[] nums) {
       boolean zero = false;
        int prod = 1;
        int ip = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                ip++;
                zero = true;
                continue;
            }
            prod *= nums[i];

        }
        if(ip== nums.length || ip>1){
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if(zero && nums[i]==0){
                nums[i] = prod;
            }
            else if(zero && nums[i]!=0){
                nums[i] = 0;
            }
            else{
                nums[i] = prod/nums[i];
            }
        }

        return nums;
    }
}  
