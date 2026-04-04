class Solution {
    public int search(int[] nums, int target) {
        int l =0;
        int h = nums.length-1;

        while(l<=h){

            int mid = l + (h-l)/2;
            System.out.println(mid);

            if(target==nums[mid]){
                return mid;
            }

//            1st check sorted
            if(nums[l]<=nums[mid]){
//                2nd check position of target if in range
                if(target>=nums[l] && target<nums[mid]){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[h]){
                    l =  mid+1;
                }else {
                    h = mid-1;
                }
            }
        }

        return -1;
    }
}
