class Solution {
    public int searchInsert(int[] nums, int target) {
        int l =0;
        int r=nums.length-1;
        int m = 0;

        while(true){
            if(l>r) return l;
            m = l + (r-l)/2;
            System.out.println(nums[m]);

            if(nums[m]==target){
                return m;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        // return m;
    }
}