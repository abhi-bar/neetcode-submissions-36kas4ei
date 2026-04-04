class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0, nums[0]);
    }

    private boolean helper(int[] nums, int index, int element){
        if(index>=nums.length-1 || element>=nums.length-index){
            return true;
        }

        if(element==0){
            return false;
        }

        if(element<2){
            return helper(nums, index+1, nums[index+1]);
        }
        else {

            for(int i = element; i>0 ;i--){
                if(helper(nums, index+i ,nums[i+index])){
                    return true;
                }
            }
            return false;
        }

    }
}
