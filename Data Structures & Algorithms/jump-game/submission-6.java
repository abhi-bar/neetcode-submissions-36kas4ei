class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<2){
            return true;
        }
        if(nums.length==2){
            return nums[0]>0;
        }

        int current = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=current-i){
                current=i;
            }
        }

        return current==0;
    }
}
