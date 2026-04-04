class Solution {
     List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        bitchAssHelper(new ArrayList<>(), nums, 0);
        return list;
    }

    private void bitchAssHelper(List<Integer> list, int[] nums, int index){
        if(list.size()==nums.length){
            this.list.add(new ArrayList<>(list));
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,i,index);
            bitchAssHelper(list,nums,index+1);
            helper(nums,i,index);
            list.removeLast();
        }
    }

    private void helper(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
