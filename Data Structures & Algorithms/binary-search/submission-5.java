class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

//        int mid = (l + r-1)/2;
        if(l==r){
            return nums[l]==target?0:-1;
        }

        while(l<=r){
            int mid = (l + r)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return -1;
    }
}
