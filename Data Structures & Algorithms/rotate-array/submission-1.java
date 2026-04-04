class Solution {
    public void rotate(int[] nums, int k) {
        int temp = -1;
        while (k>0){
            for (int i = nums.length-1; i>0; i--) {
                if(i==nums.length-1){
                    temp = nums[0];
                    nums[0]=nums[nums.length-1];
                }
                if (i==1){
                    nums[i]=temp;
                }else {
                    nums[i] = nums[i - 1];
                }
            }
            k--;
        }
    }
}