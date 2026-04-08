class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list(nums, 0, new ArrayList<>(), 0, target);
        return ans;
    }


    List<List<Integer>> ans = new ArrayList<>();
    
    private void list(int[] nums, int index, List<Integer> list, int sum, int target){
        if(sum==target){
            ans.add(new ArrayList<>(list));
        }
        if(index==nums.length || sum>target){
            return;
        }
        
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            list(nums, i, list, sum+nums[i], target);
            list.removeLast();
        }
    }
}
