class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int ret = -1;

        while (l<=r){
            int mid = l+((r-l)/2);

            if(target==nums[mid]) {
                System.out.println(mid);
                ret = mid;
                break;
            }

//            right sorted
            if(nums[mid]<nums[r]){
                if(target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }

//            left sorted
            else {
                if(nums[l]<=target && target<nums[mid]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }

        }
        return ret;
    }
}
