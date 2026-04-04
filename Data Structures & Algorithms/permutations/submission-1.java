class Solution {
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return list;
    }
    List<List<Integer>> list = new ArrayList<>();

    private void helper(int[] nums, int index){
        if(index==nums.length-1){
            List<Integer> list1 = new ArrayList<>();
            for(int i:nums){
                list1.add(i);
            }
            list.add(new ArrayList<>(list1));
        }
        for(int i=index;i< nums.length;i++){
            swap(nums,i,index);
            helper(nums, index+1);
            swap(nums,i,index);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
