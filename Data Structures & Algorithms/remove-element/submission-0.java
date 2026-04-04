class Solution {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
//            it also needs right shift
            if(nums[i]==val) count--;
        }
        int l=0;
        int r=0;
        
        while (l<nums.length && r<nums.length){
            if(nums[l]!=val && nums[r]!=val){
                l++;
                r++;
            } else if (l<nums.length && nums[l] == val) {
                while (r<nums.length-1 && nums[r] == val) {
                    r++;
                }
                nums[l] = nums[r];
                nums[r] = val;
                l++;
            }
            
        }
        System.out.println(count);
        return count;
    }
}