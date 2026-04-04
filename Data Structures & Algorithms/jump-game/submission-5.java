class Solution {
    public boolean canJump(int[] nums) {
        return helper2(nums);
    }

//    with algo
    public boolean helper2(int[] nums){
        if(nums.length==1) return true;
        int target = nums.length-1;

        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]>=target-i){
                if(i==0) return true;
                target = i;
            }
        }
        return false;
    }
}
