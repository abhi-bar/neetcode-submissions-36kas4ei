class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] output = new int[nums.length];
        output[0] = nums[0];
        int post = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = nums[i]*output[i-1];
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            if(i==0){
                output[i] = post;
                break;
            }
            output[i] = post*output[i-1];
            post *= nums[i];
        }

        return output;
    }
}  
