class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums,0,target,0,new ArrayList<>());
        return ans;
    }
    List<List<Integer>> ans = new ArrayList<>();

    private void helper(int[] nums, int index, int target, int sum, List<Integer> list){
        if(sum>=target){
            if(sum==target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,i,target,sum+nums[i],list);
            list.removeLast();
        }
    }
}
