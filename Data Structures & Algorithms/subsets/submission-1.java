class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        list(nums,0,new ArrayList<>());
        return ans;
    }
    
    private void list(int[] nums, int index, List<Integer> list){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        List<Integer> pick = new ArrayList<>(list);
        pick.add(nums[index]);
        list(nums, index+1,pick);
        list(nums, index+1,list);
    }
}
