class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,nums.length,0, new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    private void helper(int[] nums, int n, int index, List<Integer> list){
        if(index>n){
            return;
        }
        if (!ans.contains(list)) {
            ans.add(new ArrayList<>(list));
        }
        

        for (int i = index; i <n ; i++) {
            list.add(nums[i]);
            helper(nums,n,i+1,list);
            list.removeLast();
        }
    }
}
