class Solution {
        List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0);
        return ans;
    }

    private void helper(int[] nums, int index){
        if(index==nums.length){
            List<Integer> list1 = new ArrayList<>();
            for(int i:nums){
                list1.add(i);
            }
            if(!ans.contains(list1)) ans.add(new ArrayList<>(list1));
        }

        for(int i=index; i<nums.length; i++){
            // Swaping makes it useless
            // if(i>index && nums[i]==nums[i-1])continue;
            swap(nums,i,index);
            helper(nums,index+1);
            swap(nums,i,index);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}