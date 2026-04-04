class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;

        int min = Integer.MAX_VALUE;
        while(l<=h){
            int mid = l + (h-l)/2;
            System.out.println(nums[mid]);
            min = Math.min(min, nums[mid]);
            if(nums[h]<nums[mid]){
                l = mid+1;
            }
            else {
                h = mid-1;
            }
        }

        return min;
    }
}
