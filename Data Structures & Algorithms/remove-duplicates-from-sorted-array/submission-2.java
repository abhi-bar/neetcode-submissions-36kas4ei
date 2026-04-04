class Solution {
    public int removeDuplicates(int[] nums) {
        int l =0;
        int r = 1;

        int count = 0;

        while (l<nums.length-1){
            if((l+count)==nums.length-1)break;
            if(r==nums.length){
                l+=1;
                r=l+1;
            }
            else if(r<nums.length && nums[r]==nums[l]){
                count++;
                leftShift(nums, r);
            }else{
                r++;
            }
        }

        System.out.println(count);

        System.out.println(nums.length-count);
        return nums.length-count;
    }

    private void leftShift(int[] nums, int i){
        while (i<nums.length-1){
            nums[i]=nums[i+1];
            i++;
        }
    }
}